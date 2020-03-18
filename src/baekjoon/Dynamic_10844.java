package baekjoon;

import java.util.Scanner;

//쉬운 계단 수

public class Dynamic_10844 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[][] dp = new long[101][11];	//[n자리][끝숫자]
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		/*
		 * 끝자리가 0 -> dp[n][0] = dp[n-1][1]
		 * 끝자리가 9 -> dp[n][9] = dp[n-1][8]
		 * 나머지 -> dp[n][x] = dp[n-1][x-1] + dp[n-1][x+1]
		 */
		for(int i=2; i<=n; i++) {
			dp[i][0] = dp[i-1][1];	//끝자리가 0일경우 -> 전자릿수 마지막이 1인 경우와 같음
			for(int j=1; j<=9; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) %1000000000;	//dp[n][10] = 0
			}
		}
		long sum=0;
		for(int i=0; i<10; i++) {
			sum+= dp[n][i];
		}
		System.out.println(sum%1000000000);
	}
}
