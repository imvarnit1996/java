package com.varnit.questions;

//For a newly opened hospital, opened on 1st, you have data of entry and exit date of 
//patients between date 1st to 10th. You have 
//to find the date on which there are most number of patients in the hospital.
//For example, you have array of entry and 
//exit date of patients(entry, exit) like [(1,3),(2,5),(4,8),(9,10),(5,6),(4,7),(7,10)] 
//then your output will be date 5 as this date has 4 number of patients.

public class Question2 {
	private int entry_date;
	private int exit_date;

	public Question2(int[] date) {
		this.entry_date = date[0];
		this.exit_date = date[1];
	}

	// public int maximum_patients_date() {
	// for (int i = this.entry_date; i < this.exit_date; i++) {
	//
	// }
	// }

	public static void main(String[] args) {
		int[][] entry_exit_dates = { { 1, 3 }, { 2, 5 }, { 4, 8 }, { 9, 10 }, { 5, 6 }, { 4, 7 }, { 7, 10 } };
		for (int[] date : entry_exit_dates) {
			Question2 q2_object = new Question2(date);
		}
	}
}
