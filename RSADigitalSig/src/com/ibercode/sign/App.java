package com.ibercode.sign;

import com.ibercode.check.CheckSignature;
import com.ibercode.keys.KeysGenerator;

public class App {

	public static void main(String[] args) throws Exception {
		
		KeysGenerator.setKeys();
		
		String docToSign = "ibercode.com";
		
		byte[] signatureBytes = SignDocument.sign(docToSign);
		
		SignatureUtils.saveSignature(signatureBytes);
		
		String docToCheck = "ibercode.com";
		CheckSignature.check(docToCheck, SignatureUtils.getSignature());
	}

}
