package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 10451 순열 사이클
public class DfsBfs_10451 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int tc = scan.nextInt();	//테스트 케이스 수 입력받음
		int[] answers = new int[tc];	//테스트케이스 수와 같은 크기의 배열 생성
		for(int i=0; i<tc; i++) {
			int num = scan.nextInt();
			int[] arr = new int[num+1];
			for(int j=1; j<arr.length; j++) {
				arr[j] = scan.nextInt();
			}
			answers[i] = countCycle(arr);	//순열 사이클 구하는 메소드
		}
		scan.close();
		for(int i: answers) {
			System.out.println(i);
		}
	}
	
	//배열을 받아서 순열 사이클 수를 구한다
	static int countCycle(int[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[arr.length];	//중복 방문 체크
		int cycles=0;	// 처음 사이클 수 = 0
		for(int i=1; i<arr.length; i++) {	//편의상 idx 1 부터 시작
			if(visited[i]==true) {	//방문한적 있다면 이미 사이클 수에 포함되었으므로 건너뛴다
				continue;
			}
			visited[i] = true;	//방문 체크해주고
			q.add(arr[i]);	//큐에 추가한다
			while(!q.isEmpty()) {	//큐가 빌 때 까지 (비었다면 한 싸이클이 끝난것)
				int val = q.poll();
				if( visited[val] ==true ) {	//이미 방문한적 있다면 사이클의 시작점임
					cycles++;
					break;
				} else {
					q.add(arr[val]);
					visited[val] = true;
				}
			}
		}
		return cycles;
	}
}
