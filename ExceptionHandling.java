
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		bufferedReaderException(bufferedReader);
		int[] b = {};
		min(b);
	}

	public static void bufferedReaderException(BufferedReader bufferedReader1) {

		try {
			bufferedReader1 = new BufferedReader(new FileReader("/Users/varnit.rohilla/java.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		} finally {
			try {
				System.out.println(bufferedReader1.readLine());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public static int min(int[] b) {

		try {
			int min = b[0];
			for (int k = 0; k < b.length; k = k + 1) {
				if (b[k] > min)
					min = b[k];
			}
			return min;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("min of 0 values doesn't exist if b is empty.");
		}

	}
}

class ImplementCustomException {

	public void caller() {
		try {
			validate(13);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void validate(int age) throws CustomException {
		if (age < 18)
			throw new CustomException("age should be greater the 18");
		else
			System.out.println(age + " is valid age to do this");
	}

}

class ProblemException {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter the numerator");
				String numerator = scanner.nextLine();

				if (numerator.equals("quit"))
					break;

				System.out.println("Enter the denominator");
				String denominator = scanner.nextLine();

				double division_result = division(numerator, denominator);
				System.out.println("divided:" + division_result);

			} catch (ArithmeticException ae) {
				System.out.println("division by zero");
			} catch (NumberFormatException ne) {
				System.out.println("bad input");
			}
		}
		System.out.println("Thanks");
		scanner.close();
	}

	public static double division(String numerator, String denominator) {
		int Integer_numerator = Integer.valueOf(numerator);
		int Integer_denominator = Integer.valueOf(denominator);
		return Integer_numerator / Integer_denominator;
	}
}

class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomException() {
	}

	public CustomException(String message) {

		super(message);
	}
}
