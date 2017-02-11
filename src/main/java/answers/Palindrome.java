package answers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Palindrome {

	/**
	 * Input file location.
	 */
	private static final String fileName = "C:\\Users\\Ярослав\\java advanced\\WalletHub\\src\\main\\java\\tests\\Palindrome.txt";

	/***
	 * Main method.
	 * 
	 * @param args
	 *            - Program arguments.
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(Palindrome.isPalindrome(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/***
	 * Returns if the given string is a palindrome or not.
	 * 
	 * @param test
	 *            - String under test.
	 * @return boolean indicating if this string is a palindrome.
	 */
	public static boolean isPalindrome(String test) {
		return new StringBuilder(test).reverse().toString().equalsIgnoreCase(test);
	}

}
