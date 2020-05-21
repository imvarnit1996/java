package com.varnit.topics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DifferentMethods {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		 smallestAmongThree(scanner);
		 average(scanner);
		 middelCharacter(scanner);
		 countingWord(scanner);
		 sumOfDigits(scanner);
		 pentagonalNumbers();
		 findThefutureValues(scanner);
		 leapYearTest(scanner);
		 validPassword(scanner);
		 randomMatrix(scanner);
		 areaOfTriangle(scanner);
		 areaOfPentagon(scanner);
		 primePairs(scanner);
		 compoundInterest(2000, 0.8, 5, 12);
		 simpleInterest(2000, 0.8, 5);
		 quotientAndRemainder(8, 3);
		 reversingWords("Welcome to BeginnersBook");
		 fibonacci(5);
		 reversingNumbers(123);
		 reversingTheArray(new int[] { 1, 2, 3, 4, 5, });
		 charcterToString(new char[] { 'v', 'a', 'r', 'n', 'i', 't' });

		 ComplexNumberSum temp_obj = ComplexNumberSum.sumOfComplexNumbers(new ComplexNumberSum(5, 2.2),new ComplexNumberSum(2.4, 6.6));
		 System.out.println("Complex number:" + temp_obj.real + "+" + temp_obj.imaginary + "i");
		 
		 new LeapYear(2016);
		 
		 System.out.println("factorial: " + factorial(5));
		 System.out.println("palindrome string: " + stringPalindrome("varnit rohilla"));
		 System.out.println("palindrome string " +
		 efficientStringPalindrome("aba"));
		 System.out.println(permutationAndCombination(5, 3));
		 System.out.println("\nString: klasddkluiyuyjjjjuuioll");
		 System.out.println("-------------------------");
		
		 duplicateCharacters("klasddkluiyuyjjjjuuioll");
		 System.out.println("\nString: #@$@!#$%!!%@");
		 System.out.println("-------------------------");
		 duplicateUsingHashMap("#@$@!#$%!!%@");
		
		 System.out.println("palindrome checking using recursion: " +
		 palindromeUsingRecursion("asddd"));
		 System.out.println("reversed using recursion: " +
		 reverseUsingRecursion("asddd"));

		scanner.close();
	}

	public static void primePairs(Scanner scanner) {
		boolean first;
		boolean second;
		for (int i = 2; i < 100; i++) {
			first = isPrime(i);
			second = isPrime(i + 2);
			if (first && second) {
				System.out.println("Prime pairs: " + i + "," + (i + 2));
			}
		}
	}

	public static boolean isPrime(int i) {
		for (int j = 2; j <= i / 2; j++) {
			if (i % j == 0)
				return false;
		}
		return true;
	}

	public static void areaOfPentagon(Scanner scanner) {
		double area_of_pentagon = 5 * areaOfTriangle(scanner);
		System.out.println("Area of pentagon:" + area_of_pentagon);
	}

	public static double areaOfTriangle(Scanner scanner) {
		System.out.println("Enter BASE SIDE");
		int base = scanner.nextInt();
		System.out.println("Enter Height");
		int height = scanner.nextInt();

		double area_of_traingle = (0.5) * (base) * (height);
		System.out.println("Area of triangle: " + area_of_traingle);
		return area_of_traingle;

	}

	public static void randomMatrix(Scanner scanner) {
		System.out.println("Enter a NUMBER");
		int number = scanner.nextInt();

		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print((int) (Math.random() * 2) + " ");
			}
			System.out.println();
		}

	}

	public static void validPassword(Scanner scanner) {
		System.out.println("1. A password must have at least eight characters." + "\n"
				+ "2. A password consists of only letters and digits." + "\n"
				+ "3. A password must contain at least two digits");
		System.out.println("Enter the password:");
		String password = scanner.nextLine();

		boolean check_password_length = password.length() == 8;
		int is_number = 0;

		for (int i = 0; i < password.length(); i++) {
			char element = password.charAt(i);
			Character.toUpperCase(element);
			if (element >= 'A' && element <= 'Z') {
				continue;
			} else if (element >= '0' && element <= '9') {
				is_number++;
			}
		}
		if (check_password_length)
			if (is_number <= 2) {
				System.out.println("password is not valid");
			} else {
				System.out.println("password is valid");
			}
		else {
			System.out.println("password is not valid");
		}
	}

	public static void leapYearTest(Scanner scanner) {
		System.out.println("Enter a year to check");
		int year = scanner.nextInt();

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.println("It is a leap year");
				} else {
					System.out.println("It is no leap year");
				}

			} else {
				System.out.println("It is leap year");
			}
		} else {
			System.out.println("The year is not a leap year");
		}
	}

	public static void findThefutureValues(Scanner scanner) {
		System.out.println("Enter the principle amount: ");
		int principle_amount = scanner.nextInt();
		System.out.println("Enter the rate of interest: ");
		int interest = scanner.nextInt();
		System.out.println("Enter the number of years: ");
		int year = scanner.nextInt();
		int future_amount = 0;
		for (int i = 1; i < year; i++) {
			future_amount += (principle_amount * interest * year);
			System.out.println("future values: " + i + " " + " " + year + " " + future_amount);
		}
	}

	public static void pentagonalNumbers() {
		System.out.print("pentagonal number series: ");
		for (int i = 0; i < 50; i++) {
			int pentagonal_number = ((3 * i * i) - i) / 2;
			System.out.print(pentagonal_number + " ");
		}
	}

	public static void sumOfDigits(Scanner scanner) {

		System.out.println("Enter a big number:");
		int number = scanner.nextInt();
		int sum_of_digits = 0;
		while (number > 0) {
			sum_of_digits += (number % 10);
			number /= 10;

		}

		System.out.println("som of digits :" + sum_of_digits);
	}

	public static void countingWord(Scanner scanner) {
		System.out.println("Enter a string: ");
		String string = scanner.nextLine();
		String[] string_array = string.split(" ");

		System.out.println("total number of word are:" + string_array.length);

	}

	public static void middelCharacter(Scanner scanner) {
		System.out.println("Enter a string:");
		String string = scanner.nextLine();
		int mid = string.length() / 2;
		System.out.println(mid);
		char middle_character = string.charAt(string.length() / 2);
		System.out.println("middle character: " + middle_character);
	}

	public static void average(Scanner scanner) {
		System.out.println("Enter a number:");
		int first_number = scanner.nextInt();
		int second_number = scanner.nextInt();
		int third_number = scanner.nextInt();
		int average = (first_number + second_number + third_number) / 3;
		System.out.println("avearage: " + average);
	}

	public static void smallestAmongThree(Scanner scanner) {

		System.out.println("Enter a number:");
		int first_number = scanner.nextInt();
		int second_number = scanner.nextInt();
		int third_number = scanner.nextInt();

		if (first_number < second_number) {
			if (second_number > third_number) {
				System.out.println(second_number + " is greater");
			} else {
				System.out.println(third_number + " is greater");
			}
		} else if (first_number > third_number) {
			System.out.println(first_number + " is greater");
		}
	}

	// Basic
	public static void compoundInterest(double p, double r, int t, int n) {
		double compound_interest = (p * Math.pow((1 + (r / n)), (n * t))) - p;
		System.out.println("compound interest: " + compound_interest);

	}

	public static void simpleInterest(double p, double r, int t) {
		double simple_interest = (p * r * t) / 100;
		System.out.println("simple interest: " + simple_interest);
	}

	public static void quotientAndRemainder(double numerator, double denominator) {
		double quotient = numerator / denominator;
		double remainder = numerator % denominator;
		System.out.println("quotient: " + quotient + " remainder: " + remainder);
	}

	public static int factorial(int number) {
		if (number == 1 || number == 0)
			return 1;
		int fact = factorial(number - 1) * number;
		return fact;
	}

	public static void fibonacci(int upto) {
		int previous = 0, current = 1;
		while (previous < upto) {
			System.out.println(previous);
			int temp = previous + current;
			previous = current;
			current = temp;
		}
	}

	public static boolean stringPalindrome(String string) {
		int length_of_string = string.length() - 1;
		String palindrome_string = "";
		for (int i = length_of_string; i >= 0; i--) {
			palindrome_string += string.charAt(i);
		}

		System.out.println("reversed string: " + palindrome_string);
		if (palindrome_string.equals(string))
			return true;
		else
			return false;
	}

	public static boolean efficientStringPalindrome(String string) {
		int length_of_string = string.length() - 1;

		for (int i = 0; i < length_of_string / 2; i++) {
			if (string.charAt(i) != string.charAt(length_of_string - i))
				return false;
		}
		return true;
	}

	public static String permutationAndCombination(int n, int r) {
		if (n <= r) {
			return "n should be greater than r";
		}
		int factorial_n = factorial(n);
		int factorial_nr = factorial(n - r);
		int factorial_r = factorial(r);

		int permutation = factorial_n / factorial_nr;
		int combination = factorial_n / (factorial_nr * factorial_r);

		System.out.println("Permutation(NPR): " + permutation + " Combination(NCR): " + combination);

		return "successful";
	}

	// Strings

	public static void duplicateUsingHashMap(String string) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] charArray = string.toCharArray();

		for (Character ch : charArray) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		Set<Character> key_set = map.keySet();

		for (Character ch : key_set) {
			if (map.get(ch) > 1) {
				System.out.println("Character: " + ch + " " + map.get(ch));
			}
		}
	}

	public static void reversingWords(String string) {
		String[] word = string.split(" ");
		String reversed_string = "";

		for (int i = 0; i <= word.length - 1; i++) {
			String reversed_word = "";
			for (int j = word[i].length() - 1; j >= 0; j--) {
				reversed_word += word[i].charAt(j);
			}
			reversed_string += reversed_word + " ";
		}

		System.out.println(string);
		System.out.println(reversed_string);
	}

	private static void duplicateCharacters(String string) {
		char[] arr1 = string.toUpperCase().toCharArray();
		int length = string.length();
		int count = 1;
		String s = "";
		char c1 = '\u0000';

		for (int i = 0; i < length; i++) {
			count = 1;
			for (int j = i + 1; j < length; j++) {
				if (arr1[i] == arr1[j]) {
					count++;
					c1 = arr1[i];
				}
				if (j == (length - 1) && c1 != '\u0000' && !s.contains(String.valueOf(c1))) {
					s = s + " " + String.valueOf(c1) + "  No of times:  " + count + "\n";
				}
			}
		}
		System.out.println("\nDuplicate char are:\n" + s);
	}

	// arrays
	public static void reversingTheArray(int[] integer_array) {
		for (int i = 0; i < integer_array.length / 2; i++) {
			int temp = integer_array[i];
			integer_array[i] = integer_array[integer_array.length - i - 1];
			integer_array[integer_array.length - i - 1] = temp;
		}
		System.out.println(Arrays.toString(integer_array));
	}

	public static void charcterToString(char[] character_array) {
		String string = String.valueOf(character_array);
		String string2 = new String(character_array);
		System.out.println("Method1: " + string + " Method2: " + string2);
	}

	// recursion

	public static void reversingNumbers(int number) {
		if (number < 10) {
			System.out.println(number);
			return;
		} else {
			System.out.print(number % 10);
			reversingNumbers(number / 10);
		}
	}

	public static boolean palindromeUsingRecursion(String string) {
		if (string.length() == 0 || string.length() == 1)
			return true;

		if (string.charAt(0) == string.charAt(string.length() - 1))
			return palindromeUsingRecursion(string.substring(1, string.length() - 1));

		return false;
	}

	public static String reverseUsingRecursion(String string) {
		if (string.isEmpty())
			return string;

		return reverseUsingRecursion(string.substring(1)) + string.charAt(0);
	}
}

class LeapYear {
	int year;

	LeapYear(int year) {
		this.year = year;
		checkLeapYear(year);
	}

	public void checkLeapYear(int year) {

		boolean isLeapYear = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeapYear = true;
				} else {
					isLeapYear = false;
				}
			} else {
				isLeapYear = true;
			}
		} else {
			isLeapYear = false;
		}

		if (isLeapYear)
			System.out.println(year + " is a leap year");
		else
			System.out.println(year + " is not a leap year");
	}
}

class ComplexNumberSum {
	double real, imaginary;

	ComplexNumberSum(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;

	}

	public static ComplexNumberSum sumOfComplexNumbers(ComplexNumberSum c1, ComplexNumberSum c2) {
		ComplexNumberSum temp_obj = new ComplexNumberSum(0, 0);

		temp_obj.real = c1.real + c2.real;
		temp_obj.imaginary = c1.imaginary + c2.imaginary;
		return temp_obj;
	}

}
