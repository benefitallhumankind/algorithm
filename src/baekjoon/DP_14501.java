package baekjoon;

import java.util.Scanner;

//퇴사
public class DP_14501 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 1<=n<=15
		int[] dp = new int[n + 1];
		int[] t = new int[n + 1];
		int[] p = new int[n + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			t[i] = scan.nextInt();
			p[i] = scan.nextInt();
			dp[i] = p[i];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (i - j >= t[j]) {
					dp[i] = Math.max(p[i] + dp[j], dp[i]);
				}
			}
			if (i + t[i] <= n + 1 && max < dp[i]) {
				max = dp[i];
			}
		}
		scan.close();
		System.out.println(max);
	}
}