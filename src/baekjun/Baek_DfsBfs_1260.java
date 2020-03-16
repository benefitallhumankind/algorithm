package baekjun;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//백준 DFS와 BFS 1260
public class Baek_DfsBfs_1260 {
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int V; // 시작할 정점번호
	static int[][] map; // 2차원배열
	static boolean[] visited; // 방문확인

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		scan.nextLine();
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			String str = scan.nextLine();
			String[] arr = str.split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			map[x][y] = map[y][x] = 1; // 연결되어있으면 1을 넣는다
		}
		scan.close();
		dfs();
		visited = new boolean[N + 1]; // bfs를 위해 방문기록 초기화
		System.out.println();
		bfs();
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>(); // bfs를 위한 큐
		q.add(V); // 시작 정점을 넣는다
		while (!q.isEmpty()) {
			int now = q.poll(); // 먼저 넣었었던 정점을 뽑는다. (dfs는 가장 최근에 넣었던 정점)
			visited[now] = true; // 방문표시해준다
			System.out.print(now + " "); // 출력한다
			for (int i = 1; i <= N; i++) { // 다음 연결된 정점을 찾는다.
				if (map[now][i] == 1 && visited[i] == false) {// 연결되어있고 방문한적 없다면
					visited[i] = true; // 방문표시해준다
					q.add(i);// 큐에 넣는다
				}
			}
		}
	}

	static void dfs() {
		boolean flag; // 연결의 끝인지 아닌지 확인하는 플래그
		Stack<Integer> s = new Stack<Integer>(); // dfs를 위한 스택 (가장 최근 정점을 뽑기위함)

		s.push(V); // 시작정점을 넣는다.
		visited[V] = true; // 방문표시해준다
		System.out.print(V + " "); // 시작 정점 출력
		while (!s.isEmpty()) {
			int now = s.peek(); // 최근에 넣은 정점을 저장
			flag = false; // 일단 최후의 정점이라고 가정한다
			for (int i = 1; i <= N; i++) { // 연결된 다음 정점이 있는지 확인
				if (map[now][i] == 1 && visited[i] == false) { // 방문한적없는 연결되있는 정점이 있다면
					s.push(i); // 스택에 추가
					System.out.print(i + " "); // 검사대상 정점 출력
					visited[i] = true;
					flag = true; // 최후의 정점이 아님 표시
					break;
				}
			}
			if (!flag) { // 최후의 정점이면 뽑는다
				s.pop();
			}
		}
	}
}
