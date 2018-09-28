package com.ibercode.sign;

import java.security.Signature;
import java.util.Base64;

import com.ibercode.keys.KeysUtil;

public class SignDocument {

	public static byte[] sign(String docToSign) throws Exception {
		
		Signature signature = Signature.getInstance("SHA256WithRSA");
		signature.initSign(KeysUtil.getPrivate("Keys/privatekey"));
		signature.update(docToSign.getBytes("UTF8"));
		
		byte[] signatureBytes = signature.sign();
		
		System.out.println(Base64.getEncoder().encodeToString(signatureBytes));
		
		return signatureBytes;
	}

}
