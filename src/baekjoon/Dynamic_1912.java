package baekjoon;

import java.util.Scanner;

//연속합
public class Dynamic_1912 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dp = new int[n + 1]; // 합을 쌓아나간다
		int max = dp[1] = scan.nextInt();
		for (int i = 2; i <= n; i++) {
			dp[i] = scan.nextInt();	//추가할 값
			if (dp[i - 1] > 0 && dp[i] + dp[i - 1] > 0) {	//이전 값 합이 음수가 아니고, 현재값을 더해도 음수가 아닐때
				dp[i] += dp[i-1];
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
