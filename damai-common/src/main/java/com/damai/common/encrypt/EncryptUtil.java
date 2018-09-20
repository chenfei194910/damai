package com.damai.common.encrypt;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author fei
 *
 */
public class EncryptUtil {

	/**
	 * 加密
	 * @param data 密码明文
	 * @param salt 盐
	 * @return
	 */
	public static String encrypt(String data, String salt) {
		if (data == null || data.length() <= 0 || salt == null || salt.length() <= 0) {
			return null;
		}

		String sha384Hex = new SimpleHash("SHA-384", data, ByteSource.Util.bytes(salt), 2).toHex();
		System.out.println(data + ":" + sha384Hex);
		return sha384Hex;
	}
}
