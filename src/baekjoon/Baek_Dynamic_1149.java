package baekjoon;
import java.util.Scanner;

//백준 RGB거리 1149
public class Baek_Dynamic_1149 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt(); // 집 수
		int[][] arr = new int[t + 1][3];
		int[][] dp = new int[t + 1][3];
		for (int i = 1; i <= t; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
			arr[i][2] = scan.nextInt();
		}
		scan.close();
		dp[0][0] = dp[0][1] = dp[0][2] = arr[0][0] = arr[0][1] = arr[0][2] = 0;
		for (int i = 1; i <= t; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(dp[t][0],dp[t][1]),dp[t][2]));
	}
}
