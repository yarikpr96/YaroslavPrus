package answers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ComplementaryPairs {

	/**
	 * Input file location.
	 */
	private static final String fileName = "C:\\Users\\Ярослав\\java advanced\\WalletHub\\src\\main\\java\\tests\\ComplementaryPairs.txt";

	/***
	 * Main method.
	 * 
	 * @param args
	 *            - Program arguments.
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNext()) {
				String kLine = scanner.nextLine();
				String[] t = kLine.split(" ");

				int k = Integer.parseInt(t[0]);

				int[] a = new int[t.length - 1];
				for (int i = 1; i < t.length; i++) {
					a[i - 1] = Integer.valueOf(t[i]);
				}

				List<Pair> result = ComplementaryPairs.findKComplimentary(k, a);

				for (Pair pair : result) {
					System.out.println(String.format("The pair with values [%s],[%s] is K complementary of %s.", pair.x,
							pair.y, k));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static List<Pair> findKComplimentary(int k, int[] a) {

		List<Pair> result = new ArrayList<>();

		Set<Integer> uniqueNumbers = new HashSet<>();

		if (a == null || a.length < 2) {
			return result;
		}

		for (int n : a) { // O(n) complexity
			uniqueNumbers.add(n);
		}

		for (Integer number : uniqueNumbers) { // O(n) complexity
			if (number > k)
				continue;
			int diff = k - number;
			if (uniqueNumbers.contains(diff))
				result.add(new Pair(number, diff));

		}

		return result;

	}


	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

	}

}
