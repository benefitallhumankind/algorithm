package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 3187 양치기 꿍 (BFS)
public class DfsBfs_3187 {
	static int r,c;	//전체 영역의 row, column
	static char area[][];	//전체 영역
	static boolean[][] visited;	//방문기록
	static int[] dx = {0,0,1,-1};	//x좌표 증가량
	static int[] dy = {1,-1,0,0};	//y좌표 증가량
	static Queue<Node> q = new LinkedList<>();	//검사할 좌표를 넣을 큐
	static int sheep;	//살아남은 양의 수
	static int wolf;	//살아남은 늑대의 수
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		scan.nextLine();
		visited = new boolean[r][c];
		
		//영역 생성
		area = new char[r][c];
		for(int i=0; i<r; i++) {
			String line = scan.nextLine();
			for(int j=0; j<c; j++) {
				area[i][j] = line.charAt(j);
			}
		}
		scan.close();
		
		//영역 검사
		for(int i=0; i < r; i++) {
			for (int j = 0; j < c; j++) {	//울타리거나, 방문했던곳이면 패스
				if(area[i][j] == '#' || visited[i][j]) continue;
				solve(i,j);	//아니라면 검사한다.
			}
		}
		System.out.println(sheep+" "+wolf);
	}
	
	//현재 노드와 그 노드를 둘러싼 네 방향 좌표 검사
	static void solve(int x, int y) {
		int v=0;
		int k=0;
		visited[x][y] = true;	//현재 area[x][y] 방문했으므로 true
		q.add(new Node(x,y));	//큐에 해당 좌표를 추가
		
		while(!q.isEmpty()) {	//큐가 빌 때까지
			Node cur = q.poll();	//가장 오래된 노드를 뽑는다
			if(area[cur.x][cur.y] == 'v') v++;	//뽑은 노드값이 v면 늑대,
			if(area[cur.x][cur.y] == 'k') k++;	//k면 양이며 해당 카운트를 올린다.
			
			for(int i=0; i<4; i++) {	//현재노드cur의 주변울 검사한다
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];	//(0,1),(0,-1),(1,0),(-1,0)
				
				//이 노드가 영역밖이거나 방문한적이 있거나 울타리이면 다음 노드 검사
				if(!isRange(nx,ny) || visited[nx][ny] || area[nx][ny]=='#')
					continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
		
		//울타리 안에 있는 수 계산
		if(v >= k) {
			wolf += v;
		} else {
			sheep += k;
		}
	}
	
	//좌표가 영역 범위 안인지 확인
	static boolean isRange(int x, int y) {
		if(x<0 || x>=r || y<0 || y>=c) return false;
		return true;
	}

}
class Node{
	int x, y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
