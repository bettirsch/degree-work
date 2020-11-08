package utils.logger;

import java.io.Serializable;
import java.util.Arrays;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.APPLICATION)
public class LoggableInterceptor implements Serializable{

	private static final long serialVersionUID = 2419471480450800271L;

	private Logger logger;
	
	@AroundInvoke
	private Object intercept(InvocationContext ic) throws Exception {
		Object ret = null;
		try {
			logger = LoggerFactory.getLogger(ic.getMethod().getDeclaringClass());
			logger.info(ic.getMethod().getName()
					+ " method called with parameters: " + Arrays.toString(ic.getParameters()));
		} catch (Exception e) {
			logger = LoggerFactory.getLogger(ic.getMethod().getClass());
			logger.warn("Error during intercept logger: " + e.getMessage(), e);
		}
		try {
			ret = ic.proceed();
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return ret;
	}
}
