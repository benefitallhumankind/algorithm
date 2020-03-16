package baekjun;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 유기농 배추 1012
//런타임 에러, 시간초과 - visited를 사용하는 것 대신 1을 0 으로 변경하는 방법 사용
public class Baek_DfsBfs_1012 {
	static int T; // 테스트 케이스 수
	static int M, N, K; // 가로 세로 배추
	static int worm; // 벌레 수
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		int[] wormArr = new int[T];
		for (int i = 0; i < T; i++) {
			M = scan.nextInt();
			N = scan.nextInt();
			K = scan.nextInt();
			int[][] map = new int[N][M];
			worm = 0;
			for (int j = 0; j < K; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				map[y][x] = 1;
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 0)
						continue;
					dfs(map, k, j);
					worm++;
				}
			}
			wormArr[i] = worm;
		}
		scan.close();
		for (int i : wormArr) {
			System.out.println(i);
		}
	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int[][] map, int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x, y));
		map[y][x] = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (map[ny][nx] == 0)
					continue;
				map[ny][nx] = 0;
				Node next = new Node(nx, ny);
				q.offer(next);
			}
		}
	}
}
