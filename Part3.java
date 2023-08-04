package FinalProject;

import java.util.Scanner;

public class Part3 {
	public static void main(String[] args) {
		// Making sure that anyone can put in anything to use the program
		Scanner scan = new Scanner(System.in);
		String key;
		// Getting Key
		System.out.println("Choose a key:");
		String expkey = "";
		key = scan.nextLine();
		// Getting the appropriate key extension
		if(key.length() == 32) {
			expkey = part1AES128(key);
			System.out.println(expkey);
		} else if(key.length() == 48) {
			expkey = part1AES192(key);
			System.out.println(expkey);
		} else if(key.length() == 64) {
			expkey = part1AES256(key);
			System.out.println(expkey);
		}
		// Decrypting the ciphertext
		System.out.println("Choose the ciphertext:");
		String ciphertext = "";
		ciphertext = scan.nextLine();
		System.out.println("Type in 'CBC' if you want to use the CBC mode. Type anything else for ECB mode:");
		String mode = scan.nextLine();
		if(mode.equalsIgnoreCase("CBC")) {
			// Decrypting the ciphertext with CBC
			System.out.println(aesDecryptCBC(expkey, ciphertext));
		} else {
			// Decrypting the ciphertext with ECB
			System.out.println(aesDecryptECB(expkey, ciphertext));
		}
		scan.close();
	}
	
	// Get the aes128 key extension from Part 1
	public static String part1AES128(String key) {
		return Part1.aes128(key);
	}
	
	// Get the aes192 key extension from Part 1
	public static String part1AES192(String key) {
		return Part1.aes192(key);
	}
	
	// Get the aes256 key extension from Part 1
	public static String part1AES256(String key) {
		return Part1.aes256(key);
	}
	
	// Getting the xorhex from Part 2
	public static String xorhex(String a, String b) {
		return Part2.xorhex(a, b);
	}
	
	// Getting the xor from Part 2
	public static String xor(String a, String b) {
		return Part2.xor(a, b);
	}
	
