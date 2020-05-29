//The “King Number” is a prime number that is the 
//factor of the most numbers in a given list. Can you 
//find the “King Number”  in each list? For example,
//for the list {2, 3, 5, 6, 9, 14, 20},
//the answer is 2, since it's a factor of 2, 6, 14 and 20, 
//while 3 is only a factor of 3, 6 and 9.

package com.varnit.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Question1 {

	public static void main(String[] args) {
		int[] list_of_numbers = { 2, 2, 3, 5, 6, 9, 14, 20, 2, 223, 513, 13 };
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter number of items in a list");
		// int number_of_items = scanner.nextInt();
		//
		// int[] list_of_numbers = new int[number_of_items];
		// System.out.println("Enter the numbers for the list: ");
		// for (int i = 0; i < number_of_items; i++) {
		// System.out.println("Enter number " + i + " :");
		// list_of_numbers[i] = scanner.nextInt();
		// }

		long start = System.nanoTime();
		kingNumber(list_of_numbers);
		long elapsed_time = System.nanoTime() - start;
		System.out.println("elapsed time kingNumber: " + elapsed_time);

		// scanner.close();
	}

	private static void kingNumber(int[] list_of_numbers) {
		Arrays.sort(list_of_numbers);
		Map<Integer, Integer> hm = new HashMap<>();

		int count = 0;
		for (int i = 0; i < list_of_numbers.length; i++) {
			boolean isPrime = isPrime(list_of_numbers[i]) == 0 ? false : true;
			if (isPrime) {
				for (int j = i + 1; j < list_of_numbers.length; j++) {
					if (i != j && (list_of_numbers[j] % list_of_numbers[i]) == 0) {
						count++;
					}
				}
			} else {
				continue;
			}
			hm.put(list_of_numbers[i], count);
			count = 0;
		}

		int maximum_value_in_map = Collections.max(hm.values());
		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == maximum_value_in_map) {
				System.out.println("number in list with maximum no. of factors : " + entry.getKey() + " with "
						+ entry.getValue() + " factors");
			}
		}
	}

	public static int isPrime(int number) {
		int val = 0;
		for (int j = 2; j <= number; j++) {
			if (number != j && (number % j == 0)) {
				val = 0;
				break;
			} else {
				val = 1;
			}
		}
		return val;
	}

}
