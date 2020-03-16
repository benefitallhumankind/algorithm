package baekjoon;
import java.util.Scanner;

//백준 1,2,3 더하기 9095
public class Baek_Dynamic_9095 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt(); // 테스트케이스 수
		for (int i = 0; i < t; i++) {
			int x = scan.nextInt();
			int[] dp = new int[x + 1];
			dp[0] = 1;
			for (int j = 1; j <= x; j++) {
				dp[j]=dp[j-1]+(j-2<0?0:dp[j-2])+(j-3<0?0:dp[j-3]);
			}
			// dp[n] = dp[n-1] + dp[n-2] +dp[n-3];
			// 단, dp[0] = 1
			// n<0 면 dp[n] = 0
			System.out.println(dp[x]);
		}
		scan.close();
	}
}
