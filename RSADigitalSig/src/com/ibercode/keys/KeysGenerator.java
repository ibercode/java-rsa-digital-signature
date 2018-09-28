package com.ibercode.keys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeysGenerator {
	
	public static void  setKeys() throws Exception {
		
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
		keygen.initialize(2048);
		KeyPair keypair = keygen.genKeyPair();
		
		writeToFile("Keys/publicKey", keypair.getPublic().getEncoded());
		writeToFile("Keys/privateKey", keypair.getPrivate().getEncoded());
		
	}

	public static void writeToFile(String path, byte[] key) throws IOException {
		
		File file = new File(path);
		file.getParentFile().mkdirs();
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(key);
		fos.flush();
		fos.close();
	}
}
