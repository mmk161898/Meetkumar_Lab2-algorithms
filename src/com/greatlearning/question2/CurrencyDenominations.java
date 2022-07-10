package com.greatlearning.question2;

import java.util.Scanner;

public class CurrencyDenominations {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations : ");
		int size = scan.nextInt();

		int[] arr = new int[size];
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println("Enter the amount you want to pay : ");
		int amount = scan.nextInt();
		mergeSort(arr, 0, size - 1);

		paymentApproach(arr, amount);

		scan.close();
	}

	private static void paymentApproach(int[] arr, int amount) {
		
		//below commented approach will work only when denominations are in such a way that any amount can be paid.
		
		/*int notes = 0;
		int i = 0;
		System.out.println("Your payment approach in order to give min no of notes will be : ");
		while (amount != 0) {
			if (arr[i] != 0) {
				if (amount >= arr[i]) {
					notes += 1;
					amount -= arr[i];
				} else {
					if (notes != 0) {
						System.out.println(String.format("%d:%d", arr[i], notes));
						notes = 0;
					}
					i++;
				}
			}
		}
		System.out.println(String.format("%d:%d", arr[i], notes)); */

		int[] notesCount = new int[arr.length];
		try {
			
			for(int i = 0; i<arr.length; i++) {
				if(amount >= arr[i]) {
					notesCount[i] = amount/arr[i];
					amount -= notesCount[i]*arr[i];
				}
			}
			if(amount>0) {
				System.out.println("The exact amount can not be given with highest denominations.");
			}else {
				System.out.println("Your payment approach in order to give min no of notes will be : ");
				for(int i = 0; i<arr.length; i++) {
					if(notesCount[i] != 0) {
						System.out.println(String.format("%d:%d", arr[i], notesCount[i]));
					}
				}
			}
			
		}catch(Exception e) {
			System.out.println("Please enter currency denomination except 0.");
		}
	}

	private static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			mergeConquer(arr, left, mid, right);
		}

	}

	private static void mergeConquer(int[] arr, int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = left;

		while (i < n1 && j < n2) {
			if (leftArr[i] > rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
				k++;
			} else {
				arr[k] = rightArr[j];
				j++;
				k++;
			}
		}

		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

}
