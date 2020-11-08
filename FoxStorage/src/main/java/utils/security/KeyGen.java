package utils.security;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyGen {

	private static String algorithm = "AES";
    private static SecretKey key = null;

	public static SecretKey getSecretKey() throws NoSuchAlgorithmException{
		if (key == null) {
			setSecretKey();
		}
		return key;
	}

	public static void setSecretKey() throws NoSuchAlgorithmException{
		try {
			KeyGen.key = KeyGenerator.getInstance(algorithm).generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw e;
		}
	}

}
