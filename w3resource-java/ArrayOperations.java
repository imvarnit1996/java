package com.varnit.topics;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int[] number_array_1 = { 10789, 2035, 1899, 1456, 2013, 1458, 2458,1254, 1472, 2365, 1456, 2165, 1457, 2456 };

		int[] number_array_1 = { 1, 2, 3, 4, 5, 6 };
		int[] number_array_2 = { 4, 5, 6, 7, 8, 9 };
		int[] number_array_3 = { 0, 0, 1, 0, 3, 0, 5, 0, 6 };

		// [] number_array_2 = { 1, 3, 55, 44, 456, 488, 876, 1234, 2, 5 };

		int[][] matrix1 = { { 2, 3, 4 }, { 3, 4, 5 }, { 5, 7, 8 } };
		int[][] matrix2 = { { 2, 3, 4 }, { 3, 4, 5 }, { 5, 7, 8 } };

		String[] string_array = { "Varnit", "Aditya", "Deepak", "Varnit", "rohilla", "rohilla" };

		sortingArrays(number_array_1, string_array);
		operationsOnElements(number_array_1);
		patternGrid();
		removeElement(number_array_1, scanner);
		maximumAndMinimum(number_array_1);
		reversingTheArray(number_array_1);
		duplicacy(number_array_1, string_array);
		compare_arrays(number_array_1, number_array_2);
		insertAtIndex(number_array_1, scanner);
		searchInarrays(number_array_1, string_array, scanner);
		secondLargest(number_array_1);
		secondSmallest(number_array_1);
		addingTwoMatrices(matrix1, matrix2);
		pairsOfSum(number_array_2);
		equalityOfTwoArrays(number_array_1, number_array_2);
		evenOrOdd(number_array_1);
		conversion of array to array list and vice versa
		ArrayList<Object> array_to_arraylist = new
		ArrayList<Object>(Arrays.asList(number_array));
		System.out.println(array_to_arraylist);
		array_to_arraylist.toArray();
		relativeOrderOfArrays(number_array_3);
		threeSortedArrays(number_array_1, number_array_2, number_array_3);

		scanner.close();
	}

	private static void relativeOrderOfArrays(int[] number_array_3) {
		// TODO Auto-generated method stub
		int size_of_array = number_array_3.length - 1;
		for (int i = 0; i <= size_of_array;) {
			if (number_array_3[i] == 0) {
				if (number_array_3[size_of_array - i - 1] != 0) {
					int temp = number_array_3[size_of_array - i - 1];
					number_array_3[size_of_array - i - 1] = number_array_3[i];
					number_array_3[i] = temp;
					i++;
				}
			}
		}

		System.out.println(Arrays.toString(number_array_3));
	}

	public static void threeSortedArrays(int[] number_array_1, int[] number_array_2, int[] number_array_3) {

	}

	public static void evenOrOdd(int[] number_array) {
		long start_time = System.nanoTime();
		int even = 0, odd = 0;
		for (int i = 0; i < number_array.length; i++) {
			if ((number_array[i] % 2) == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("even:" + even);
		System.out.println("odd:" + odd);

		long elapsed_time = System.nanoTime() - start_time;
		System.out.println("elapsed time : " + elapsed_time);
	}

	public static void equalityOfTwoArrays(int[] number_array_1, int[] number_array_2) {

		boolean equal = true;
		if (number_array_1.length == number_array_2.length) {
			for (int i = 0; i < number_array_1.length; i++) {
				if (number_array_1[i] != number_array_2[i]) {
					equal = false;
				}
			}
		} else {
			equal = false;
		}
		if (equal) {
			System.out.println("both arrays are equal");
		} else {
			System.out.println("both arrays are not equal");
		}
	}

	public static void pairsOfSum(int[] number_array) {

		int sum = 5;
		for (int i = 0; i < number_array.length; i++) {
			for (int j = i + 1; j < number_array.length; j++) {
				boolean test1 = number_array[i] + number_array[j] == sum;
				boolean test2 = i != j;
				if ((test1) && (test2)) {
					System.out.print("pairs:  " + number_array[i] + " " + number_array[j]);
					System.out.println();
				}
			}
		}
	}

	public static void addingTwoMatrices(int[][] matrix1, int[][] matrix2) {
		int[][] sum_result_of_matrices = new int[3][3];

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1.length; j++) {
				sum_result_of_matrices[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.print(sum_result_of_matrices[i][j] + " ");
			}
		}

	}

	public static void secondSmallest(int[] number_array) {

		int smallest_number = number_array[0];
		int second_smallest_number = 0;
		for (int i = 1; i < number_array.length; i++) {
			if (number_array[i] < smallest_number) {
				second_smallest_number = smallest_number;
				smallest_number = number_array[i];
			} else if (number_array[i] < second_smallest_number && second_smallest_number != smallest_number) {
				second_smallest_number = number_array[i];
			}
		}
		if (second_smallest_number == 0) {
			System.out.println("there is no second smallest number");
		} else {
			System.out.println("smallest number is:" + smallest_number);

			System.out.println("second smallest number is:" + second_smallest_number);
		}
	}

	public static void secondLargest(int[] number_array) {

		int largest_number = number_array[0];
		int second_largest_number = 0;
		for (int i = 1; i < number_array.length; i++) {
			if (number_array[i] > largest_number) {
				second_largest_number = largest_number;
				largest_number = number_array[i];
			} else if (number_array[i] > second_largest_number && second_largest_number != largest_number) {
				second_largest_number = number_array[i];
			}
		}
		if (second_largest_number == 0) {
			System.out.println("there is no second largest number");
		} else {
			System.out.println("second largest number is:" + largest_number);

			System.out.println("second largest number is:" + second_largest_number);
		}
	}

	public static void compare_arrays(int[] number_array, int[] number_array_2) {

		System.out.println("Both the arrays have these elements in common: ");
		for (int i = 0; i < number_array.length; i++) {
			for (int j = 0; j < number_array_2.length; j++) {
				if (number_array[i] == number_array_2[j]) {
					System.out.print(" " + number_array[j]);
				}
			}
		}
	}

	public static void duplicacy(int[] number_array, String[] string_array) {

		// for number array
		for (int i = 0; i < number_array.length; i++) {
			for (int j = i + 1; j < number_array.length; j++) {
				if (i != j && number_array[i] == number_array[j]) {
					System.out.println("duplicate elements at: " + j);
				} else if (i == number_array.length - 1) {
					System.out.println("there are no duplicate elements");
				}
			}
		}

		// for string array
		for (int i = 0; i < string_array.length; i++) {
			for (int j = i + 1; j < string_array.length; j++) {
				if (i != j && string_array[i].equals(string_array[j])) {
					System.out.println("duplicate elements at: " + j);

				} else if (i == string_array.length) {
					System.out.println("there are no duplicate elements");
				}
			}
		}

	}

	public static void reversingTheArray(int[] number_array) {

		for (int i = 0; i < number_array.length / 2; i++) {
			int temp = number_array[i];
			number_array[i] = number_array[number_array.length - i - 1];
			number_array[number_array.length - i - 1] = temp;

		}
		System.out.println(Arrays.toString(number_array));
	}

	public static void maximumAndMinimum(int[] number_array) {

		int largest_number = number_array[0];
		int smallest_number = number_array[0];
		int current_number = 0;
		for (int i = 1; i < number_array.length; i++) {
			current_number = number_array[i];
			if (current_number > largest_number) {
				largest_number = current_number;
			}

			if (current_number < smallest_number) {
				smallest_number = current_number;
			}
		}
		System.out.println("Largest number: " + largest_number);
		System.out.println("Smallest number: " + smallest_number);

	}

	public static void insertAtIndex(int[] number_array, Scanner scanner) {
		System.out.println("Enter the index you want to insert the element: ");
		int index_to_insert = scanner.nextInt();
		System.out.println("Enter the value you want to insert: ");
		int element_to_insert = scanner.nextInt();

		for (int i = number_array.length; i < index_to_insert; i--) {
			number_array[i] = number_array[i - 1];
		}

		number_array[index_to_insert] = element_to_insert;

		System.out.println("New Array:" + Arrays.toString(number_array));
	}

	public static void removeElement(int[] number_array, Scanner scanner) {

		System.out.println("Enter the index you want to remove the element");
		int index_to_remove = scanner.nextInt();

		if (index_to_remove < 0 || number_array == null || index_to_remove > number_array.length) {
			System.out.println("array index not valid");
		} else {
			int[] number_array_copy = new int[number_array.length - 1];
			for (int i = 0, k = 0; i < number_array.length; i++) {
				if (i == index_to_remove) {
					continue;
				}
				number_array_copy[k++] = number_array[i];
			}
			System.out.println("removed: " + Arrays.toString(number_array_copy));
		}

	}

	public static void searchInarrays(int[] number_array, String[] string_array, Scanner scanner) {

		System.out.println("Enter the number to search: ");
		int search_element_number = scanner.nextInt();
		boolean contain_number = Arrays.binarySearch(number_array, search_element_number) >= 0 ? true : false;
		if (contain_number) {
			System.out.println("Array contains the element");
		} else {
			System.out.println("Array does not contain this element");
		}

		System.out.println("Enter the String to search: ");
		String search_element_string = scanner.nextLine();
		boolean contain_string = Arrays.asList(string_array).contains(search_element_string);
		if (contain_string) {
			System.out.println("Array contains the element");
		} else {
			System.out.println("Array does not contain this element");
		}

	}

	public static void patternGrid() {

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.print("- ");
			}
			System.out.println();
		}
	}

	public static void operationsOnElements(int[] number_array) {

		int size_of_array = number_array.length;
		int sum = 0;
		int average = 0;

		// sum
		for (int j = 0; j < size_of_array; j++) {
			sum += number_array[j];
		}

		System.out.println("sum of elements: " + sum);

		// average
		for (int i = 0; i < size_of_array; i++) {
			average = sum / size_of_array;
		}
		System.out.println("Average of elements: " + average);

	}

	public static void sortingArrays(int[] number_array, String[] string_array) {
		Arrays.sort(number_array);
		System.out.println(Arrays.toString(number_array));
		Arrays.sort(string_array);
		System.out.println(Arrays.toString(string_array));
	}

}
