package com.ibercode.sign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Base64;

public class SignatureUtils {

	public static byte[] getSignature() throws Exception {

		Reader bufferedReader = new BufferedReader(new FileReader(new File("Keys/signature.txt")));
		
		String signatureBytes = ((BufferedReader) bufferedReader).readLine();
		
		bufferedReader.close();
		
		return Base64.getDecoder().decode(signatureBytes);

	}

	public static void saveSignature(byte[] signatureBytes) throws Exception {

		String encodeToString = Base64.getEncoder().encodeToString(signatureBytes);
		
		Writer bufferedWriter = new BufferedWriter(new FileWriter(new File("Keys/signature.txt")));
		
		((BufferedWriter) bufferedWriter).write(encodeToString);
		
		bufferedWriter.close();
	}
}
