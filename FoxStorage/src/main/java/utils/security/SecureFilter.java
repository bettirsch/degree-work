package utils.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import repository.util.BaseRepositoryImpl;
import utils.enums.UserRoles;

@Provider
@Secure
@Priority(Priorities.AUTHENTICATION)
public class SecureFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String token;
		Key secretKey;
		//authentication
		try {
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			token = authorizationHeader.substring("Bearer".length()).trim();
			secretKey = KeyGen.getSecretKey();
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
		} catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.PROXY_AUTHENTICATION_REQUIRED)
					.entity("Please login").build());
			return;
		}
		//authorization
		try {
			UserRoles[] rolesAllowed = getAllowedRolesFromSecureAnnotation();
			isRoleAllowed(secretKey, token, Arrays.asList(rolesAllowed));
		} catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
					.entity("Not allowed path").build());
		}

	}

	private UserRoles[] getAllowedRolesFromSecureAnnotation() {
		Secure secure;
		Method resourceMethod = resourceInfo.getResourceMethod();
		if (resourceMethod != null) {
			secure = resourceMethod.getAnnotation(Secure.class);
		} else {
			Class<?> resourceClazz = resourceInfo.getResourceClass();
			secure = resourceClazz.getAnnotation(Secure.class);
		}
		return secure.roleNames();
	}

	private void isRoleAllowed(Key secretKey, String token, List<UserRoles> rolesAllowed) throws Exception {
		// all authenticated user can access visitor annotated resources
		if (rolesAllowed.contains(UserRoles.VISITOR)) {
			return;
		}

		List<String> roleListInToken = null;
		try {
			Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			String rolesInToken = claims.get("userRoles", String.class);
			roleListInToken = Arrays.asList(rolesInToken.split(";"));
			BaseRepositoryImpl.requestUser = claims.get("userName", String.class);
		} catch (Exception e) {
			throw new Exception();
		}
		// admin can access all resource
		if (roleListInToken.contains(UserRoles.ADMIN.toString())) {
			return;
		}
		for (UserRoles role : rolesAllowed) {
			if (roleListInToken.contains(role.toString())) {
				return;
			}
		}
		throw new Exception();
	}

}
