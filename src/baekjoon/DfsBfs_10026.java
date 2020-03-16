package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 10026 적록 색약 (BFS)
public class DfsBfs_10026 {
	static int N;	//가로세로
	static char pic[][];	//전체 영역
	static boolean[][] visited;	//방문기록
	static boolean[][] visited2;	//방문기록
	static int[] dx = {0,0,1,-1};	//x좌표 증가량
	static int[] dy = {1,-1,0,0};	//y좌표 증가량
	static Queue<Node> q = new LinkedList<>();	//검사할 좌표를 넣을 큐
	static int area1;	//일반인 총 구역 수
	static int area2;	//색약 총 구역 수
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		scan.nextLine();
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		//영역 생성
		pic = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = scan.nextLine();
			for(int j=0; j<N; j++) {
				pic[i][j] = line.charAt(j);
			}
		}
		scan.close();
		
		//영역 검사
		for(int i=0; i < N; i++) {
			for (int j = 0; j < N; j++) {	//방문했던곳이면 패스
				if(visited[i][j]) continue;
				solve(i,j);	//아니라면 검사한다.
			}
		}
		// 색약 영역 검사
		for(int i=0; i < N; i++) {
			for (int j = 0; j < N; j++) {	//방문했던곳이면 패스
				if(visited2[i][j]) continue;
				solve2(i,j);	//아니라면 검사한다.
			}
		}
		System.out.println("일반 : "+area1+", 색약 : "+area2);
	}
	
	//현재 노드와 그 노드를 둘러싼 네 방향 좌표 검사
	static void solve(int x, int y) {
		visited[x][y] = true;	//현재 pic[x][y] 방문했으므로 true
		q.add(new Node(x,y));	//큐에 해당 좌표를 추가
		while(!q.isEmpty()) {	//큐가 빌 때까지
			Node cur = q.poll();	//가장 오래된 노드를 뽑는다
			char standard = pic[cur.x][cur.y];	//비교할 기준 색			
			for(int i=0; i<4; i++) {	//현재노드cur의 주변울 검사한다
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];	//(0,1),(0,-1),(1,0),(-1,0)
				
				//이 노드가 영역밖이거나 방문한적이 있거나 다른색이면 다음 노드 검사
				if(!isRange(nx,ny) || visited[nx][ny] || pic[nx][ny]!=standard)
					continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
		area1++;
	}
	
	//색약자 좌표 검사
	static void solve2(int x, int y) {
		visited2[x][y] = true;	//현재 pic[x][y] 방문했으므로 true
		q.add(new Node(x,y));	//큐에 해당 좌표를 추가
		while(!q.isEmpty()) {	//큐가 빌 때까지
			Node cur = q.poll();	//가장 오래된 노드를 뽑는다
			char standard = pic[cur.x][cur.y];	//비교할 기준 색			
			for(int i=0; i<4; i++) {	//현재노드cur의 주변울 검사한다
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];	//(0,1),(0,-1),(1,0),(-1,0)
				
				//이 노드가 영역밖이거나 방문한적이 있으면 패스
				if(!isRange(nx,ny) || visited2[nx][ny])
					continue;
				//기준색과 다르고
				if(pic[nx][ny]!=standard) {
					//둘중에 하나가 B이면 패스
					if(standard=='B' || pic[nx][ny]=='B') {
						continue;
					}
				}
				visited2[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
		area2++;
	}
	
	//좌표가 영역 범위 안인지 확인
	static boolean isRange(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}

	static class Node{
		int x, y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
