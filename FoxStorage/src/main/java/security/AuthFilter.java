package security;

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;

@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		try {
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			String token = authorizationHeader.substring("Bearer".length()).trim();
			Key secretKey = KeyGen.getKey();
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			System.out.println("#### valid token : " + token);
			// TODO logger.info("#### valid token : " + token);
		} catch (Exception e) {
			// TODO logger.severe("#### invalid token : " + token);
			System.out.println("#### invalid token : " + e.getMessage());
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

	}

}
