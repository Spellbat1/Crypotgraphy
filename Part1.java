package FinalProject;

import java.util.Scanner;
public class Part1 {
	
	public static void main(String[] args) {
		// Making sure that anyone can put in anything to use the program
		Scanner scan = new Scanner(System.in);
		String key;
		// Getting Key
		System.out.println("Choose a key:");
		key = scan.nextLine();
		// Getting the appropriate key extension
		if(key.length() == 32) {
			System.out.println(aes128(key));
		} else if(key.length() == 48) {
			System.out.println(aes192(key));
		} else if(key.length() == 64) {
			System.out.println(aes256(key));
		}
		scan.close();
	}

	// Shift everything to the left
	public static String leftShift(String a) {
		String c = a.substring(0, 2);
		String d = a.substring(2);
		String b = d + c;
		return b;
	}
	// Getting the appropriate sbox values
	public static String sbox(String l) {
		String a = "";
		for(int i = 0; i < l.length(); i += 2) {
			String x = l.substring(i, i+2);
			int s = 0x00;
			if(x.equalsIgnoreCase("00")){
				s = 0x63;
			} else if(x.equalsIgnoreCase("01")){
				s = 0x7C;
			} else if(x.equalsIgnoreCase("02")){
				s = 0x77;
			} else if(x.equalsIgnoreCase("03")){
				s = 0x7B;
			} else if(x.equalsIgnoreCase("04")){
				s = 0xF2;
			} else if(x.equalsIgnoreCase("05")){
				s = 0x6B;
			} else if(x.equalsIgnoreCase("06")){
				s = 0x6F;
			} else if(x.equalsIgnoreCase("07")){
				s = 0xC5;
			} else if(x.equalsIgnoreCase("08")){
				s = 0x30;
			} else if(x.equalsIgnoreCase("09")){
				s = 0x01;
			} else if(x.equalsIgnoreCase("0A")){
				s = 0x67;
			} else if(x.equalsIgnoreCase("0B")){
				s = 0x2B;
			} else if(x.equalsIgnoreCase("0C")){
				s = 0xFE;
			} else if(x.equalsIgnoreCase("0D")){
				s = 0xD7;
			} else if(x.equalsIgnoreCase("0E")){
				s = 0xAB;
			} else if(x.equalsIgnoreCase("0F")){
				s = 0x76;
			} else if(x.equalsIgnoreCase("10")){
				s = 0xCA;
			} else if(x.equalsIgnoreCase("11")){
				s = 0x82;
			} else if(x.equalsIgnoreCase("12")) {
				s = 0xC9;
			} else if(x.equalsIgnoreCase("13")){
				s = 0x7D;
			} else if(x.equalsIgnoreCase("14")){
				s = 0xFA;
			} else if(x.equalsIgnoreCase("15")){
				s = 0x59;
			} else if(x.equalsIgnoreCase("16")){
				s = 0x47;
			} else if(x.equalsIgnoreCase("17")){
				s = 0xF0;
			} else if(x.equalsIgnoreCase("18")){
				s = 0xAD;
			} else if(x.equalsIgnoreCase("19")){
				s = 0xD4;
			} else if(x.equalsIgnoreCase("1A")){
				s = 0xA2;
			} else if(x.equalsIgnoreCase("1B")){
				s = 0xAF;
			} else if(x.equalsIgnoreCase("1C")){
				s = 0x9C;
			} else if(x.equalsIgnoreCase("1D")){
				s = 0xA4;
			} else if(x.equalsIgnoreCase("1E")){
				s = 0x72;
			} else if(x.equalsIgnoreCase("1F")){
				s = 0xC0;
			} else if(x.equalsIgnoreCase("20")){
				s = 0xB7;
			} else if(x.equalsIgnoreCase("21")){
				s = 0xFD;
			} else if(x.equalsIgnoreCase("22")){
				s = 0x93;
			} else if(x.equalsIgnoreCase("23")){
				s = 0x26;
			} else if(x.equalsIgnoreCase("24")){
				s = 0x36;
			} else if(x.equalsIgnoreCase("25")){
				s = 0x3F;
			} else if(x.equalsIgnoreCase("26")){
				s = 0xF7;
			} else if(x.equalsIgnoreCase("27")){
				s = 0xCC;
			} else if(x.equalsIgnoreCase("28")){
				s = 0x34;
			} else if(x.equalsIgnoreCase("29")){
				s = 0xA5;
			} else if(x.equalsIgnoreCase("2A")){
				s = 0xE5;
			} else if(x.equalsIgnoreCase("2B")){
				s = 0xF1;
			} else if(x.equalsIgnoreCase("2C")){
				s = 0x71;
			} else if(x.equalsIgnoreCase("2D")){
				s = 0xD8;
			} else if(x.equalsIgnoreCase("2E")){
				s = 0x31;
			} else if(x.equalsIgnoreCase("2F")){
				s = 0x15;
			} else if(x.equalsIgnoreCase("30")){
				s = 0x04;
			} else if(x.equalsIgnoreCase("31")){
				s = 0xC7;
			} else if(x.equalsIgnoreCase("32")){
				s = 0x23;
			} else if(x.equalsIgnoreCase("33")){
				s = 0xC3;
			} else if(x.equalsIgnoreCase("34")){
				s = 0x18;
			} else if(x.equalsIgnoreCase("35")){
				s = 0x96;
			} else if(x.equalsIgnoreCase("36")){
				s = 0x05;
			} else if(x.equalsIgnoreCase("37")){
				s = 0x9A;
			} else if(x.equalsIgnoreCase("38")){
				s = 0x07;
			} else if(x.equalsIgnoreCase("39")){
				s = 0x12;
			} else if(x.equalsIgnoreCase("3A")){
				s = 0x80;
			} else if(x.equalsIgnoreCase("3B")){
				s = 0xE2;
			} else if(x.equalsIgnoreCase("3C")){
				s = 0xEB;
			} else if(x.equalsIgnoreCase("3D")){
				s = 0x27;
			} else if(x.equalsIgnoreCase("3E")){
				s = 0xB2;
			} else if(x.equalsIgnoreCase("3F")){
				s = 0x75;
			} else if(x.equalsIgnoreCase("40")){
				s = 0x09;
			} else if(x.equalsIgnoreCase("41")){
				s = 0x83;
			} else if(x.equalsIgnoreCase("42")){
				s = 0x2C;
			} else if(x.equalsIgnoreCase("43")){
				s = 0x1A;
			} else if(x.equalsIgnoreCase("44")){
				s = 0x1B;
			} else if(x.equalsIgnoreCase("45")){
				s = 0x6E;
			} else if(x.equalsIgnoreCase("46")){
				s = 0x5A;
			} else if(x.equalsIgnoreCase("47")){
				s = 0xA0;
			} else if(x.equalsIgnoreCase("48")){
				s = 0x52;
			} else if(x.equalsIgnoreCase("49")){
				s = 0x3B;
			} else if(x.equalsIgnoreCase("4A")){
				s = 0xD6;
			} else if(x.equalsIgnoreCase("4B")){
				s = 0xB3;
			} else if(x.equalsIgnoreCase("4C")){
				s = 0x29;
			} else if(x.equalsIgnoreCase("4D")){
				s = 0xE3;
			} else if(x.equalsIgnoreCase("4E")){
				s = 0x2F;
			} else if(x.equalsIgnoreCase("4F")){
				s = 0x84;
			} else if(x.equalsIgnoreCase("50")){
				s = 0x53;
			} else if(x.equalsIgnoreCase("51")){
				s = 0xD1;
			} else if(x.equalsIgnoreCase("52")){
				s = 0x00;
			} else if(x.equalsIgnoreCase("53")){
				s = 0xED;
			} else if(x.equalsIgnoreCase("54")){
				s = 0x20;
			} else if(x.equalsIgnoreCase("55")){
				s = 0xFC;
			} else if(x.equalsIgnoreCase("56")){
				s = 0xB1;
			} else if(x.equalsIgnoreCase("57")){
				s = 0x5B;
			} else if(x.equalsIgnoreCase("58")){
				s = 0x6A;
			} else if(x.equalsIgnoreCase("59")){
				s = 0xCB;
			} else if(x.equalsIgnoreCase("5A")){
				s = 0xBE;
			} else if(x.equalsIgnoreCase("5B")){
				s = 0x39;
			} else if(x.equalsIgnoreCase("5C")){
				s = 0x4A;
			} else if(x.equalsIgnoreCase("5D")){
				s = 0x4C;
			} else if(x.equalsIgnoreCase("5E")){
				s = 0x58;
			} else if(x.equalsIgnoreCase("5F")){
				s = 0xCF;
			} else if(x.equalsIgnoreCase("60")){
				s = 0xD0;
			} else if(x.equalsIgnoreCase("61")){
				s = 0xEF;
			} else if(x.equalsIgnoreCase("62")){
				s = 0xAA;
			} else if(x.equalsIgnoreCase("63")){
				s = 0xFB;
			} else if(x.equalsIgnoreCase("64")){
				s = 0x43;
			} else if(x.equalsIgnoreCase("65")){
				s = 0x4D;
			} else if(x.equalsIgnoreCase("66")){
				s = 0x33;
			} else if(x.equalsIgnoreCase("67")){
				s = 0x85;
			} else if(x.equalsIgnoreCase("68")){
				s = 0x45;
			} else if(x.equalsIgnoreCase("69")){
				s = 0xF9;
			} else if(x.equalsIgnoreCase("6A")){
				s = 0x02;
			} else if(x.equalsIgnoreCase("6B")){
				s = 0x7F;
			} else if(x.equalsIgnoreCase("6C")){
				s = 0x50;
			} else if(x.equalsIgnoreCase("6D")){
				s = 0x3C;
			} else if(x.equalsIgnoreCase("6E")){
				s = 0x9F;
			} else if(x.equalsIgnoreCase("6F")){
				s = 0xA8;
			} else if(x.equalsIgnoreCase("70")){
				s = 0x51;
			} else if(x.equalsIgnoreCase("71")){
				s = 0xA3;
			} else if(x.equalsIgnoreCase("72")){
				s = 0x40;
			} else if(x.equalsIgnoreCase("73")){
				s = 0x8F;
			} else if(x.equalsIgnoreCase("74")){
				s = 0x92;
			} else if(x.equalsIgnoreCase("75")){
				s = 0x9D;
			} else if(x.equalsIgnoreCase("76")){
				s = 0x38;
			} else if(x.equalsIgnoreCase("77")){
				s = 0xF5;
			} else if(x.equalsIgnoreCase("78")){
				s = 0xBC;
			} else if(x.equalsIgnoreCase("79")){
				s = 0xB6;
			} else if(x.equalsIgnoreCase("7A")){
				s = 0xDA;
			} else if(x.equalsIgnoreCase("7B")){
				s = 0x21;
			} else if(x.equalsIgnoreCase("7C")){
				s = 0x10;
			} else if(x.equalsIgnoreCase("7D")){
				s = 0xFF;
			} else if(x.equalsIgnoreCase("7E")){
				s = 0xF3;
			} else if(x.equalsIgnoreCase("7F")){
				s = 0xD2;
			} else if(x.equalsIgnoreCase("80")){
				s = 0xCD;
			} else if(x.equalsIgnoreCase("81")){
				s = 0x0C;
			} else if(x.equalsIgnoreCase("82")){
				s = 0x13;
			} else if(x.equalsIgnoreCase("83")){
				s = 0xEC;
			} else if(x.equalsIgnoreCase("84")){
				s = 0x5F;
			} else if(x.equalsIgnoreCase("85")){
				s = 0x97;
			} else if(x.equalsIgnoreCase("86")){
				s = 0x44;
			} else if(x.equalsIgnoreCase("87")){
				s = 0x17;
			} else if(x.equalsIgnoreCase("88")){
				s = 0xC4;
			} else if(x.equalsIgnoreCase("89")){
				s = 0xA7;
			} else if(x.equalsIgnoreCase("8A")){
				s = 0x7E;
			} else if(x.equalsIgnoreCase("8B")){
				s = 0x3D;
			} else if(x.equalsIgnoreCase("8C")){
				s = 0x64;
			} else if(x.equalsIgnoreCase("8D")){
				s = 0x5D;
			} else if(x.equalsIgnoreCase("8E")){
				s = 0x19;
			} else if(x.equalsIgnoreCase("8F")){
				s = 0x73;
			} else if(x.equalsIgnoreCase("90")){
				s = 0x60;
			} else if(x.equalsIgnoreCase("91")){
				s = 0x81;
			} else if(x.equalsIgnoreCase("92")){
				s = 0x4F;
			} else if(x.equalsIgnoreCase("93")){
				s = 0xDC;
			} else if(x.equalsIgnoreCase("94")){
				s = 0x22;
			} else if(x.equalsIgnoreCase("95")){
				s = 0x2A;
			} else if(x.equalsIgnoreCase("96")){
				s = 0x90;
			} else if(x.equalsIgnoreCase("97")){
				s = 0x88;
			} else if(x.equalsIgnoreCase("98")){
				s = 0x46;
			} else if(x.equalsIgnoreCase("99")){
				s = 0xEE;
			} else if(x.equalsIgnoreCase("9A")){
				s = 0xB8;
			} else if(x.equalsIgnoreCase("9B")){
				s = 0x14;
			} else if(x.equalsIgnoreCase("9C")){
				s = 0xDE;
			} else if(x.equalsIgnoreCase("9D")){
				s = 0x5E;
			} else if(x.equalsIgnoreCase("9E")){
				s = 0x0B;
			} else if(x.equalsIgnoreCase("9F")){
				s = 0xDB;
			} else if(x.equalsIgnoreCase("A0")){
				s = 0xE0;
			} else if(x.equalsIgnoreCase("A1")){
				s = 0x32;
			} else if(x.equalsIgnoreCase("A2")){
				s = 0x3A;
			} else if(x.equalsIgnoreCase("A3")){
				s = 0x0A;
			} else if(x.equalsIgnoreCase("A4")){
				s = 0x49;
			} else if(x.equalsIgnoreCase("A5")){
				s = 0x06;
			} else if(x.equalsIgnoreCase("A6")){
				s = 0x24;
			} else if(x.equalsIgnoreCase("A7")){
				s = 0x5C;
			} else if(x.equalsIgnoreCase("A8")){
				s = 0xC2;
			} else if(x.equalsIgnoreCase("A9")){
				s = 0xD3;
			} else if(x.equalsIgnoreCase("AA")){
				s = 0xAC;
			} else if(x.equalsIgnoreCase("AB")){
				s = 0x62;
			} else if(x.equalsIgnoreCase("AC")){
				s = 0x91;
			} else if(x.equalsIgnoreCase("AD")){
				s = 0x95;
			} else if(x.equalsIgnoreCase("AE")){
				s = 0xE4;
			} else if(x.equalsIgnoreCase("AF")){
				s = 0x79;
			} else if(x.equalsIgnoreCase("B0")){
				s = 0xE7;
			} else if(x.equalsIgnoreCase("B1")){
				s = 0xC8;
			} else if(x.equalsIgnoreCase("B2")){
				s = 0x37;
			} else if(x.equalsIgnoreCase("B3")){
				s = 0x6D;
			} else if(x.equalsIgnoreCase("B4")){
				s = 0x8D;
			} else if(x.equalsIgnoreCase("B5")){
				s = 0xD5;
			} else if(x.equalsIgnoreCase("B6")){
				s = 0x4E;
			} else if(x.equalsIgnoreCase("B7")){
				s = 0xA9;
			} else if(x.equalsIgnoreCase("B8")){
				s = 0x6C;
			} else if(x.equalsIgnoreCase("B9")){
				s = 0x56;
			} else if(x.equalsIgnoreCase("BA")){
				s = 0xF4;
			} else if(x.equalsIgnoreCase("BB")){
				s = 0xEA;
			} else if(x.equalsIgnoreCase("BC")){
				s = 0x65;
			} else if(x.equalsIgnoreCase("BD")){
				s = 0x7A;
			} else if(x.equalsIgnoreCase("BE")){
				s = 0xAE;
			} else if(x.equalsIgnoreCase("BF")){
				s = 0x08;
			} else if(x.equalsIgnoreCase("C0")){
				s = 0xBA;
			} else if(x.equalsIgnoreCase("C1")){
				s = 0x78;
			} else if(x.equalsIgnoreCase("C2")){
				s = 0x25;
			} else if(x.equalsIgnoreCase("C3")){
				s = 0x2E;
			} else if(x.equalsIgnoreCase("C4")){
				s = 0x1C;
			} else if(x.equalsIgnoreCase("C5")){
				s = 0xA6;
			} else if(x.equalsIgnoreCase("C6")){
				s = 0xB4;
			} else if(x.equalsIgnoreCase("C7")){
				s = 0xC6;
			} else if(x.equalsIgnoreCase("C8")){
				s = 0xE8;
			} else if(x.equalsIgnoreCase("C9")){
				s = 0xDD;
			} else if(x.equalsIgnoreCase("CA")){
				s = 0x74;
			} else if(x.equalsIgnoreCase("CB")){
				s = 0x1F;
			} else if(x.equalsIgnoreCase("CC")){
				s = 0x4B;
			} else if(x.equalsIgnoreCase("CD")){
				s = 0xBD;
			} else if(x.equalsIgnoreCase("CE")){
				s = 0x8B;
			} else if(x.equalsIgnoreCase("CF")){
				s = 0x8A;
			} else if(x.equalsIgnoreCase("D0")){
				s = 0x70;
			} else if(x.equalsIgnoreCase("D1")){
				s = 0x3E;
			} else if(x.equalsIgnoreCase("D2")){
				s = 0xB5;
			} else if(x.equalsIgnoreCase("D3")){
				s = 0x66;
			} else if(x.equalsIgnoreCase("D4")){
				s = 0x48;
			} else if(x.equalsIgnoreCase("D5")){
				s = 0x03;
			} else if(x.equalsIgnoreCase("D6")){
				s = 0xF6;
			} else if(x.equalsIgnoreCase("D7")){
				s = 0x0E;
			} else if(x.equalsIgnoreCase("D8")){
				s = 0x61;
			} else if(x.equalsIgnoreCase("D9")){
				s = 0x35;
			} else if(x.equalsIgnoreCase("DA")){
				s = 0x57;
			} else if(x.equalsIgnoreCase("DB")){
				s = 0xB9;
			} else if(x.equalsIgnoreCase("DC")){
				s = 0x86;
			} else if(x.equalsIgnoreCase("DD")){
				s = 0xC1;
			} else if(x.equalsIgnoreCase("DE")){
				s = 0x1D;
			} else if(x.equalsIgnoreCase("DF")){
				s = 0x9E;
			} else if(x.equalsIgnoreCase("E0")){
				s = 0xE1;
			} else if(x.equalsIgnoreCase("E1")){
				s = 0xF8;
			} else if(x.equalsIgnoreCase("E2")) {
				s = 0x98;
			} else if(x.equalsIgnoreCase("E3")) {
				s = 0x11;
			} else if(x.equalsIgnoreCase("E4")) {
				s = 0x69;
			} else if(x.equalsIgnoreCase("E5")) {
				s = 0xD9;
			} else if(x.equalsIgnoreCase("E6")) {
				s = 0x8E;
			} else if(x.equalsIgnoreCase("E7")) {
				s = 0x94;
			} else if(x.equalsIgnoreCase("E8")) {
				s = 0x9B;
			} else if(x.equalsIgnoreCase("E9")) {
				s = 0x1E;
			} else if(x.equalsIgnoreCase("EA")) {
				s = 0x87;
			} else if(x.equalsIgnoreCase("EB")) {
				s = 0xE9;
			} else if(x.equalsIgnoreCase("EC")) {
				s = 0xCE;
			} else if(x.equalsIgnoreCase("ED")) {
				s = 0x55;
			} else if(x.equalsIgnoreCase("EE")) {
				s = 0x28;
			} else if(x.equalsIgnoreCase("EF")) {
				s = 0xDF;
			} else if(x.equalsIgnoreCase("F0")) {
				s = 0x8C;
			} else if(x.equalsIgnoreCase("F1")) {
				s = 0xA1;
			} else if(x.equalsIgnoreCase("F2")) {
				s = 0x89;
			} else if(x.equalsIgnoreCase("F3")) {
				s = 0x0D;
			} else if(x.equalsIgnoreCase("F4")) {
				s = 0xBF;
			} else if(x.equalsIgnoreCase("F5")) {
				s = 0xE6;
			} else if(x.equalsIgnoreCase("F6")) {
				s = 0x42;
			} else if(x.equalsIgnoreCase("F7")) {
				s = 0x68;
			} else if(x.equalsIgnoreCase("F8")) {
				s = 0x41;
			} else if(x.equalsIgnoreCase("F9")) {
				s = 0x99;
			} else if(x.equalsIgnoreCase("FA")) {
				s = 0x2D;
			} else if(x.equalsIgnoreCase("FB")) {
				s = 0x0F;
			} else if(x.equalsIgnoreCase("FC")) {
				s = 0xB0;
			} else if(x.equalsIgnoreCase("FD")) {
				s = 0x54;
			} else if(x.equalsIgnoreCase("FE")) {
				s = 0xBB;
			} else {
				s = 0x16;
			}
			String n = ("00" 
			+ Integer.toHexString(s)).substring(Integer.toHexString(s).length());
			a = a + n;
		}
		return a;
	}
	