	// Getting the inverse of the Sbox
	public static String invSbox(String l) {
		String a = "";
		for(int i = 0; i < l.length(); i += 2) {
			String x = l.substring(i, i+2);
			int s = 0x00;
			if(x.equalsIgnoreCase("63")){
				s = 0x00;
			} else if(x.equalsIgnoreCase("7C")){
				s = 0x01;
			} else if(x.equalsIgnoreCase("77")){
				s = 0x02;
			} else if(x.equalsIgnoreCase("7B")){
				s = 0x03;
			} else if(x.equalsIgnoreCase("F2")){
				s = 0x04;
			} else if(x.equalsIgnoreCase("6B")){
				s = 0x05;
			} else if(x.equalsIgnoreCase("6F")){
				s = 0x06;
			} else if(x.equalsIgnoreCase("C5")){
				s = 0x07;
			} else if(x.equalsIgnoreCase("30")){
				s = 0x08;
			} else if(x.equalsIgnoreCase("01")){
				s = 0x09;
			} else if(x.equalsIgnoreCase("67")){
				s = 0x0A;
			} else if(x.equalsIgnoreCase("2B")){
				s = 0x0B;
			} else if(x.equalsIgnoreCase("FE")){
				s = 0x0C;
			} else if(x.equalsIgnoreCase("D7")){
				s = 0x0D;
			} else if(x.equalsIgnoreCase("AB")){
				s = 0x0E;
			} else if(x.equalsIgnoreCase("76")){
				s = 0x0F;
			} else if(x.equalsIgnoreCase("CA")){
				s = 0x10;
			} else if(x.equalsIgnoreCase("82")){
				s = 0x11;
			} else if(x.equalsIgnoreCase("C9")) {
				s = 0x12;
			} else if(x.equalsIgnoreCase("7D")){
				s = 0x13;
			} else if(x.equalsIgnoreCase("FA")){
				s = 0x14;
			} else if(x.equalsIgnoreCase("59")){
				s = 0x15;
			} else if(x.equalsIgnoreCase("47")){
				s = 0x16;
			} else if(x.equalsIgnoreCase("F0")){
				s = 0x17;
			} else if(x.equalsIgnoreCase("AD")){
				s = 0x18;
			} else if(x.equalsIgnoreCase("D4")){
				s = 0x19;
			} else if(x.equalsIgnoreCase("A2")){
				s = 0x1A;
			} else if(x.equalsIgnoreCase("AF")){
				s = 0x1B;
			} else if(x.equalsIgnoreCase("9C")){
				s = 0x1C;
			} else if(x.equalsIgnoreCase("A4")){
				s = 0x1D;
			} else if(x.equalsIgnoreCase("72")){
				s = 0x1E;
			} else if(x.equalsIgnoreCase("C0")){
				s = 0x1F;
			} else if(x.equalsIgnoreCase("B7")){
				s = 0x20;
			} else if(x.equalsIgnoreCase("FD")){
				s = 0x21;
			} else if(x.equalsIgnoreCase("93")){
				s = 0x22;
			} else if(x.equalsIgnoreCase("26")){
				s = 0x23;
			} else if(x.equalsIgnoreCase("36")){
				s = 0x24;
			} else if(x.equalsIgnoreCase("3F")){
				s = 0x25;
			} else if(x.equalsIgnoreCase("F7")){
				s = 0x26;
			} else if(x.equalsIgnoreCase("CC")){
				s = 0x27;
			} else if(x.equalsIgnoreCase("34")){
				s = 0x28;
			} else if(x.equalsIgnoreCase("A5")){
				s = 0x29;
			} else if(x.equalsIgnoreCase("E5")){
				s = 0x2A;
			} else if(x.equalsIgnoreCase("F1")){
				s = 0x2B;
			} else if(x.equalsIgnoreCase("71")){
				s = 0x2C;
			} else if(x.equalsIgnoreCase("D8")){
				s = 0x2D;
			} else if(x.equalsIgnoreCase("31")){
				s = 0x2E;
			} else if(x.equalsIgnoreCase("15")){
				s = 0x2F;
			} else if(x.equalsIgnoreCase("04")){
				s = 0x30;
			} else if(x.equalsIgnoreCase("C7")){
				s = 0x31;
			} else if(x.equalsIgnoreCase("23")){
				s = 0x32;
			} else if(x.equalsIgnoreCase("C3")){
				s = 0x33;
			} else if(x.equalsIgnoreCase("18")){
				s = 0x34;
			} else if(x.equalsIgnoreCase("96")){
				s = 0x35;
			} else if(x.equalsIgnoreCase("05")){
				s = 0x36;
			} else if(x.equalsIgnoreCase("9A")){
				s = 0x37;
			} else if(x.equalsIgnoreCase("07")){
				s = 0x38;
			} else if(x.equalsIgnoreCase("12")){
				s = 0x39;
			} else if(x.equalsIgnoreCase("80")){
				s = 0x3A;
			} else if(x.equalsIgnoreCase("E2")){
				s = 0x3B;
			} else if(x.equalsIgnoreCase("EB")){
				s = 0x3C;
			} else if(x.equalsIgnoreCase("27")){
				s = 0x3D;
			} else if(x.equalsIgnoreCase("B2")){
				s = 0x3E;
			} else if(x.equalsIgnoreCase("75")){
				s = 0x3F;
			} else if(x.equalsIgnoreCase("09")){
				s = 0x40;
			} else if(x.equalsIgnoreCase("83")){
				s = 0x41;
			} else if(x.equalsIgnoreCase("2C")){
				s = 0x42;
			} else if(x.equalsIgnoreCase("1A")){
				s = 0x43;
			} else if(x.equalsIgnoreCase("1B")){
				s = 0x44;
			} else if(x.equalsIgnoreCase("6E")){
				s = 0x45;
			} else if(x.equalsIgnoreCase("5A")){
				s = 0x46;
			} else if(x.equalsIgnoreCase("A0")){
				s = 0x47;
			} else if(x.equalsIgnoreCase("52")){
				s = 0x48;
			} else if(x.equalsIgnoreCase("3B")){
				s = 0x49;
			} else if(x.equalsIgnoreCase("D6")){
				s = 0x4A;
			} else if(x.equalsIgnoreCase("B3")){
				s = 0x4B;
			} else if(x.equalsIgnoreCase("29")){
				s = 0x4C;
			} else if(x.equalsIgnoreCase("E3")){
				s = 0x4D;
			} else if(x.equalsIgnoreCase("2F")){
				s = 0x4E;
			} else if(x.equalsIgnoreCase("84")){
				s = 0x4F;
			} else if(x.equalsIgnoreCase("53")){
				s = 0x50;
			} else if(x.equalsIgnoreCase("D1")){
				s = 0x51;
			} else if(x.equalsIgnoreCase("00")){
				s = 0x52;
			} else if(x.equalsIgnoreCase("ED")){
				s = 0x53;
			} else if(x.equalsIgnoreCase("20")){
				s = 0x54;
			} else if(x.equalsIgnoreCase("FC")){
				s = 0x55;
			} else if(x.equalsIgnoreCase("B1")){
				s = 0x56;
			} else if(x.equalsIgnoreCase("5B")){
				s = 0x57;
			} else if(x.equalsIgnoreCase("6A")){
				s = 0x58;
			} else if(x.equalsIgnoreCase("CB")){
				s = 0x59;
			} else if(x.equalsIgnoreCase("BE")){
				s = 0x5A;
			} else if(x.equalsIgnoreCase("39")){
				s = 0x5B;
			} else if(x.equalsIgnoreCase("4A")){
				s = 0x5C;
			} else if(x.equalsIgnoreCase("4C")){
				s = 0x5D;
			} else if(x.equalsIgnoreCase("58")){
				s = 0x5E;
			} else if(x.equalsIgnoreCase("CF")){
				s = 0x5F;
			} else if(x.equalsIgnoreCase("D0")){
				s = 0x60;
			} else if(x.equalsIgnoreCase("EF")){
				s = 0x61;
			} else if(x.equalsIgnoreCase("AA")){
				s = 0x62;
			} else if(x.equalsIgnoreCase("FB")){
				s = 0x63;
			} else if(x.equalsIgnoreCase("43")){
				s = 0x64;
			} else if(x.equalsIgnoreCase("4D")){
				s = 0x65;
			} else if(x.equalsIgnoreCase("33")){
				s = 0x66;
			} else if(x.equalsIgnoreCase("85")){
				s = 0x67;
			} else if(x.equalsIgnoreCase("45")){
				s = 0x68;
			} else if(x.equalsIgnoreCase("F9")){
				s = 0x69;
			} else if(x.equalsIgnoreCase("02")){
				s = 0x6A;
			} else if(x.equalsIgnoreCase("7F")){
				s = 0x6B;
			} else if(x.equalsIgnoreCase("50")){
				s = 0x6C;
			} else if(x.equalsIgnoreCase("3C")){
				s = 0x6D;
			} else if(x.equalsIgnoreCase("9F")){
				s = 0x6E;
			} else if(x.equalsIgnoreCase("A8")){
				s = 0x6F;
			} else if(x.equalsIgnoreCase("51")){
				s = 0x70;
			} else if(x.equalsIgnoreCase("A3")){
				s = 0x71;
			} else if(x.equalsIgnoreCase("40")){
				s = 0x72;
			} else if(x.equalsIgnoreCase("8F")){
				s = 0x73;
			} else if(x.equalsIgnoreCase("92")){
				s = 0x74;
			} else if(x.equalsIgnoreCase("9D")){
				s = 0x75;
			} else if(x.equalsIgnoreCase("38")){
				s = 0x76;
			} else if(x.equalsIgnoreCase("F5")){
				s = 0x77;
			} else if(x.equalsIgnoreCase("BC")){
				s = 0x78;
			} else if(x.equalsIgnoreCase("B6")){
				s = 0x79;
			} else if(x.equalsIgnoreCase("DA")){
				s = 0x7A;
			} else if(x.equalsIgnoreCase("21")){
				s = 0x7B;
			} else if(x.equalsIgnoreCase("10")){
				s = 0x7C;
			} else if(x.equalsIgnoreCase("FF")){
				s = 0x7D;
			} else if(x.equalsIgnoreCase("F3")){
				s = 0x7E;
			} else if(x.equalsIgnoreCase("D2")){
				s = 0x7F;
			} else if(x.equalsIgnoreCase("CD")){
				s = 0x80;
			} else if(x.equalsIgnoreCase("0C")){
				s = 0x81;
			} else if(x.equalsIgnoreCase("13")){
				s = 0x82;
			} else if(x.equalsIgnoreCase("EC")){
				s = 0x83;
			} else if(x.equalsIgnoreCase("5F")){
				s = 0x84;
			} else if(x.equalsIgnoreCase("97")){
				s = 0x85;
			} else if(x.equalsIgnoreCase("44")){
				s = 0x86;
			} else if(x.equalsIgnoreCase("17")){
				s = 0x87;
			} else if(x.equalsIgnoreCase("C4")){
				s = 0x88;
			} else if(x.equalsIgnoreCase("A7")){
				s = 0x89;
			} else if(x.equalsIgnoreCase("7E")){
				s = 0x8A;
			} else if(x.equalsIgnoreCase("3D")){
				s = 0x8B;
			} else if(x.equalsIgnoreCase("64")){
				s = 0x8C;
			} else if(x.equalsIgnoreCase("5D")){
				s = 0x8D;
			} else if(x.equalsIgnoreCase("19")){
				s = 0x8E;
			} else if(x.equalsIgnoreCase("73")){
				s = 0x8F;
			} else if(x.equalsIgnoreCase("60")){
				s = 0x90;
			} else if(x.equalsIgnoreCase("81")){
				s = 0x91;
			} else if(x.equalsIgnoreCase("4F")){
				s = 0x92;
			} else if(x.equalsIgnoreCase("DC")){
				s = 0x93;
			} else if(x.equalsIgnoreCase("22")){
				s = 0x94;
			} else if(x.equalsIgnoreCase("2A")){
				s = 0x95;
			} else if(x.equalsIgnoreCase("90")){
				s = 0x96;
			} else if(x.equalsIgnoreCase("88")){
				s = 0x97;
			} else if(x.equalsIgnoreCase("46")){
				s = 0x98;
			} else if(x.equalsIgnoreCase("EE")){
				s = 0x99;
			} else if(x.equalsIgnoreCase("B8")){
				s = 0x9A;
			} else if(x.equalsIgnoreCase("14")){
				s = 0x9B;
			} else if(x.equalsIgnoreCase("DE")){
				s = 0x9C;
			} else if(x.equalsIgnoreCase("5E")){
				s = 0x9D;
			} else if(x.equalsIgnoreCase("0B")){
				s = 0x9E;
			} else if(x.equalsIgnoreCase("DB")){
				s = 0x9F;
			} else if(x.equalsIgnoreCase("E0")){
				s = 0xA0;
			} else if(x.equalsIgnoreCase("32")){
				s = 0xA1;
			} else if(x.equalsIgnoreCase("3A")){
				s = 0xA2;
			} else if(x.equalsIgnoreCase("0A")){
				s = 0xA3;
			} else if(x.equalsIgnoreCase("49")){
				s = 0xA4;
			} else if(x.equalsIgnoreCase("06")){
				s = 0xA5;
			} else if(x.equalsIgnoreCase("24")){
				s = 0xA6;
			} else if(x.equalsIgnoreCase("5C")){
				s = 0xA7;
			} else if(x.equalsIgnoreCase("C2")){
				s = 0xA8;
			} else if(x.equalsIgnoreCase("D3")){
				s = 0xA9;
			} else if(x.equalsIgnoreCase("AC")){
				s = 0xAA;
			} else if(x.equalsIgnoreCase("62")){
				s = 0xAB;
			} else if(x.equalsIgnoreCase("91")){
				s = 0xAC;
			} else if(x.equalsIgnoreCase("95")){
				s = 0xAD;
			} else if(x.equalsIgnoreCase("E4")){
				s = 0xAE;
			} else if(x.equalsIgnoreCase("79")){
				s = 0xAF;
			} else if(x.equalsIgnoreCase("E7")){
				s = 0xB0;
			} else if(x.equalsIgnoreCase("C8")){
				s = 0xB1;
			} else if(x.equalsIgnoreCase("37")){
				s = 0xB2;
			} else if(x.equalsIgnoreCase("6D")){
				s = 0xB3;
			} else if(x.equalsIgnoreCase("8D")){
				s = 0xB4;
			} else if(x.equalsIgnoreCase("D5")){
				s = 0xB5;
			} else if(x.equalsIgnoreCase("4E")){
				s = 0xB6;
			} else if(x.equalsIgnoreCase("A9")){
				s = 0xB7;
			} else if(x.equalsIgnoreCase("6C")){
				s = 0xB8;
			} else if(x.equalsIgnoreCase("56")){
				s = 0xB9;
			} else if(x.equalsIgnoreCase("F4")){
				s = 0xBA;
			} else if(x.equalsIgnoreCase("EA")){
				s = 0xBB;
			} else if(x.equalsIgnoreCase("65")){
				s = 0xBC;
			} else if(x.equalsIgnoreCase("7A")){
				s = 0xBD;
			} else if(x.equalsIgnoreCase("AE")){
				s = 0xBE;
			} else if(x.equalsIgnoreCase("08")){
				s = 0xBF;
			} else if(x.equalsIgnoreCase("BA")){
				s = 0xC0;
			} else if(x.equalsIgnoreCase("78")){
				s = 0xC1;
			} else if(x.equalsIgnoreCase("25")){
				s = 0xC2;
			} else if(x.equalsIgnoreCase("2E")){
				s = 0xC3;
			} else if(x.equalsIgnoreCase("1C")){
				s = 0xC4;
			} else if(x.equalsIgnoreCase("A6")){
				s = 0xC5;
			} else if(x.equalsIgnoreCase("B4")){
				s = 0xC6;
			} else if(x.equalsIgnoreCase("C6")){
				s = 0xC7;
			} else if(x.equalsIgnoreCase("E8")){
				s = 0xC8;
			} else if(x.equalsIgnoreCase("DD")){
				s = 0xC9;
			} else if(x.equalsIgnoreCase("74")){
				s = 0xCA;
			} else if(x.equalsIgnoreCase("1F")){
				s = 0xCB;
			} else if(x.equalsIgnoreCase("4B")){
				s = 0xCC;
			} else if(x.equalsIgnoreCase("BD")){
				s = 0xCD;
			} else if(x.equalsIgnoreCase("8B")){
				s = 0xCE;
			} else if(x.equalsIgnoreCase("8A")){
				s = 0xCF;
			} else if(x.equalsIgnoreCase("70")){
				s = 0xD0;
			} else if(x.equalsIgnoreCase("3E")){
				s = 0xD1;
			} else if(x.equalsIgnoreCase("B5")){
				s = 0xD2;
			} else if(x.equalsIgnoreCase("66")){
				s = 0xD3;
			} else if(x.equalsIgnoreCase("48")){
				s = 0xD4;
			} else if(x.equalsIgnoreCase("03")){
				s = 0xD5;
			} else if(x.equalsIgnoreCase("F6")){
				s = 0xD6;
			} else if(x.equalsIgnoreCase("0E")){
				s = 0xD7;
			} else if(x.equalsIgnoreCase("61")){
				s = 0xD8;
			} else if(x.equalsIgnoreCase("35")){
				s = 0xD9;
			} else if(x.equalsIgnoreCase("57")){
				s = 0xDA;
			} else if(x.equalsIgnoreCase("B9")){
				s = 0xDB;
			} else if(x.equalsIgnoreCase("86")){
				s = 0xDC;
			} else if(x.equalsIgnoreCase("C1")){
				s = 0xDD;
			} else if(x.equalsIgnoreCase("1D")){
				s = 0xDE;
			} else if(x.equalsIgnoreCase("9E")){
				s = 0xDF;
			} else if(x.equalsIgnoreCase("E1")){
				s = 0xE0;
			} else if(x.equalsIgnoreCase("F8")){
				s = 0xE1;
			} else if(x.equalsIgnoreCase("98")) {
				s = 0xE2;
			} else if(x.equalsIgnoreCase("11")) {
				s = 0xE3;
			} else if(x.equalsIgnoreCase("69")) {
				s = 0xE4;
			} else if(x.equalsIgnoreCase("D9")) {
				s = 0xE5;
			} else if(x.equalsIgnoreCase("8E")) {
				s = 0xE6;
			} else if(x.equalsIgnoreCase("94")) {
				s = 0xE7;
			} else if(x.equalsIgnoreCase("9B")) {
				s = 0xE8;
			} else if(x.equalsIgnoreCase("1E")) {
				s = 0xE9;
			} else if(x.equalsIgnoreCase("87")) {
				s = 0xEA;
			} else if(x.equalsIgnoreCase("E9")) {
				s = 0xEB;
			} else if(x.equalsIgnoreCase("CE")) {
				s = 0xEC;
			} else if(x.equalsIgnoreCase("55")) {
				s = 0xED;
			} else if(x.equalsIgnoreCase("28")) {
				s = 0xEE;
			} else if(x.equalsIgnoreCase("DF")) {
				s = 0xEF;
			} else if(x.equalsIgnoreCase("8C")) {
				s = 0xF0;
			} else if(x.equalsIgnoreCase("A1")) {
				s = 0xF1;
			} else if(x.equalsIgnoreCase("89")) {
				s = 0xF2;
			} else if(x.equalsIgnoreCase("0D")) {
				s = 0xF3;
			} else if(x.equalsIgnoreCase("BF")) {
				s = 0xF4;
			} else if(x.equalsIgnoreCase("E6")) {
				s = 0xF5;
			} else if(x.equalsIgnoreCase("42")) {
				s = 0xF6;
			} else if(x.equalsIgnoreCase("68")) {
				s = 0xF7;
			} else if(x.equalsIgnoreCase("41")) {
				s = 0xF8;
			} else if(x.equalsIgnoreCase("99")) {
				s = 0xF9;
			} else if(x.equalsIgnoreCase("2D")) {
				s = 0xFA;
			} else if(x.equalsIgnoreCase("0F")) {
				s = 0xFB;
			} else if(x.equalsIgnoreCase("B0")) {
				s = 0xFC;
			} else if(x.equalsIgnoreCase("54")) {
				s = 0xFD;
			} else if(x.equalsIgnoreCase("BB")) {
				s = 0xFE;
			} else {
				s = 0xFF;
			}
			String n = ("00" 
			+ Integer.toHexString(s)).substring(Integer.toHexString(s).length());
			a = a + n;
		}
		return a;
	}
	
