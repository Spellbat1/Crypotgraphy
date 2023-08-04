package FinalProject;

import java.util.Scanner;

public class Part2 {
	
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
		// Encrypting the plaintext
		System.out.println("Choose the plaintext:");
		String plaintext = "";
		plaintext = scan.nextLine();
		System.out.println("Type in 'CBC' if you want to use the CBC mode. Type anything else for ECB mode:");
		String mode = scan.nextLine();
		if(mode.equalsIgnoreCase("CBC")) {
			// Encrypting the plaintext in CBC
			System.out.println(aesEncryptCBC(expkey, plaintext));
		} else {
			// Encrypting the plaintext in ECB
			System.out.println(aesEncryptECB(expkey, plaintext));
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
	
	// Xoring in hexadecimal
	public static String xorhex(String a, String b) {
		String c = "";
		// Getting the amount of times to run
		Long d = (long) (a.length()/2);
		String e = "";
		String g = "";
		for(int i = 0; i < d; i++) {
			// Will cause an error if this code runs when the length of a is 2
			if(a.length() != 2) {
				e = a.substring(0, 2);
				String f = a.substring(2);
				g = b.substring(0, 2);
				String h = b.substring(2);
				a = f;
				b = h;
			} else {
				e = a;
				g = b.substring(0, 2);
			}
			// Going from hexadecimal to decimal
			Long j = Long.parseLong(e, 16);
			Long k = Long.parseLong(g, 16);
			// Going from decimal to Binary
			String l = Long.toBinaryString(j);
			String m = Long.toBinaryString(k);
			// Xoring
			String n = xor(l, m);
			// Going from binary to decimal
			Long o = Long.parseLong(n, 2);
			// Going from decimal to hexadecimal
			String p = Long.toHexString(o);
			// Adding a 0 in the beginning when there is only 1 character in the hexadecimal
			if(p.length() == 1) {
				p = "0" + p;
			}
			c = c + p;
		}
		return c;
	}
	
	// Code for xoring
	public static String xor(String a, String b) {
		// Add the two numbers
		Long c = Long.parseLong(a);
		Long d = Long.parseLong(b);
		Long e = d + c;
		// Making sure that the number is at least length 8 and then making sure
		// that the only numbers are 0 and 1 in the number
		String f = String.format("%08d", e);
		String g = f.replaceAll("2", "0");
		// If the length is 9 but the first element is 0, get rid of the first element
		if(g.length() == 9 && g.substring(0, 1).contentEquals("0")) {
			g = g.substring(1);
		}
		return g;
	}
	
	// Encrypting ECB mode
	public static String aesEncryptECB(String expkey, String plaintext) {
		int a = expkey.length()/2;
		int b = plaintext.length()/2;
		int c = a/16 - 2;
		if(expkey.length() == 512) {
			c = c - 1;
		}
		int d = b/16;
		String aes = "";
		for(int i = 0; i < d; i++) {
			String last = plaintext.substring(0, 32);
			// Making sure to reallocate the plaintext
			if(plaintext.length() != 32) {
				String h = plaintext.substring(32);
				plaintext = h;
			}
			String expkeyclone = expkey;
			String aespart = "";
			for(int j = 0; j < c; j++) {
				String e = expkeyclone.substring(0, 32);
				String f = expkeyclone.substring(32);
				expkeyclone = f;
				// The add round key step
				String k = xorhex(e, last);
				last = "";
				String m = "";
				// Sub bytes step (sbox)
				for(int l = 0; l < 16; l++) {
					String n = k.substring(0, 2);
					if(k.length() != 2) {
						String o = k.substring(2);
						k = o;
					}
					m = m + Part1.sbox(n);
				}
				// Shifting the rows
				String p = m.substring(0, 2);
				String q = m.substring(2, 4);
				String r = m.substring(4, 6);
				String s = m.substring(6, 8);
				String t = m.substring(8, 10);
				String u = m.substring(10, 12);
				String v = m.substring(12, 14);
				String w = m.substring(14, 16);
				String x = m.substring(16, 18);
				String y = m.substring(18, 20);
				String z = m.substring(20, 22);
				String aa = m.substring(22, 24);
				String ab = m.substring(24, 26);
				String ac = m.substring(26, 28);
				String ad = m.substring(28, 30);
				String ae = m.substring(30);
				String af = p+u+z+ae+t+y+ad+s+x+ac+r+w+ab+q+v+aa;
				// The mix columns step
				for(int zz = 0; zz < 4; zz++) {
					// Updating the allocating from af and updating af
					String s1j = af.substring(0, 2);
					String s2j = af.substring(2, 4);
					String s3j = af.substring(4, 6);
					String s4j = af.substring(6, 8);
					if(af.length() > 8) {
						af = af.substring(8);
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
					int s1jbin = Integer.parseInt(s1jxo);
					int s2jbin = Integer.parseInt(s2jxo);
					int s3jbin = Integer.parseInt(s3jxo);
					int s4jbin = Integer.parseInt(s4jxo);
					int s1j10 = s1jbin * 10;
					int s2j10 = s2jbin * 10;
					int s3j10 = s3jbin * 10;
					int s4j10 = s4jbin * 10;
					String s1j10str = Integer.toString(s1j10);
					String s2j10str = Integer.toString(s2j10);
					String s3j10str = Integer.toString(s3j10);
					String s4j10str = Integer.toString(s4j10);
					// Doing the main calculations for mix columns
					String s1j11 = xor(s1j10str, s1jxo);
					String s2j11 = xor(s2j10str, s2jxo);
					String s3j11 = xor(s3j10str, s3jxo);
					String s4j11 = xor(s4j10str, s4jxo);
					String s1x = xor(xor(s1j10str, s2j11), xor(s3jxo, s4jxo));
					String s2x = xor(xor(s1jxo, s2j10str), xor(s3j11, s4jxo));
					String s3x = xor(xor(s1jxo, s2jxo), xor(s3j10str, s4j11));
					String s4x = xor(xor(s1j11, s2jxo), xor(s3jxo, s4j10str));
					// If any length is greater than 8, xor it with the aes polynomial
					if(s1x.length() > 8) {
						s1x = xor(s1x, "100011011");
					}
					if(s2x.length() > 8) {
						s2x = xor(s2x, "100011011");
					}
					if(s3x.length() > 8) {
						s3x = xor(s3x, "100011011");
					}
					if(s4x.length() > 8) {
						s4x = xor(s4x, "100011011");
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
					last = last + s1+s2+s3+s4;
				}
			}
			String ag = expkeyclone.substring(0, 32);
			String ah = expkeyclone.substring(32);
			// Round key step
			String round = xorhex(last, ag);
			String m = "";
			// Sub bytes step (sbox)
			for(int l = 0; l < 16; l++) {
				String n = round.substring(0, 2);
				if(round.length() != 2) {
					String o = round.substring(2);
					round = o;
				}
				m = m + Part1.sbox(n);
			}
			// Shifting the rows
			String p = m.substring(0, 2);
			String q = m.substring(2, 4);
			String r = m.substring(4, 6);
			String s = m.substring(6, 8);
			String t = m.substring(8, 10);
			String u = m.substring(10, 12);
			String v = m.substring(12, 14);
			String w = m.substring(14, 16);
			String x = m.substring(16, 18);
			String y = m.substring(18, 20);
			String z = m.substring(20, 22);
			String aa = m.substring(22, 24);
			String ab = m.substring(24, 26);
			String ac = m.substring(26, 28);
			String ad = m.substring(28, 30);
			String ae = m.substring(30);
			String af = p+u+z+ae+t+y+ad+s+x+ac+r+w+ab+q+v+aa;
			// Round key step one more time
			aespart = xorhex(af, ah);
			aes = aes + aespart;
		}
		return aes;
	}
	
	// Encrypting CBC mode
	public static String aesEncryptCBC(String expkey, String plaintext) {
		int a = expkey.length()/2;
		int b = plaintext.length()/2;
		int c = a/16 - 2;
		if(expkey.length() == 512) {
			c = c - 1;
		}
		String aespart = "";
		int d = b/16;
		String aes = "";
		for(int i = 0; i < d; i++) {
			String last = plaintext.substring(0, 32);
			// Making sure to reallocate the plaintext
			if(plaintext.length() != 32) {
				String h = plaintext.substring(32);
				plaintext = h;
			}
			String expkeyclone = expkey;
			for(int j = 0; j < c; j++) {
				String e = expkeyclone.substring(0, 32);
				String f = expkeyclone.substring(32);
				expkeyclone = f;
				String k = "";
				// The add round key step
				// First block and every round key is normal, 
				// first round key of the block after the first 
				// block also xors with the ciphertext from the 
				// previous round
				if(i == 0) {
					k = xorhex(e, last);
				} else if(j == 0) {
					k = xorhex(xorhex(e, last), aespart);
				} else {
					k = xorhex(e, last);
				}
				last = "";
				String m = "";
				// Sub bytes step (sbox)
				for(int l = 0; l < 16; l++) {
					String n = k.substring(0, 2);
					if(k.length() != 2) {
						String o = k.substring(2);
						k = o;
					}
					m = m + Part1.sbox(n);
				}
				// Shifting the rows
				String p = m.substring(0, 2);
				String q = m.substring(2, 4);
				String r = m.substring(4, 6);
				String s = m.substring(6, 8);
				String t = m.substring(8, 10);
				String u = m.substring(10, 12);
				String v = m.substring(12, 14);
				String w = m.substring(14, 16);
				String x = m.substring(16, 18);
				String y = m.substring(18, 20);
				String z = m.substring(20, 22);
				String aa = m.substring(22, 24);
				String ab = m.substring(24, 26);
				String ac = m.substring(26, 28);
				String ad = m.substring(28, 30);
				String ae = m.substring(30);
				String af = p+u+z+ae+t+y+ad+s+x+ac+r+w+ab+q+v+aa;
				// The mix columns step
				for(int zz = 0; zz < 4; zz++) {
					// Updating the allocating from af and updating af
					String s1j = af.substring(0, 2);
					String s2j = af.substring(2, 4);
					String s3j = af.substring(4, 6);
					String s4j = af.substring(6, 8);
					if(af.length() > 8) {
						af = af.substring(8);
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
					int s1jbin = Integer.parseInt(s1jxo);
					int s2jbin = Integer.parseInt(s2jxo);
					int s3jbin = Integer.parseInt(s3jxo);
					int s4jbin = Integer.parseInt(s4jxo);
					int s1j10 = s1jbin * 10;
					int s2j10 = s2jbin * 10;
					int s3j10 = s3jbin * 10;
					int s4j10 = s4jbin * 10;
					String s1j10str = Integer.toString(s1j10);
					String s2j10str = Integer.toString(s2j10);
					String s3j10str = Integer.toString(s3j10);
					String s4j10str = Integer.toString(s4j10);
					// Doing the main calculations for mix columns
					String s1j11 = xor(s1j10str, s1jxo);
					String s2j11 = xor(s2j10str, s2jxo);
					String s3j11 = xor(s3j10str, s3jxo);
					String s4j11 = xor(s4j10str, s4jxo);
					String s1x = xor(xor(s1j10str, s2j11), xor(s3jxo, s4jxo));
					String s2x = xor(xor(s1jxo, s2j10str), xor(s3j11, s4jxo));
					String s3x = xor(xor(s1jxo, s2jxo), xor(s3j10str, s4j11));
					String s4x = xor(xor(s1j11, s2jxo), xor(s3jxo, s4j10str));
					// If any length is greater than 8, xor it with the aes polynomial
					if(s1x.length() > 8) {
						s1x = xor(s1x, "100011011");
					}
					if(s2x.length() > 8) {
						s2x = xor(s2x, "100011011");
					}
					if(s3x.length() > 8) {
						s3x = xor(s3x, "100011011");
					}
					if(s4x.length() > 8) {
						s4x = xor(s4x, "100011011");
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
					last = last + s1+s2+s3+s4;
				}
			}
			String ag = expkeyclone.substring(0, 32);
			String ah = expkeyclone.substring(32);
			// Round key step
			String round = xorhex(last, ag);
			String m = "";
			// SubByte step (sbox)
			for(int l = 0; l < 16; l++) {
				String n = round.substring(0, 2);
				if(round.length() != 2) {
					String o = round.substring(2);
					round = o;
				}
				m = m + Part1.sbox(n);
			}
			// Shifting the rows
			String p = m.substring(0, 2);
			String q = m.substring(2, 4);
			String r = m.substring(4, 6);
			String s = m.substring(6, 8);
			String t = m.substring(8, 10);
			String u = m.substring(10, 12);
			String v = m.substring(12, 14);
			String w = m.substring(14, 16);
			String x = m.substring(16, 18);
			String y = m.substring(18, 20);
			String z = m.substring(20, 22);
			String aa = m.substring(22, 24);
			String ab = m.substring(24, 26);
			String ac = m.substring(26, 28);
			String ad = m.substring(28, 30);
			String ae = m.substring(30);
			String af = p+u+z+ae+t+y+ad+s+x+ac+r+w+ab+q+v+aa;
			// Round key step one more time
			aespart = xorhex(af, ah);
			aes = aes + aespart;
		}
		return aes;
	}
}