	// Getting the appropriate round constant
	public static String roundConstant(String b, int round) {
		String a = "";
		// Only a certain size is needed for this
		if(round < 8) {
			int c = (int) Math.pow(10, round);
			String d = b.substring(0, 2);
			String f = b.substring(2);
			int e = Integer.parseInt(d, 16);
			String g = Integer.toBinaryString(e);
			int h = Integer.parseInt(g);
			int i = h + c;
			String j = String.format("%08d", i);
			String k = j.replaceAll("2", "0");
			int l = Integer.parseInt(k, 2);
			String m = Integer.toHexString(l);
			if(m.length() == 1) {
				m = "0" + m;
			}
			a = m + f;
			return a;
		} else {
			// If the string is too long
			int p = 100011011 * (int) Math.pow(10, round - 8);
			int c = (int) Math.pow(10,  round);
			String d = Integer.toString(c);
			while(d.length() > 8) {
				int e = p + c;
				String f = String.format("%08d", e);
				String g = f.replaceAll("2", "0");
				c = Integer.parseInt(g);
				d = Integer.toString(c);
				if(d.length() > 8) {
					String h = Integer.toString(p);
					while(d.length() != h.length()) {
						p = p/10;
						h = Integer.toString(p);
					}
				}
			}
			String z = b.substring(0, 2);
			String y = b.substring(2);
			int x = Integer.parseInt(z, 16);
			String w = Integer.toBinaryString(x);
			int v = Integer.parseInt(w);
			int u = v + c;
			String t = String.format("%08d", u);
			String s = t.replaceAll("2", "0");
			int r = Integer.parseInt(s, 2);
			String q = Integer.toHexString(r);
			if(q.length() == 1) {
				q = "0" + q;
			}
			a = q + y;
			return a;
		}
	}
	
