package programmers;

public class StackQueue01 {
	public static void main(String[] args) {
		
		int[] heights = {3,1};
		
		int[] answer = solution(heights);
		
		for(int i = 0; i<answer.length; i++) {
			
			System.out.print(answer[i]+" ");
		}
	}
	
	private static int[] solution(int[] heights) {

		int[] answer = new int[heights.length];
		for(int i=1; i<heights.length; i++) {
			for(int j=i-1; j>=0; j--) {
				System.out.println(heights[i] +" / "+ heights[j]);
				if( heights[i] < heights[j] ) {
					answer[i] = j+1;
					break;
				}
			}
		}
		return answer;
		/*
		 * 스택/큐와 무슨 상관인지 잘 모르겠다.
		 * 첫번째 탑은 무조건 0 이다.
		 * 두번째 탑부터 자신의 앞타워들과 크기 비교를 한다.
		 * 자신보다 큰 타워가 나타나면 배열에 표시하고 현재 for문을 빠져나간다.
		 */
	}
}
