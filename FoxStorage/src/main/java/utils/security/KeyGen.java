package utils.security;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

public class KeyGen {

	private static String algorithm = "AES";
    private static Key key = null;

	public static Key getKey() {
		return key;
	}

	public static void setKey(){
		try {
			KeyGen.key = KeyGenerator.getInstance(algorithm).generateKey();
		} catch (NoSuchAlgorithmException e) {
			//TODO log
		}
	}

}
