package com.EncryptorAndDecryptor;

import org.apache.commons.codec.binary.Base64;

public class Decryptor {

	public static String decrypt(String encryptedData)
	{
		byte[] cypherText=Base64.decodeBase64(encryptedData.getBytes());
		return new String(cypherText);
	}
}
