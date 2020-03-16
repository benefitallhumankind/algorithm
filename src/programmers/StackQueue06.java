package programmers;
import java.util.ArrayList;

public class StackQueue06 {
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		int[] answer = solution(prices);
		for(int i : answer) {
			System.out.print(i +" ");
		}
	}
	
	private static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		ArrayList<Integer> pri = new ArrayList<Integer>();
		
		for(int i : prices) {
			pri.add(i);
		}
		
		for(int i=0; i<pri.size(); i++) {
			for(int j=i+1; j<pri.size(); j++) {
				if(pri.get(i) > pri.get(j)) {
					answer[i] = j-i;
					break;
				}
				if(j==pri.size()-1) {
					answer[i] = pri.size()-1-i;
				}
			}
		}
		return answer;
	}
	/*
	 * ArrayList로 크기비교 확인해서 index 계산
	 */
}
