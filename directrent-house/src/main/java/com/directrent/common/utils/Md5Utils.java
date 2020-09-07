package com.directrent.common.utils;

import java.security.MessageDigest;

public class Md5Utils {

	/**
	 * 对字符串md5加密(小写+字母)
	 * 
	 * @param str
	 *            传入要加密的字符串
	 * @return MD5加密后的字符串
	 */
	public static String getMD5(String message) {
		String md5 = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5"); // 创建一个md5算法对象
			byte[] messageByte = message.getBytes("UTF-8");
			byte[] md5Byte = md.digest(messageByte); // 获得MD5字节数组,16*8=128位
			md5 = bytesToHex(md5Byte); // 转换为16进制字符串
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5;
	}

	// 二进制转十六进制
	public static String bytesToHex(byte[] bytes) {
		StringBuffer hexStr = new StringBuffer();
		int num;
		for (int i = 0; i < bytes.length; i++) {
			num = bytes[i];
			if (num < 0) {
				num += 256;
			}
			if (num < 16) {
				hexStr.append("0");
			}
			hexStr.append(Integer.toHexString(num));
		}
		return hexStr.toString();
	}

	/**
	 * 对字符串md5加密3次(小写+字母)
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD5By3Times(String str) {
		return getMD5(getMD5(getMD5(str)));
	}

	public static void main(String[] args) {
//		System.out.println(getMD5("testtest"));
		System.out.println(getMD5By3Times("abc020939"));
	}
}
