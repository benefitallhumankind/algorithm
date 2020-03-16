package baekjun;
import java.util.PriorityQueue;
import java.util.Scanner;

//백준 단지번호 붙이기 2667

public class Baek_DfsBfs_2667 {
	static int[][] map;	//지도
	static boolean[][] visited;	//방문체크 배열
	static int[] dx = {1,-1,0,0};	//x좌표 변화량
	static int[] dy = {0,0,1,-1};	//y좌표 변화량
	static PriorityQueue<Integer> apts = new PriorityQueue<Integer>();	//단지내 집의 수 오름차순 큐
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();	//가로세로 사이즈
		scan.nextLine();
		visited = new boolean[size][size];
		map = new int[size][size];
		for(int i=0; i<size; i++) {
			char[] arr = (scan.nextLine()).toCharArray();
			for(int j=0; j<arr.length; j++) {
				map[i][j] = Character.getNumericValue(arr[j]);
			}
		}
		scan.close();
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(visited[i][j] == true || map[i][j] == 0)
					continue;
				int h = dfs(i,j,1);	//0,1,0
				apts.add(h);
			}
		}
		System.out.println(apts.size());
		while(!apts.isEmpty()) {
			System.out.println(apts.poll());
		}
	}
	
	static int dfs(int x, int y, int h) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];	//1
			int ny = y + dy[i];	//1
			if( nx>=0 && nx<map.length && ny>=0 && ny<map.length) {
				if(map[nx][ny] != 0 && visited[nx][ny] != true) {
					h++;	//2
					h = dfs(nx,ny,h);
				}
			}
		}
		return h;
	}
}
