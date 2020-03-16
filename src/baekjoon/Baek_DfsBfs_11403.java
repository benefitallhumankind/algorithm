package baekjoon;
import java.util.Scanner;

//백준 경로찾기 11403
public class Baek_DfsBfs_11403 {
	static int N;	//정점의 개수
	static int[][] arr;	//주어진결과 배열에 결과를 덮어쓴다
	static boolean[] visited;	//해당 행을 방문했는지 확인
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
		
		for(int i=0; i<N; i++){
			visited = new boolean[N];	//방문여부 초기화
			dfs(i);	//현재 행에 대해 dfs검사
			for(int j=0; j<N; j++) {
				if(visited[j]) {	//현재 행 검사하면서 방문체크된 숫자열을 1로 변경
					arr[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int i) {	//i행 검사
		for(int j=0; j<N; j++) {	//i행의 j열
			if(arr[i][j]==1 && !visited[j]) {	//1이고 방문한적 없다면
				visited[j] = true;	//방문체크 후
				dfs(j);	//j행 검사
			}
		}
	}
}