	// Using the AES128 Key Expansion
	public static String aes128(String key) {
		int round = 0;
		String expkey = key;
		String temp1 = expkey.substring(expkey.length()-8);
		String temp2 = expkey.substring(0, 8);
		// Until it gets to a certain size
		while(expkey.length() < (176*2)) {
			// Goes 4 times
			for(int j = 0; j < 4; j++) {
				// On the time, Shift, use the sbox and do the round constant
				if(j == 0) {
					temp1 = leftShift(temp1);
					temp1 = sbox(temp1);
					temp1 = roundConstant(temp1, round);
					round++;
				}
				// Too long for int
				long a = Long.parseLong(temp1, 16);
				// Setting b and f to have the correct number of bytes 
				String b = ("00000000000000000000000000000000" 
				+ Long.toBinaryString(a)).substring(Long.toBinaryString(a).length());
				long c = Long.parseLong(b.substring(0, 16));
				long d = Long.parseLong(b.substring(16));
				long e = Long.parseLong(temp2, 16);
				String f = ("00000000000000000000000000000000" 
				+ Long.toBinaryString(e)).substring(Long.toBinaryString(e).length());
				long g = Long.parseLong(f.substring(0, 16));
				long h = Long.parseLong(f.substring(16));
				// Xoring g with c and d with h
				long i = g + c;
				long k = d + h;
				String l = String.format("%016d", i);
				String m = String.format("%016d", k);
				String n = l.replaceAll("2", "0");
				String o = m.replaceAll("2", "0");
				int p = Integer.parseInt(n, 2);
				int q = Integer.parseInt(o, 2);
				String y = Integer.toHexString(p); 
				String z = Integer.toHexString(q);
				for(int x = 0; x < 4; x++) {
					if(y.length() < 4) {
						y = "0" + y;
					}
					if(z.length() < 4) {
						z = "0" + z;
					}
				}
				String r = y + z;
				expkey = expkey + r;
				temp1 = r;
				temp2 = expkey.substring(expkey.indexOf(temp2) + 8, expkey.indexOf(temp2) + 16);
			}
		}
		return expkey;
	}
	
