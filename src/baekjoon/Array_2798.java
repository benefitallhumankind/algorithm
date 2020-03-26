package baekjoon;

import java.util.Scanner;

//블랙잭
public class Array_2798 {
	static int n;
	static int m;
	static int max = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		int[] arr = new int[n];
		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		comb(arr, visit, 0, n, 3);
		System.out.println(max);
	}

	// n 배열 길이, r 조합길이
	public static void comb(int[] arr, boolean[] visit, int start, int n, int r) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visit[i] == true) {
					sum += arr[i];
				}
			}
			if (sum > max && sum <= m) {
				max = sum;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			visit[i] = true;
			comb(arr, visit, i + 1, n, r - 1);
			visit[i] = false;
		}
	}
}
