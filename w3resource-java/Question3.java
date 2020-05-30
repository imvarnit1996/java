// On election day, a voting machine writes data in the form (voter_id, candidate_id).
// Write a program that takes data as array of (voter_id, candidate_id) and
// returns the top 3 candidates at any given time. If you find a voter voting
// more than once, report this as fraud and dont count this voter's any vote and
// print these voters id as fraud candidates.
// Example: For data:
// [(1,2), (2,3),(3,2), (1,3), (4,3), (5,3),(6,2), (7,3), (8,2), (9,3),(10,1), (11,4), (12,4)] ,
//  output should be,
// Top Three candidate ids: 3, 2, 4
// Fraud voter ids: 1

//package com.varnit.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Question3 {

	public static void main(String[] args) {
		int[][] arr_of_voting = { { 1, 2 }, { 2, 3 }, { 3, 2 }, { 4, 3 }, { 5, 3 }, { 6, 2 }, { 7, 3 }, { 8, 2 },
				{ 9, 3 }, { 10, 1 }, { 11, 4 }, { 12, 4 } };

		winningCandidate(arr_of_voting);

	}

	public static HashSet<Integer> nonFraudlentVoter(int[][] arr_of_voting) {
		HashSet<Integer> hs = new HashSet<>();
		System.out.println("fraudlent voter: ");
		for (int i = 0; i < arr_of_voting.length; i++) {
			if (hs.contains(arr_of_voting[i][0])) {
				System.out.print(arr_of_voting[i][0] + ", ");
				hs.remove(arr_of_voting[i][0]);
			} else {
				hs.add(arr_of_voting[i][0]);
			}
		}
		System.out.println();
		System.out.println("-----------");
		return hs;

	}

	public static void winningCandidate(int[][] arr_of_voting) {
		HashSet<Integer> non_fraudlent_voters = nonFraudlentVoter(arr_of_voting);

		if (non_fraudlent_voters.size() == arr_of_voting.length) {
			System.out.println("There are no fraudlents in voters list ");
			System.out.println("-----------");
		}
		if (non_fraudlent_voters.isEmpty()) {
			System.out.println("all voters are fraudlents");
			System.exit(1);
		}

		HashMap<Integer, Integer> candidates = new HashMap<>(3);
		int value = 1;
		for (int i = 0; i < arr_of_voting.length; i++) {

			if (non_fraudlent_voters.contains(arr_of_voting[i][0])) {
				if (candidates.containsKey(arr_of_voting[i][1])) {
					value = candidates.get(arr_of_voting[i][1]);
					value += 1;
				}
			} else {
				continue;
			}
			candidates.put(arr_of_voting[i][1], value);
			value = 1;
		}

		int[] candiate_array = new int[candidates.size()];
		int i = 0;
		for (Entry<Integer, Integer> entry : candidates.entrySet()) {
			System.out.println("candidate: " + entry.getKey() + " " + "votes: " + entry.getValue());
			candiate_array[i] = entry.getValue();
			i++;
		}
	}
}
