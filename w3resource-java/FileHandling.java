package com.varnit.topics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) throws IOException {

		File file = new File("/Users/varnit.rohilla/");// java.txt");
		BufferedReader bufferedReader1 = new BufferedReader(new FileReader("/Users/varnit.rohilla/java.txt"));
		BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/Users/varnit.rohilla/java - Copy.txt"));

		compareFiles(bufferedReader1, bufferedReader2);
		miscellaneous(file);
		// getExtension(file);
		listOfExtensions(file);
		// commandLineArguments();
		getFileSize(file);
		// byteArrayReadWrite();
		lineByline(bufferedReader1);
		lineBylineArray(bufferedReader1);
		longestWordInFile(bufferedReader1);
		bufferedReader1.close();
		bufferedReader2.close();

	}

	// miscellaneous
	public static void miscellaneous(File file) {
		Date date = new Date(file.lastModified());
		System.out.println("file is last modified on:" + date);
		System.out.println("file is a directory?" + file.isDirectory());
		System.out.println("file is a File?" + file.isFile());

	}

	// get Extension of file
	public static void getExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			System.out.println("File extension is: " + fileName.substring(fileName.lastIndexOf(".") + 1));
		} else {
			System.out.println("");
		}
	}

	// list of extensions

	public static void listOfExtensions(File file) {

		String[] list = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				if (name.toLowerCase().endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		});

		for (String s : list) {
			System.out.println(s);
		}

	}

	// compare files
	public static void compareFiles(BufferedReader reader1, BufferedReader reader2) throws IOException {
		boolean isEqual = true;
		String line1 = reader1.readLine();
		String line2 = reader2.readLine();
		@SuppressWarnings("unused")
		int line = 1;
		while (line1 != null || line2 != null) {
			if (line1 == null || line2 == null) {
				isEqual = false;
				break;
			} else if (!line1.equals(line2)) {
				isEqual = false;
				break;
			}
			line1 = reader1.readLine();
			line2 = reader2.readLine();
			line++;
		}

		if (isEqual) {
			System.out.println("the files are same");
		} else {
			System.out.println("files are different");
		}
	}

	// take commandLine arguments and print
	public static void commandLineArguments() throws IOException {
		System.out.print("Enter something: ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		System.out.println("you entered: " + input);
		// input = new Scanner(System.in);
		// String input2 = input.nextLine();
		// System.out.println("your input is: " + input2);

	}

	// get size of file

	public static void getFileSize(File file) {
		if (!file.exists() || !file.isFile()) {
			System.out.println("size of file is " + getFileSizeMegaBytes(file));
			System.out.println("size of file is " + getFileSizeKiloBytes(file));
			System.out.println("size of file is " + getFileSizeBytes(file));
		}

	}

	private static String getFileSizeBytes(File file) {
		return (double) file.length() + "Bytes";
	}

	private static String getFileSizeKiloBytes(File file) {
		return (double) file.length() / 1024 + "KB";

	}

	private static String getFileSizeMegaBytes(File file) {
		return (double) file.length() / 1024 * 1024 + "MB";
	}

	// public static void byteArrayReadWrite() {
	// byte[] byteArray = { 2, 3, 4, 5 };
	//
	// ByteArrayInputStream bi = new ByteArrayInputStream(byteArray);
	//
	// System.out.println(bi);
	// }

	// to read line by line
	public static void lineByline(BufferedReader bufferedReader) throws IOException {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		while ((strLine = bufferedReader.readLine()) != null) {
			sb.append(strLine);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);

	}

	// to print like an array in file
	public static void lineBylineArray(BufferedReader bufferedReader) throws IOException {
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		String strLine = "";
		while ((strLine = bufferedReader.readLine()) != null) {
			sb.append(strLine);
			sb.append(System.lineSeparator());
			list.add(strLine);
		}
		// System.out.println(list);
		System.out.println(Arrays.toString(list.toArray()));

	}

	// to find the longest word in file;
	public static void longestWordInFile(BufferedReader bufferedReader) {

		Scanner sc = new Scanner(bufferedReader);
		// System.out.println(sc.next());
		String longestWord = "";
		while (sc.hasNext()) {
			String current = sc.next();
			System.out.println(longestWord + " " + longestWord.length());
			if (current.length() > longestWord.length()) {
				longestWord = current;
			}
		}
		System.out.println("the longest word in string is-" + longestWord);
		sc.close();
	}

}