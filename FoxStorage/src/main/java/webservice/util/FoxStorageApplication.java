package webservice.util;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import security.KeyGen;

@ApplicationPath("/")
public class FoxStorageApplication extends Application {

	public FoxStorageApplication() {
		KeyGen.setKey();
	}
}
