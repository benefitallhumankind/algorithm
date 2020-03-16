package programmers;
import java.util.Arrays;

public class Heap01 {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		
		System.out.println("결과 : "+solution(scoville, K));
	}
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		Arrays.sort(scoville);
		
		while(scoville[0]<K) {
			if(scoville.length<2) {
				return -1;
			}
			answer++;
			int newNum = scoville[0]+(scoville[1]*2);
			int[] scoville2 = new int[scoville.length-1];
			for(int i=1; i<scoville2.length; i++) {
				scoville2[i] = scoville[i+1];
			}
			scoville2[0] = newNum;
			Arrays.sort(scoville2);
			scoville = scoville2;
		}
		
		return answer;
	}
	//arrays.sort 이용
	/*
	 * sort 후 첫번째 숫자와 k비교
	 * 작으면 합친 값으로 새 배열 만들고 sort
	 * 반복
	 */
}
