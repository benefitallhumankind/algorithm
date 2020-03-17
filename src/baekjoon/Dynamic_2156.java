package baekjoon;

import java.util.Scanner;

//포도주 시식
public class Dynamic_2156 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dp = new int[n + 1];
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = scan.nextInt();
		}
		dp[1] = arr[1];
		if(n>1)
			dp[2] = arr[1] + arr[2];
		for (int i = 3; i <= n; i++) {	//1개 마신경우, 연속으로 안마시는 경우, 연속으로 2개 마신경우
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
		}
		System.out.println(dp[n]);
	}
}
