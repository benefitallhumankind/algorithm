package baekjun;
import java.util.Scanner;

//백준 계단오르기 2579
public class Baek_Dynamic_2579 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];	// n번째 계단값
		int[] dp = new int[n];	// n번째 계단에서의 최대 합
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		dp[0] = arr[0];	//첫번째 계단 밟을 경우 합
		dp[1] = arr[0] + arr[1];	//두번째 계단 밟을 경우 합
		dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);	//세번째 계단을 밟을 경우 합
		for (int i=3; i < n; i++) {
			dp[i] = Math.max((dp[i-3] + arr[i-1] + arr[i]),(dp[i-2] + arr[i]));
		}
		System.out.println(dp[n-1]);
	}
}
