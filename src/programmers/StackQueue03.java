package programmers;
import java.util.ArrayList;
import java.util.List;

public class StackQueue03 {
	public static void main(String[] args) {
		
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
		int[] answer = solution(progresses, speeds);
		for(int i : answer) {
			System.out.print( i +" ");
		}
	}
	
	private static int[] solution(int[] progresses, int[] speeds) {
		
		List<Integer> answerList = new ArrayList<Integer>();
		List<Integer> pro = new ArrayList<Integer>();
		List<Integer> spd = new ArrayList<Integer>();
		int count = 0;
		for( int i=0; i<progresses.length; i++) {
			pro.add(progresses[i]);
			spd.add(speeds[i]);
		}
		int i=0;
		while(true) {
			if( pro.get(i) >= 100 ) {
				count++;
				pro.set(i,0);
				spd.set(i,0);
				i++;
				if(i < progresses.length ) {
					continue;
				} else {
					answerList.add(count);
					break;
				}
			} else if ( count > 0 ){
				answerList.add(count);
				count = 0;
			}
			for(int j=0; j<pro.size(); j++) {
				pro.set( j, pro.get(j)+spd.get(j) );
			}
		}
		int[] answer = new int[answerList.size()];
		for(int j=0; j<answerList.size(); j++) {
			answer[j] = answerList.get(j);
		}
		return answer;
	}
	/*
	 * arraylist를 큐처럼 사용
	 * progresses + speeds 를 한다
	 * 100 이상인지 확인한다
	 * 다음 progress 도 100 이상인지 확인한다. 100이상이면 count를 세고 큐에서 제거한다.
	 * 100이상이 아닌 progress가 나오면 카운트를 answerList에 추가한다.
	 */
}
