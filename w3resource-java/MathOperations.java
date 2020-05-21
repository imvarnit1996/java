package com.varnit.topics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class MathOpertaions {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numbers[] = scanNumbers(scanner);

		roundUp(numbers[0], numbers[1]);
		fractionalSeparator(numbers[0], numbers[1]);
		doubleOrNot(numbers[0], numbers[1]);
		NumberOfdistinctValuesInArrays();
		reversingIntegers(scanner);
		absoluteValue(scanner);
		identify15OrNot(numbers[0], numbers[1]);
		listOfprimeNumbers(scanner);
		withoutOperators(numbers[0], numbers[1]);
		longetSequnceOfZeroes(scanner);
		primeFactors(scanner, 0);
		maximumNumberofprimeFactors(numbers[0], numbers[1], scanner);
		palindromChecker(scanner, 0);
		nextPalindrome(scanner);
		withoutSeven(scanner);
		magicSquare(scanner);
		fibonacciNumberOrNot(scanner);
		isFibonacci(scanner);

		scanner.close();

	}

	public static void fibonacciNumberOrNot(Scanner scanner) {
		System.out.println("Enter a number ot check: ");
		int number = scanner.nextInt();

		int[] fibonacci_array = new int[number + 2];

		fibonacci_array[0] = 0;
		fibonacci_array[1] = 1;

		for (int i = 2; i <= number; i++) {
			fibonacci_array[i] = fibonacci_array[i - 2] + fibonacci_array[i - 1];
		}

		for (int i = 0; i < fibonacci_array.length; i++) {
			if (fibonacci_array[i] == number) {
				System.out.println("It is a fibonacci number");
				break;
			}
		}

	}

	static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	static boolean isFibonacci(Scanner scanner) {
		System.out.println("Enter a number ot check: ");
		int number = scanner.nextInt();
		return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
	}

	public static void nextPalindrome(Scanner scanner) {

		System.out.println("Enter a number: ");
		int number = scanner.nextInt();
		for (int i = number + 1; i > number; i++) {
			boolean palindrome_or_not = palindromChecker(scanner, i);
			if (palindrome_or_not == true) {
				System.out.println("the next smallest palindrome number is " + i);
				break;
			}
		}

	}

	public static boolean palindromChecker(Scanner scanner, int number) {

		// System.out.println("Enter a number to find palindrome");
		// int number = scanner.nextInt();
		int temp = number;
		int reversed_number = 0;
		boolean palindrome = false;

		while (number > 0) {
			int last_digit = number % 10;

			reversed_number = (reversed_number * 10) + last_digit;
			number /= 10;
		}
		if (temp == reversed_number) {
			palindrome = true;
			// System.out.println(reversed_number);
			// System.out.println("palindrome");
		} else {
			palindrome = false;
			// System.out.println(reversed_number);
			// System.out.println("not palindrome");
		}
		return palindrome;
	}

	public static void maximumNumberofprimeFactors(int number1, int number2, Scanner scanner) {
		int i = number1, count1 = 0, count2 = 0;

		HashSet<Integer> prime_factors_set = null;
		while (i <= number2) {

			prime_factors_set = new HashSet<>(primeFactors(scanner, i));
			i++;
			count1 = prime_factors_set.size();
			if (count1 > count2) {
				count2 = count1;
				count1 = 0;
			}
			System.out.println(prime_factors_set);

		}
		System.out.println("the maximum number of distinct prime fators in a given range : " + count2);

	}

	public static ArrayList<Integer> primeFactors(Scanner scanner, int number) {
		// System.out.println("Enter a number for which you want prime
		// factors");
		// int number = scanner.nextInt();
		ArrayList<Integer> prime_factors_list = new ArrayList<>();
		System.out.print("Prime factors of " + number + " are ");
		while ((number % 2) == 0) {
			prime_factors_list.add(2);
			number /= 2;
		}

		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			while ((number % i) == 0) {
				prime_factors_list.add(i);
				number /= i;
			}

		}

		if (number > 2) {
			prime_factors_list.add(number);
		}

		System.out.println(prime_factors_list);
		return prime_factors_list;

	}

	public static void magicSquare(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter the dimension for magic square N * N: ");
		int dimension = scanner.nextInt();

		int[][] magic_square = new int[dimension][dimension];
		int row = dimension / 2;
		int column = dimension - 1;

		for (int numbers = 0; numbers <= dimension * dimension;) {
			if (row == -1 && column == dimension) {
				column = dimension - 2;
				row = 0;

			} else {

				if (column == dimension)
					column = 0;

				if (row < 0)
					row = dimension - 1;

			}

			if (magic_square[row][column] != 0) {
				column -= 2;
				row++;
				continue;
			} else {
				magic_square[row][column] = numbers++;
				column++;
				row--;
				continue;
			}

		}
		System.out.println("The Magic Square for " + dimension + ":");
		System.out.println("Sum of each row or column " + dimension * (dimension * dimension + 1) / 2 + ":");
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.println(magic_square[i][j] + " ");
				System.out.println();
			}
		}

	}

	public static void withoutSeven(Scanner scanner) {

		System.out.println("Enter a number");
		int number = scanner.nextInt();
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if ((i % 10) != 7) {
				count++;
			} else {
				continue;
			}
		}
		System.out.println("Total numbers without 7: " + count);
	}

	public static void withoutOperators(int number1, int number2) {

		System.out.println("multiplication operator: " + Math.multiplyExact(number1, number2));
		System.out.println("division without operator: " + Math.floorDiv(number1, number2));
		System.out.println("addition without operator: " + Math.addExact(number1, number2));
		System.out.println("subtraction without operator: " + Math.subtractExact(number1, number2));

	}

	public static void longetSequnceOfZeroes(Scanner scanner) {

		int count1 = 0;
		int count2 = 0;
		Stack<Integer> stack = toBinary(scanner);
		for (int i = 0; i < stack.size(); i++) {
			int stack_element = stack.get(i);
			if (stack_element == 0) {
				count1++;
			} else {
				if (count1 > count2) {
					count2 = count1;
					count1 = 0;
				} else {
					continue;
				}

			}
		}
		System.out.println("");
		System.out.print("longest sequence of zeroes in binary representation: " + count2);
	}

	public static Stack<Integer> toBinary(Scanner scanner) {

		Stack<Integer> stack = new Stack<>();

		System.out.print("Enter a Decimal number: ");
		int decimal_number = scanner.nextInt();

		while (decimal_number > 0) {
			stack.push(decimal_number % 2);
			decimal_number /= 2;
		}
		System.out.print("binary representation: ");
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i));

		}

		return stack;

	}

	public static int[] scanNumbers(Scanner scanner) {
		System.out.print("Enter 1st number: ");
		int number1 = scanner.nextInt();
		System.out.print("Enter 2nd number: ");
		int number2 = scanner.nextInt();
		return new int[] { number1, number2 };

	}

	public static void absoluteValue(Scanner scanner) {
		System.out.print("Enter the number to find absolute value: ");
		int number = scanner.nextInt();
		System.out.println("Absolute value of the given number is: " + Math.abs(number));
	}

	public static void roundUp(int number1, int number2) {
		float division_result = number1 / number2;

		System.out.println("the division result after rounding up: " + Math.round(division_result));
	}

	public static void fractionalSeparator(int number1, int number2) {
		double division_result = number1 / number2;
		double fractional_part = division_result % 1;
		double integral_part = division_result - fractional_part;
		System.out.println("Division Result:" + division_result);
		System.out.println("Fractional part: " + fractional_part);
		System.out.println("Integral part: " + integral_part);
	}

	public static void doubleOrNot(int number1, int number2) {
		double division_result = number1 / number2;
		if ((division_result % 1) == 0) {
			System.out.println("Result is not double");
		} else {
			System.out.println("Result is double");
		}
	}

	public static void NumberOfdistinctValuesInArrays() {

		int[] numbers_array = new int[] { -1, -1, 0, 2, 2, 3, 0, 1, 5, 9 };

		int count = 0;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < numbers_array.length; i++) {
			int absoluteNumbers = Math.abs(numbers_array[i]);
			if (set.add(absoluteNumbers)) {
				count++;
			}
		}
		System.out.println("number of distinct varaible in array: " + count);
	}

	public static void reversingIntegers(Scanner scanner) {

		System.out.print("Enter a big number to reverse:");
		int number = scanner.nextInt();
		int reversed_integer = 0;

		while (number > 0) {
			reversed_integer = reversed_integer * 10 + number % 10;
			number = number / 10;
		}

		System.out.println("reversed integer: " + reversed_integer);
	}

	public static void identify15OrNot(int number1, int number2) {

		if (number1 == 15 || number2 == 15) {
			System.out.println("True");
		} else if (Math.abs(number1 + number2) == 15 || Math.abs(number1 - number2) == 15) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	public static void listOfprimeNumbers(Scanner scanner) {
		System.out.println("Enter a number: ");
		int number = scanner.nextInt();
		System.out.println("prime numbers are: ");
		for (int i = 2; i < number; i++) {
			boolean prime_number = isPrime(i) == 1 ? true : false;
			if (prime_number) {
				System.out.println(i);
			}
		}

	}

	public static Integer isPrime(int i) {
		int val = 0;
		for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				val = 0;
				break;
			} else {
				val = 1;
			}
		}
		return val;
	}

}