	// Using the AES192 Key Expansion
	public static String aes192(String key) {
		int round = 0;
		String expkey = key;
		String temp1 = expkey.substring(expkey.length()-8);
		String temp2 = expkey.substring(0, 8);
		// Until it gets to a certain size
		while(expkey.length() < (208*2)) {
			// Goes 6 times
			for(int j = 0; j < 6; j++) {
				// On the time, Shift, use the sbox and do the round constant
				if(j == 0) {
					temp1 = leftShift(temp1);
					temp1 = sbox(temp1);
					temp1 = roundConstant(temp1, round);
					round++;
				}
				// Too long for int
				long a = Long.parseLong(temp1, 16);
				// Setting b and f to have the correct number of bytes 
				String b = ("00000000000000000000000000000000" 
				+ Long.toBinaryString(a)).substring(Long.toBinaryString(a).length());
				long c = Long.parseLong(b.substring(0, 16));
				long d = Long.parseLong(b.substring(16));
				long e = Long.parseLong(temp2, 16);
				String f = ("00000000000000000000000000000000" 
				+ Long.toBinaryString(e)).substring(Long.toBinaryString(e).length());
				long g = Long.parseLong(f.substring(0, 16));
				long h = Long.parseLong(f.substring(16));
				// Xoring g with c and d with h
				long i = g + c;
				long k = d + h;
				String l = String.format("%016d", i);
				String m = String.format("%016d", k);
				String n = l.replaceAll("2", "0");
				String o = m.replaceAll("2", "0");
				int p = Integer.parseInt(n, 2);
				int q = Integer.parseInt(o, 2);
				String y = Integer.toHexString(p); 
				String z = Integer.toHexString(q);
				for(int x = 0; x < 4; x++) {
					if(y.length() < 4) {
						y = "0" + y;
					}
					if(z.length() < 4) {
						z = "0" + z;
					}
				}
				String r = y + z;
				expkey = expkey + r;
				temp1 = r;
				temp2 = expkey.substring(expkey.indexOf(temp2) + 8, expkey.indexOf(temp2) + 16);
			}
		}
		return expkey;
	}
	
