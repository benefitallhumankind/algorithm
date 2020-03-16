package programmers;
import java.util.*;
public class StackQueue02 {
	public static void main(String[] args) {
		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		int answer = solution(bridge_length, weight, truck_weights);
		
		System.out.print(answer);
	}
	
	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		Queue<Integer> bridge = new LinkedList<Integer>();
		
		int truckNumber = 0;
		while( true ) {
			answer++;	//여기서는 시간(초)
			
			if( bridge.size() >= bridge_length) {	//다리 위가 꽉차면 맨 앞 트럭이 빠진다
				bridge.remove();
			}
			
			int sum = 0;	//다리 위에 있는 트럭들의 무게
			if(bridge.size()>0) {
				for( int t : bridge) {
					sum = sum + t;
				}
			}
			// 다음 출발할 트럭번호가 끝 번호보다 작고, 다리 위 무게와 다음트럭무게의 합을 다리가 견딜수 있다면 출발
			if(truckNumber < truck_weights.length && sum + truck_weights[truckNumber] <= weight) {
				bridge.add(truck_weights[truckNumber]);
				truckNumber++;
			} else {	//그렇지 않으면 출발하지 않음
				bridge.add(0);
			}
			
			// 다음 트럭번호가 끝번호와 같으면 막차가 출발했으므로 다리길이만큼 더해준다
			if(truckNumber == truck_weights.length) {
				answer += bridge_length;
				break;
			}
		}
		
		return answer;
		/*
		 * 큐 방식
		 * 트럭하나 넣고 다리위 무게 비교
		 */
	}
}
