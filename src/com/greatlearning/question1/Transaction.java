package com.greatlearning.question1;

import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the size of transaction array : ");
		int size = scan.nextInt();
		int[] arr = new int[size];

		System.out.println("Enter the values of an array : ");

		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println("Enter the total number of targets needs to be achieved : ");
		int totalTargets = scan.nextInt();

		for (int i = 1; i <= totalTargets; i++) {
			System.out.println("Enter the value of target : ");
			long target = scan.nextInt();
			isTargetAchieved(arr, target);
		}
		scan.close();
	}

	private static void isTargetAchieved(int[] arr, long target) {

		long sum = 0;
		boolean status = false;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (target <= sum) {
				System.out.println(String.format("Target achieved after %d transactions.", (i + 1)));
				status = true;
				break;
			}
		}
		if (!status) {
			System.out.println("Given target is not achieved.");
		}
	}

}
