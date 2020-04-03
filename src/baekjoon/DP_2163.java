package baekjoon;

import java.util.Scanner;

//초콜릿 자르기
public class DP_2163 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
//		System.out.println(n*m - 1);	//규칙으로 풀은 방법
		
		int[] dp = new int[301];
		dp[1] = n-1;
		for(int i=2; i<=m; i++) {
			dp[i] = dp[i-1] + n;
		}
		System.out.println(dp[m]);
	}
}
