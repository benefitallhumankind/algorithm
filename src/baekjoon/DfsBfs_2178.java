package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 미로 탐색 2178
public class DfsBfs_2178 {
	static int N; //높이
	static int M; //너비
	static int[][] map;	//지도
	static boolean[][] visited;	//방문확인
	static int cnt;	//최소 칸수
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean goal;	//도착확인
	static int d;	//거리
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		visited = new boolean[N][M];
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] arr = (scan.nextLine()).toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(arr[j]);
			}
		}
		scan.close();
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();	//좌표를 넣을 bfs큐
		q.add(new Node(x,y));
		while(!q.isEmpty()) {
			Node now = q.poll();
			visited[now.y][now.x]=true;
			
			for(int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if( nx>=0 && nx<M && ny>=0 && ny<N ) {
					if(map[ny][nx]==1 && visited[ny][nx]==false) {
						q.add(new Node(nx,ny));
						visited[ny][nx] = true;
						map[ny][nx] = map[now.y][now.x]+1;
					}
				}
			}
		}
	}
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
