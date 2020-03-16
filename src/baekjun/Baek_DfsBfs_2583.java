package baekjun;
import java.util.PriorityQueue;
import java.util.Scanner;

//백준 영역구하기 2583
public class Baek_DfsBfs_2583 {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static PriorityQueue<Integer> area = new PriorityQueue<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		K = scan.nextInt();
		scan.nextLine();
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			String p = scan.nextLine();
			String[] pArr = p.split(" ");
			int x1 = Integer.parseInt(pArr[0]);
			int y1 = Integer.parseInt(pArr[1]);
			int x2 = Integer.parseInt(pArr[2]);
			int y2 = Integer.parseInt(pArr[3]);
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[k][j] = 1;
				}
			}
		}
		scan.close();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[j][i] != true && map[j][i] != 1) {
					area.add(dfs(i, j, 0));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		while(!area.isEmpty()) {
			System.out.print(area.poll()+" ");
		}
	}

	static int dfs(int x, int y, int v) {
		visited[y][x] = true;
		v++;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = x+dy[i];
			if(nx >= 0 && nx < N && ny>= 0 && ny < M) {
				if(map[ny][nx] != 1 && visited[ny][nx]==false) {
					v = dfs(nx,ny,v);
				}
			}
		}
		return v;
	}
}
