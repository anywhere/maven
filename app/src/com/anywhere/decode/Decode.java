package com.anywhere.decode;

import java.nio.charset.Charset;

public class Decode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] bytes = "金".getBytes(); // { 32 };
		// String str = new String(b, Charset.forName("UTF-8"));
		for (byte c : bytes) {
			System.out.print(Integer.toHexString(0xFF & c).toUpperCase() + " ");
			// int i = 0xFFFFFFFF & c;
			// System.out.println(Integer.toHexString(i));
		}
		System.out.println();
		int[] ints = { 0xE9, 0x87, 0x91 };
		to(ints);
		// bytes = "金".getBytes(Charset.forName("US-ASCII"));
		// to(bytes,Charset.forName("US-ASCII"));
	}

	public static void to(int[] ints) {
		byte[] b = new byte[ints.length];
		for (int i = 0; i < ints.length; i++) {
			b[i] = (byte) ints[i];
		}
		to(b);
	}

	public static void to(byte[] bytes) {
		to(bytes, Charset.defaultCharset());
	}

	public static String to(byte[] bytes, Charset charset) {
		String str = new String(bytes, charset);
		System.out.println(str);
		return str;
	}
}
