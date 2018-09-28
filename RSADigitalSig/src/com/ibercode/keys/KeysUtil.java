package com.ibercode.keys;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeysUtil {
	
	public static PrivateKey getPrivate(String filename) throws Exception {
		
		byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
		
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		
		KeyFactory keyFactor = KeyFactory.getInstance("RSA");
		
		return keyFactor.generatePrivate(keySpec);
	}
	
	public static PublicKey getPublic(String filename) throws Exception {
		
		byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
		
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		
		KeyFactory keyFactor = KeyFactory.getInstance("RSA");
		
		return keyFactor.generatePublic(keySpec);
	}

}
