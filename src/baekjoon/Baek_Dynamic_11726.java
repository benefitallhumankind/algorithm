package baekjoon;
import java.util.Scanner;

//백준 2xn 타일링 11726
public class Baek_Dynamic_11726 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		//계산해보니 피보나치 수열
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 2;
		for(int i=2; i<n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;	//stack overflow를 막기위해 미리 연산
		}
		System.out.println(dp[n-1]);
	}
}
