package baekjoon;

import java.util.Scanner;

//2xn 타일링2
public class DP_11727 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] dp = new long[1001];
		dp[0] = dp[1] = 1;
		/*
		 * i-1에서 1x2타일 하나 붙이는 경우 + i-2에서 2x2타일 하나, 2x1타일 두개 붙이는 경우
		 */
		for(int i=2; i<=n;i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
		System.out.println(dp[n]%10007);
	}
}
