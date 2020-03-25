package baekjoon;

import java.util.Scanner;

//다리놓기
public class Dynamic_1010 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[][] dp = new int[31][31];
		for (int i = 1; i < 31; i++) {
			for (int j = 1; j < 31; j++) {
				if (i == 1) {
					dp[i][j] = j;
				} else if (i == j) {
					dp[i][j] = 1;
				} else {
					for (int k = j - 1; k >= i - 1; k--) {
						dp[i][j] += dp[i - 1][k];
					}
				}

			}
		}
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			System.out.println(dp[n][m]);
		}
	}

}
