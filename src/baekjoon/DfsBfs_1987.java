package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

//알파벳	//틀림
public class DfsBfs_1987 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int r;
	static int c;
	static char[][] area;
	static int[][] visit;
	static ArrayList<Character> arr;
	static int max = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		scan.nextLine();
		area = new char[r][c];
		visit = new int[r][c];
		arr = new ArrayList<Character>();
		for (int i = 0; i < r; i++) { // area생성
			String str = scan.nextLine();
			for (int j = 0; j < c; j++) {
				area[i][j] = str.charAt(j);
			}
		}
		scan.close();
		dfs(0, 0, 0, arr);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt, ArrayList<Character> arr) {
		visit[x][y] = cnt++;
		if (cnt > max) {
			max = cnt;
		}
		arr.add(area[x][y]);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
				if (visit[nx][ny] == 0 && !arr.contains(area[nx][ny])) {
					dfs(nx, ny, cnt, arr);
				}
			}
		}
		visit[x][y] = 0;	//초기화해줘야함
		arr.remove(arr.size()-1);	//백트레킹해줘야함
	}
}