	// Using the AES256 Key Expansion
	public static String aes256(String key) {
		int round = 0;
		String expkey = key;
		String temp1 = expkey.substring(expkey.length()-8);
		String temp2 = expkey.substring(0, 8);
		// Until it gets to a certain size
		while(expkey.length() < (240*2)) {
			// Goes 8 times
			for(int j = 0; j < 8; j++) {
				// On the time, Shift, use the sbox and do the round constant
				if(j == 0) {
					temp1 = leftShift(temp1);
					temp1 = sbox(temp1);
					temp1 = roundConstant(temp1, round);
					round++;
				}
				// On the fifth time, use the sbox
				if(j == 4) {
					temp1 = sbox(temp1);
				}
				// Too long for int
				long a = Long.parseLong(temp1, 16);
				// Setting b and f to have the correct number of bytes 
				String b = ("00000000000000000000000000000000" 
				+ Long.toBinaryString(a)).substring(Long.toBinaryString(a).length());
				long c = Long.parseLong(b.substring(0, 16));
				long d = Long.parseLong(b.substring(16));
				long e = Long.parseLong(temp2, 16);
				String f = ("00000000000000000000000000000000" 
				+ Long.toBinaryString(e)).substring(Long.toBinaryString(e).length());
				long g = Long.parseLong(f.substring(0, 16));
				long h = Long.parseLong(f.substring(16));
				// Xoring g with c and d with h
				long i = g + c;
				long k = d + h;
				String l = String.format("%016d", i);
				String m = String.format("%016d", k);
				String n = l.replaceAll("2", "0");
				String o = m.replaceAll("2", "0");
				int p = Integer.parseInt(n, 2);
				int q = Integer.parseInt(o, 2);
				String y = Integer.toHexString(p); 
				String z = Integer.toHexString(q);
				for(int x = 0; x < 4; x++) {
					if(y.length() < 4) {
						y = "0" + y;
					}
					if(z.length() < 4) {
						z = "0" + z;
					}
				}
				String r = y + z;
				expkey = expkey + r;
				temp1 = r;
				temp2 = expkey.substring(expkey.indexOf(temp2) + 8, expkey.indexOf(temp2) + 16);
			}
		}
		return expkey;
	}
}
