package baekjoon;
import java.util.Scanner;

//백준 6603 로또
public class Baek_DfsBfs_6603 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int k;	//배열 수
		do {
			k = scan.nextInt();
			int[] arr = new int[k];	//배열 생성
			boolean[] visited = new boolean[k];	//방문 체크
			for(int i=0; i<k; i++) {
				arr[i] = scan.nextInt();
			}
			combination(arr, visited, 0, k, 6);	//조합메소드
		} while (k!=0);
		scan.close();
	}
	
	//조합
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			//출력
			for(int i=0; i<n; i++) {
				if(visited[i]==true)
					System.out.print(arr[i]+" ");
			}
			System.out.println();
		} else {
			for(int i=start; i<n; i++) {
				visited[i] = true;
				combination(arr, visited, i+1, n, r-1);
				visited[i] = false;
			}
		}
	}

}
