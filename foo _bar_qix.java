package com.LinkedList;

import java.util.Arrays;

public class test1 {
	public static void main(String[] args) {
		foo_bar_qix(303);
	}

	private static void foo_bar_qix(int num) {

		String result_string = "";

		Boolean flag = false;
		if (num < 3) {
			System.out.println(num);
			return;
		}

		if (num % 3 == 0) {
			result_string += "Foo";
			flag = true;
		}

		if (num % 5 == 0) {
			result_string += "Bar";
			flag = true;
		}

		if (num % 7 == 0) {
			result_string += "Qix";
			flag = true;
		}

		if (num < 9) {
			if (!flag) {
				System.out.println(num);
				return;
			}

			if (num == 3) {
				result_string += "Foo";
			}

			if (num == 5) {
				result_string += "Bar";
			}

			if (num == 7) {
				result_string += "Qix";
			}
		}

		if (num > 9) {

			int[] digits_array = extractDigits(num);
			System.out.println(Arrays.toString(digits_array));
			for (int i = 0; i < digits_array.length; i++) {
				if (digits_array[i] == 3) {
					result_string += "Foo";
				} else if (digits_array[i] == 5) {
					result_string += "Bar";
				} else if (digits_array[i] == 7) {
					result_string += "Qix";
				} else if (digits_array[i] == 0) {
					result_string += '*';
				}

			}
		}
		System.out.println(result_string);
	}

	private static int[] extractDigits(int num) {
		int length = Integer.toString(num).length();

		int[] digit_array = new int[length];
		int i = 0;
		while (num >= 1) {
			digit_array[digit_array.length - i - 1] = num % 10;
			num = num / 10;
			i++;
		}
		return digit_array;
	}

}
