package exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotAuthException extends WebApplicationException{
	
	private static final long serialVersionUID = 1010522005376005492L;

	public NotAuthException(String message) {
        super(Response.status(Response.Status.UNAUTHORIZED)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
