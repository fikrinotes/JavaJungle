import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class CaesarCipher {

	public static void main(String[] args) {
		String[] basic = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		System.out.println(encrypt(basic));
	}

	public static String encrypt(String[] basic) {
		Scanner str = new Scanner(System.in);
		System.out.print("Masukkan kata yang ingin anda enkripsi : ");
		String string = str.next();
		char[] kata = string.toCharArray();
		Scanner delta = new Scanner(System.in);
		System.out.print("masukkan kunci : ");
		int x = Integer.parseInt(delta.next());
		int n = kata.length;
		int b = 0;
		ArrayList<Character> base = new ArrayList<Character> ();
		char[] raw_result = new char[n];

		for (String i : basic) {
			base.add(i.charAt(0));
		}
		while (b<n) {
			if (base.contains(kata[b])) {
				int shift = (base.indexOf(kata[b]) + x)%26;
				raw_result[b] = base.get(shift);
			}
			b = b + 1;
		}

		String result = new String(raw_result);
		
		return result;
	}

}
