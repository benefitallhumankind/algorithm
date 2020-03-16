package baekjun;
import java.util.Scanner;

//백준 이친수 2193
public class Baek_Dynamic_2193 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		long[] dp = new long[n + 1];	//int 크기를 넘어간다
		dp[1] = 1;
		if (n > 1)
			dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}
}
