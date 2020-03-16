package baekjoon;
import java.util.Scanner;

//백준 1로만들기 1463 다이나믹 프로그래밍
// 시간초과 
public class Baek_Dynamic_1463 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		scan.close();
		int[] dp = new int[x + 1];	//0 부터 x까지 계산 (bottom-up)
		dp[0] = dp[1] = 0;	//0과 1은 0회
		for (int i = 2; i <= x; i++) {	//2부터 횟수를 계산
			dp[i] = dp[i - 1] + 1;	//-1했을 때의 횟수
			if( i%2 ==0) {	//2로 나눠떨어질 경우
				dp[i] = Math.min(dp[i], dp[i/2]+1);	//2로 나눈 값의 횟수와 -1했을 때의 횟수 비교
			}
			if( i%3 ==0) {	//3으로 나눠떨어질 경우
				dp[i] = Math.min(dp[i], dp[i/3]+1);	//3으로 나눈 값의 횟수와 -1했을 때의 횟수 비교
			}	//셋 중에 제일 작은 값이 dp[i]에 입력된다
		}
		System.out.print(dp[x]);
	}
}
