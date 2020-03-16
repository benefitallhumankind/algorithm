package baekjoon;
import java.util.Scanner;

//백준 피보나치 함수 1003
public class Dynamic_1003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[][] dp = new int[41][41]; // 0 호출 수, 1 호출 수
		dp[0][0] = dp[1][1] = 1;
		dp[0][1] = dp[1][0] = 0;
		for (int i = 2; i < dp.length; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0]; // 0 호출 수
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1]; // 1 호출 수
		}
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
		scan.close();
	}

}
