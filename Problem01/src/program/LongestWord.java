package program;

import java.util.Scanner;

public class LongestWord {
	private static String longestWord(String str) {
		String strLongest = "";
		String[] arrWord = str.split(" ");
		for (int i = 0; i < arrWord.length; i++) {
			if (arrWord[i].length() > strLongest.length()) {
				strLongest = arrWord[i];
			}
		}
		return strLongest;
	}

	public static void main(String[] args) {
		System.out.print("Input a string: ");
		String str = new Scanner(System.in).nextLine();
		System.out.println("-->The longest word: " + longestWord(str));
	}
}
