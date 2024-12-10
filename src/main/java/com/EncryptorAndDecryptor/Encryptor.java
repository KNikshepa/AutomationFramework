package com.EncryptorAndDecryptor;

import org.apache.commons.codec.binary.Base64;

public class Encryptor {

	public static String encode(String plainText)
	{
		byte[] cypherText=Base64.encodeBase64(plainText.getBytes());
		return new String(cypherText);
	}
}
