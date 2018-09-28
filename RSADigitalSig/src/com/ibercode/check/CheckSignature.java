package com.ibercode.check;

import java.security.Signature;

import com.ibercode.keys.KeysUtil;

public class CheckSignature {

	public static void check(String docToCheck, byte[] signatureBytes) throws Exception {
		
		
		Signature signature = Signature.getInstance("SHA256WithRSA");
		
		signature.initVerify(KeysUtil.getPublic("Keys/publickey"));
		
		signature.update(docToCheck.getBytes("UTF8"));
		
		System.out.println(signature.verify(signatureBytes));
		
	}
	
}
