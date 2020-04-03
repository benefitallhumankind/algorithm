package baekjoon;

import java.util.Scanner;

//파도반 수열
public class DP_9461 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		long[] dp = new long[101];	//long으로 안해서 틀림
		dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i <= 100; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		for(int i=0; i<n; i++) {
			System.out.println(dp[scan.nextInt()]);
		}
	}
}
