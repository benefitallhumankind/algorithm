package baekjoon;

import java.util.Scanner;

//정수 삼각형 1932
public class Dynamic_1932 {	// 패키지 때문에 런타임 에러
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = 0;
		int n = scan.nextInt();
		int[][] dp = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i][j] = scan.nextInt();
				if(j==1) {
					dp[i][j] += dp[i-1][j];	//맨 앞줄일 경우
				} else if( j==i) {
					dp[i][j] += dp[i-1][j-1];	//맨 뒷줄일 경우
				} else {
					dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);	//중간일 경우
				}
				if(max < dp[i][j])	//현재 max와 비교
					max = dp[i][j];
			}
		}
		scan.close();
		System.out.println(max);
	}
}