	// Decrypting ECB mode
	public static String aesDecryptECB(String expkey, String ciphertext) {
		int a = expkey.length()/2;
		int b = ciphertext.length()/2;
		int c = a/16 - 2;
		if(expkey.length() == 512) {
			c = c - 1;
		}
		int d = b/16;
		String aes = "";
		String part = "";
		for(int i = d; i > 0; i--) {
			aes = part + aes;
			part = "";
			String last = ciphertext.substring(ciphertext.length() - 32);
			if(ciphertext.length() != 32) {
				String h = ciphertext.substring(0, ciphertext.length() - 32);
				ciphertext = h;
			}
			if(expkey.length() == 432) {
				expkey = expkey.substring(0, 416);
			} else if(expkey.length() == 512) {
				expkey = expkey.substring(0, 480);
			}
			String expkeyclone = expkey;
			String exp = expkeyclone.substring(expkeyclone.length() - 32);
			if(expkeyclone.length() != 32) {
				String gds = expkeyclone.substring(0, expkeyclone.length() - 32);
				expkeyclone = gds;
			}
			// Round key step from the back
			String za = xorhex(last, exp);
			// Shifting the rows
			String p = za.substring(0, 2);
			String q = za.substring(2, 4);
			String r = za.substring(4, 6);
			String s = za.substring(6, 8);
			String t = za.substring(8, 10);
			String u = za.substring(10, 12);
			String v = za.substring(12, 14);
			String w = za.substring(14, 16);
			String x = za.substring(16, 18);
			String y = za.substring(18, 20);
			String z = za.substring(20, 22);
			String aa = za.substring(22, 24);
			String ab = za.substring(24, 26);
			String ac = za.substring(26, 28);
			String ad = za.substring(28, 30);
			String ae = za.substring(30);
			String af = p+ac+z+w+t+q+ad+aa+x+u+r+ae+ab+y+v+s;
			String m = "";
			// Inverse sub bytes step (inv sbox)
			for(int l = 0; l < 16; l++) {
				String n = af.substring(0, 2);
				if(af.length() != 2) {
					String o = af.substring(2);
					af = o;
				}
				m = m + invSbox(n);
			}
			String ex = expkeyclone.substring(expkeyclone.length() - 32);
			if(expkeyclone.length() != 32) {
				String gds = expkeyclone.substring(0, expkeyclone.length() - 32);
				expkeyclone = gds;
			}
			// Round key step
			String round = xorhex(m, ex);
			for(int j = c; j > 0; j--) {
				String aespart = "";
				// The inverse matrix column step
				for(int zz = 0; zz < 4; zz++) {
					// Updating the allocating from round and updating round
					String s1j = round.substring(0, 2);
					String s2j = round.substring(2, 4);
					String s3j = round.substring(4, 6);
					String s4j = round.substring(6, 8);
					if(round.length() > 8) {
						round = round.substring(8);
					}					
					// Hexadecimal to decimal
					int s1jint = Integer.parseInt(s1j, 16);
					int s2jint = Integer.parseInt(s2j, 16);
					int s3jint = Integer.parseInt(s3j, 16);
					int s4jint = Integer.parseInt(s4j, 16);
					// Decimal to binary
					String s1jxo = Integer.toBinaryString(s1jint);
					String s2jxo = Integer.toBinaryString(s2jint);
					String s3jxo = Integer.toBinaryString(s3jint);
					String s4jxo = Integer.toBinaryString(s4jint);
					// Converting to integer
					Long s1jbin = Long.parseLong(s1jxo);
					Long s2jbin = Long.parseLong(s2jxo);
					Long s3jbin = Long.parseLong(s3jxo);
					Long s4jbin = Long.parseLong(s4jxo);
					Long s1j1000 = s1jbin * 1000;
					Long s1j100 = s1jbin * 100;
					Long s1j10 = s1jbin * 10;
					Long s2j1000 = s2jbin * 1000;
					Long s2j100 = s2jbin * 100;
					Long s2j10 = s2jbin * 10;
					Long s3j1000 = s3jbin * 1000;
					Long s3j100 = s3jbin * 100;
					Long s3j10 = s3jbin * 10;
					Long s4j1000 = s4jbin * 1000;
					Long s4j100 = s4jbin * 100;
					Long s4j10 = s4jbin * 10;
					String s1j1000str = Long.toString(s1j1000);
					String s1j100str = Long.toString(s1j100);
					String s1j10str = Long.toString(s1j10);
					String s2j1000str = Long.toString(s2j1000);
					String s2j100str = Long.toString(s2j100);
					String s2j10str = Long.toString(s2j10);
					String s3j1000str = Long.toString(s3j1000);
					String s3j100str = Long.toString(s3j100);
					String s3j10str = Long.toString(s3j10);
					String s4j1000str = Long.toString(s4j1000);
					String s4j100str = Long.toString(s4j100);
					String s4j10str = Long.toString(s4j10);
					// Doing the main calculations for inv mix columns
					String s1j0e = xor(xor(s1j1000str, s1j100str), s1j10str);
					String s2j0b = xor(xor(s2j1000str, s2j10str), s2jxo);
					String s3j0d = xor(xor(s3j1000str, s3j100str), s3jxo);
					String s4j09 = xor(s4j1000str, s4jxo);
					String s1j09 = xor(s1j1000str, s1jxo);
					String s2j0e = xor(xor(s2j1000str, s2j100str), s2j10str);
					String s3j0b = xor(xor(s3j1000str, s3j10str), s3jxo);
					String s4j0d = xor(xor(s4j1000str, s4j100str), s4jxo);
					String s1j0d = xor(xor(s1j1000str, s1j100str), s1jxo);
					String s2j09 = xor(s2j1000str, s2jxo);
					String s3j0e = xor(xor(s3j1000str, s3j100str), s3j10str);
					String s4j0b = xor(xor(s4j1000str, s4j10str), s4jxo);
					String s1j0b = xor(xor(s1j1000str, s1j10str), s1jxo);
					String s2j0d = xor(xor(s2j1000str, s2j100str), s2jxo);
					String s3j09 = xor(s3j1000str, s3jxo);
					String s4j0e = xor(xor(s4j1000str, s4j100str), s4j10str);
					String s1x = xor(xor(s1j0e, s2j0b), xor(s3j0d, s4j09));
					String s2x = xor(xor(s1j09, s2j0e), xor(s3j0b, s4j0d));
					String s3x = xor(xor(s1j0d, s2j09), xor(s3j0e, s4j0b));
					String s4x = xor(xor(s1j0b, s2j0d), xor(s3j09, s4j0e));
					// If any value has a length of greater than 0 and the first 
					// element is a 0, get rid of the first element
					while(s1x.length() > 8 && s1x.substring(0, 1).equals("0")) {
						s1x = s1x.substring(1);
					}
					while(s2x.length() > 8 && s2x.substring(0, 1).equals("0")) {
						s2x = s2x.substring(1);
					}
					while(s3x.length() > 8 && s3x.substring(0, 1).equals("0")) {
						s3x = s3x.substring(1);
					}
					while(s4x.length() > 8 && s4x.substring(0, 1).equals("0")) {
						s4x = s4x.substring(1);
					}
					while(s1x.length() > 8 || s2x.length() > 8 || s3x.length() > 8 || s4x.length() > 8) {
						// Xoring any value with the aes polynomial that is greater than 8.
						// Making sure the xor from the highest degree to the lowest for most
						// accurate xor calculations
						String poly = "100011011";
						if(s1x.length() > 8) {
							while(poly.length() < s1x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s1x = xor(s1x, poly);
							while(s1x.length() != 8 && s1x.substring(0, 1).equals("0")) {
								s1x = s1x.substring(1);
							}
						}
						poly = "100011011";
						if(s2x.length() > 8) {
							while(poly.length() < s2x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s2x = xor(s2x, poly);
							while(s2x.length() != 8 && s2x.substring(0, 1).equals("0")) {
								s2x = s2x.substring(1);
							}
						}
						poly = "100011011";
						if(s3x.length() > 8) {
							while(poly.length() < s3x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s3x = xor(s3x, poly);
							while(s3x.length() != 8 && s3x.substring(0, 1).equals("0")) {
								s3x = s3x.substring(1);
							}
						}
						poly = "100011011";
						if(s4x.length() > 8) {
							while(poly.length() < s4x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s4x = xor(s4x, poly);
							while(s4x.length() != 8 && s4x.substring(0, 1).equals("0")) {
								s4x = s4x.substring(1);
							}
						}
					}
					// Binary to decimal
					int s1bi = Integer.parseInt(s1x, 2);
					int s2bi = Integer.parseInt(s2x, 2);
					int s3bi = Integer.parseInt(s3x, 2);
					int s4bi = Integer.parseInt(s4x, 2);
					// Decimal to hexadecimal
					String s1 = Integer.toHexString(s1bi);
					String s2 = Integer.toHexString(s2bi);
					String s3 = Integer.toHexString(s3bi);
					String s4 = Integer.toHexString(s4bi);
					if(s1.length() == 1) {
						s1 = "0" + s1;
					}
					if(s2.length() == 1) {
						s2 = "0" + s2;
					}
					if(s3.length() == 1) {
						s3 = "0" + s3;
					}
					if(s4.length() == 1) {
						s4 = "0" + s4;
					}
					aespart = aespart + s1+s2+s3+s4;
				}
				// Shifting the rows
				String pr = aespart.substring(0, 2);
				String qr = aespart.substring(2, 4);
				String rr = aespart.substring(4, 6);
				String sr = aespart.substring(6, 8);
				String tr = aespart.substring(8, 10);
				String ur = aespart.substring(10, 12);
				String vr = aespart.substring(12, 14);
				String wr = aespart.substring(14, 16);
				String xr = aespart.substring(16, 18);
				String yr = aespart.substring(18, 20);
				String zr = aespart.substring(20, 22);
				String aar = aespart.substring(22, 24);
				String abr = aespart.substring(24, 26);
				String acr = aespart.substring(26, 28);
				String adr = aespart.substring(28, 30);
				String aer = aespart.substring(30);
				String afr = pr+acr+zr+wr+tr+qr+adr+aar+xr+ur+rr+aer+abr+yr+vr+sr;
				String mr = "";
				// Inverse sub bytes step (inv sbox)
				for(int l = 0; l < 16; l++) {
					String n = afr.substring(0, 2);
					if(afr.length() != 2) {
						String o = afr.substring(2);
						afr = o;
					}
					mr = mr + invSbox(n);
				}
				String e = expkeyclone.substring(expkeyclone.length() - 32);
				// Add Round key step
				round = xorhex(e, mr);
				part = round;
				if(expkeyclone.length() != 32) {
					String gds = expkeyclone.substring(0, expkeyclone.length() - 32);
					expkeyclone = gds;
				}
			}
		}
		aes = part + aes;
		return aes;
	}
	
	public static String aesDecryptCBC(String expkey, String ciphertext) {
		int a = expkey.length()/2;
		int b = ciphertext.length()/2;
		int c = a/16 - 2;
		if(expkey.length() == 512) {
			c = c - 1;
		}
		int d = b/16;
		String aes = "";
		String part = "";
		for(int i = d; i > 0; i--) {
			aes = part + aes;
			part = "";
			String last = ciphertext.substring(ciphertext.length() - 32);
			if(ciphertext.length() != 32) {
				String h = ciphertext.substring(0, ciphertext.length() - 32);
				ciphertext = h;
			}
			if(expkey.length() == 432) {
				expkey = expkey.substring(0, 416);
			} else if(expkey.length() == 512) {
				expkey = expkey.substring(0, 480);
			}
			String expkeyclone = expkey;
			String exp = expkeyclone.substring(expkeyclone.length() - 32);
			if(expkeyclone.length() != 32) {
				String gds = expkeyclone.substring(0, expkeyclone.length() - 32);
				expkeyclone = gds;
			}
			// Round key step from the back
			String za = xorhex(last, exp);
			// Shifting the rows
			String p = za.substring(0, 2);
			String q = za.substring(2, 4);
			String r = za.substring(4, 6);
			String s = za.substring(6, 8);
			String t = za.substring(8, 10);
			String u = za.substring(10, 12);
			String v = za.substring(12, 14);
			String w = za.substring(14, 16);
			String x = za.substring(16, 18);
			String y = za.substring(18, 20);
			String z = za.substring(20, 22);
			String aa = za.substring(22, 24);
			String ab = za.substring(24, 26);
			String ac = za.substring(26, 28);
			String ad = za.substring(28, 30);
			String ae = za.substring(30);
			String af = p+ac+z+w+t+q+ad+aa+x+u+r+ae+ab+y+v+s;
			String m = "";
			// Inverse sub bytes step (inv sbox)
			for(int l = 0; l < 16; l++) {
				String n = af.substring(0, 2);
				if(af.length() != 2) {
					String o = af.substring(2);
					af = o;
				}
				m = m + invSbox(n);
			}
			String ex = expkeyclone.substring(expkeyclone.length() - 32);
			if(expkeyclone.length() != 32) {
				String gds = expkeyclone.substring(0, expkeyclone.length() - 32);
				expkeyclone = gds;
			}
			// Round key step
			String round = xorhex(m, ex);
			for(int j = c; j > 0; j--) {
				String aespart = "";
				// The inverse matrix column step
				for(int zz = 0; zz < 4; zz++) {
					// Updating the allocating from round and updating round
					String s1j = round.substring(0, 2);
					String s2j = round.substring(2, 4);
					String s3j = round.substring(4, 6);
					String s4j = round.substring(6, 8);
					if(round.length() > 8) {
						round = round.substring(8);
					}					
					// Hexadecimal to decimal
					int s1jint = Integer.parseInt(s1j, 16);
					int s2jint = Integer.parseInt(s2j, 16);
					int s3jint = Integer.parseInt(s3j, 16);
					int s4jint = Integer.parseInt(s4j, 16);
					// Decimal to binary
					String s1jxo = Integer.toBinaryString(s1jint);
					String s2jxo = Integer.toBinaryString(s2jint);
					String s3jxo = Integer.toBinaryString(s3jint);
					String s4jxo = Integer.toBinaryString(s4jint);
					// Converting to integer
					Long s1jbin = Long.parseLong(s1jxo);
					Long s2jbin = Long.parseLong(s2jxo);
					Long s3jbin = Long.parseLong(s3jxo);
					Long s4jbin = Long.parseLong(s4jxo);
					Long s1j1000 = s1jbin * 1000;
					Long s1j100 = s1jbin * 100;
					Long s1j10 = s1jbin * 10;
					Long s2j1000 = s2jbin * 1000;
					Long s2j100 = s2jbin * 100;
					Long s2j10 = s2jbin * 10;
					Long s3j1000 = s3jbin * 1000;
					Long s3j100 = s3jbin * 100;
					Long s3j10 = s3jbin * 10;
					Long s4j1000 = s4jbin * 1000;
					Long s4j100 = s4jbin * 100;
					Long s4j10 = s4jbin * 10;
					String s1j1000str = Long.toString(s1j1000);
					String s1j100str = Long.toString(s1j100);
					String s1j10str = Long.toString(s1j10);
					String s2j1000str = Long.toString(s2j1000);
					String s2j100str = Long.toString(s2j100);
					String s2j10str = Long.toString(s2j10);
					String s3j1000str = Long.toString(s3j1000);
					String s3j100str = Long.toString(s3j100);
					String s3j10str = Long.toString(s3j10);
					String s4j1000str = Long.toString(s4j1000);
					String s4j100str = Long.toString(s4j100);
					String s4j10str = Long.toString(s4j10);
					// Doing the main calculations for inv mix columns
					String s1j0e = xor(xor(s1j1000str, s1j100str), s1j10str);
					String s2j0b = xor(xor(s2j1000str, s2j10str), s2jxo);
					String s3j0d = xor(xor(s3j1000str, s3j100str), s3jxo);
					String s4j09 = xor(s4j1000str, s4jxo);
					String s1j09 = xor(s1j1000str, s1jxo);
					String s2j0e = xor(xor(s2j1000str, s2j100str), s2j10str);
					String s3j0b = xor(xor(s3j1000str, s3j10str), s3jxo);
					String s4j0d = xor(xor(s4j1000str, s4j100str), s4jxo);
					String s1j0d = xor(xor(s1j1000str, s1j100str), s1jxo);
					String s2j09 = xor(s2j1000str, s2jxo);
					String s3j0e = xor(xor(s3j1000str, s3j100str), s3j10str);
					String s4j0b = xor(xor(s4j1000str, s4j10str), s4jxo);
					String s1j0b = xor(xor(s1j1000str, s1j10str), s1jxo);
					String s2j0d = xor(xor(s2j1000str, s2j100str), s2jxo);
					String s3j09 = xor(s3j1000str, s3jxo);
					String s4j0e = xor(xor(s4j1000str, s4j100str), s4j10str);
					String s1x = xor(xor(s1j0e, s2j0b), xor(s3j0d, s4j09));
					String s2x = xor(xor(s1j09, s2j0e), xor(s3j0b, s4j0d));
					String s3x = xor(xor(s1j0d, s2j09), xor(s3j0e, s4j0b));
					String s4x = xor(xor(s1j0b, s2j0d), xor(s3j09, s4j0e));
					// If any value has a length of greater than 0 and the first 
					// element is a 0, get rid of the first element
					while(s1x.length() > 8 && s1x.substring(0, 1).equals("0")) {
						s1x = s1x.substring(1);
					}
					while(s2x.length() > 8 && s2x.substring(0, 1).equals("0")) {
						s2x = s2x.substring(1);
					}
					while(s3x.length() > 8 && s3x.substring(0, 1).equals("0")) {
						s3x = s3x.substring(1);
					}
					while(s4x.length() > 8 && s4x.substring(0, 1).equals("0")) {
						s4x = s4x.substring(1);
					}
					while(s1x.length() > 8 || s2x.length() > 8 || s3x.length() > 8 || s4x.length() > 8) {
						// Xoring any value with the aes polynomial that is greater than 8.
						// Making sure the xor from the highest degree to the lowest for most
						// accurate xor calculations
						String poly = "100011011";
						if(s1x.length() > 8) {
							while(poly.length() < s1x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s1x = xor(s1x, poly);
							while(s1x.length() != 8 && s1x.substring(0, 1).equals("0")) {
								s1x = s1x.substring(1);
							}
						}
						poly = "100011011";
						if(s2x.length() > 8) {
							while(poly.length() < s2x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s2x = xor(s2x, poly);
							while(s2x.length() != 8 && s2x.substring(0, 1).equals("0")) {
								s2x = s2x.substring(1);
							}
						}
						poly = "100011011";
						if(s3x.length() > 8) {
							while(poly.length() < s3x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s3x = xor(s3x, poly);
							while(s3x.length() != 8 && s3x.substring(0, 1).equals("0")) {
								s3x = s3x.substring(1);
							}
						}
						poly = "100011011";
						if(s4x.length() > 8) {
							while(poly.length() < s4x.length()) {
								Long pol = Long.parseLong(poly);
								Long po = pol * 10;
								poly = Long.toString(po);
							}
							s4x = xor(s4x, poly);
							while(s4x.length() != 8 && s4x.substring(0, 1).equals("0")) {
								s4x = s4x.substring(1);
							}
						}
					}
					// Binary to decimal
					int s1bi = Integer.parseInt(s1x, 2);
					int s2bi = Integer.parseInt(s2x, 2);
					int s3bi = Integer.parseInt(s3x, 2);
					int s4bi = Integer.parseInt(s4x, 2);
					// Decimal to hexadecimal
					String s1 = Integer.toHexString(s1bi);
					String s2 = Integer.toHexString(s2bi);
					String s3 = Integer.toHexString(s3bi);
					String s4 = Integer.toHexString(s4bi);
					if(s1.length() == 1) {
						s1 = "0" + s1;
					}
					if(s2.length() == 1) {
						s2 = "0" + s2;
					}
					if(s3.length() == 1) {
						s3 = "0" + s3;
					}
					if(s4.length() == 1) {
						s4 = "0" + s4;
					}
					aespart = aespart + s1+s2+s3+s4;
				}
				// Shifting the rows
				String pr = aespart.substring(0, 2);
				String qr = aespart.substring(2, 4);
				String rr = aespart.substring(4, 6);
				String sr = aespart.substring(6, 8);
				String tr = aespart.substring(8, 10);
				String ur = aespart.substring(10, 12);
				String vr = aespart.substring(12, 14);
				String wr = aespart.substring(14, 16);
				String xr = aespart.substring(16, 18);
				String yr = aespart.substring(18, 20);
				String zr = aespart.substring(20, 22);
				String aar = aespart.substring(22, 24);
				String abr = aespart.substring(24, 26);
				String acr = aespart.substring(26, 28);
				String adr = aespart.substring(28, 30);
				String aer = aespart.substring(30);
				String afr = pr+acr+zr+wr+tr+qr+adr+aar+xr+ur+rr+aer+abr+yr+vr+sr;
				String mr = "";
				// Inverse sub bytes step (inv sbox)
				for(int l = 0; l < 16; l++) {
					String n = afr.substring(0, 2);
					if(afr.length() != 2) {
						String o = afr.substring(2);
						afr = o;
					}
					mr = mr + invSbox(n);
				}
				String e = expkeyclone.substring(expkeyclone.length() - 32);
				// The add round key step
				// The last block of finding the plaintext and the last round key
				// also xors with the ciphertext right before the one that is currently in use
				if(i == 1) {
					round = xorhex(e, mr);
				} else if(j == 1) {
					round = xorhex(xorhex(e, mr), 
							ciphertext.substring(ciphertext.length() - 32));
				} else {
					round = xorhex(e, mr);
				}
				part = round;
				if(expkeyclone.length() != 32) {
					String gds = expkeyclone.substring(0, expkeyclone.length() - 32);
					expkeyclone = gds;
				}
			}
		}
		aes = part + aes;
		return aes;
	}
}
