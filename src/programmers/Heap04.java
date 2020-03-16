package programmers;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap04 {
	public static void main(String[] args) {
		String[] operations = {"I 7", "I 5","I -5","D -1"};
		
		int[] answer = solution(operations);
		for(int i : answer) {
			System.out.print(i +" ");
		}
	}
	static int[] solution(String[] operations) {
		int[] answer = {0,0};
		
		PriorityQueue<Integer> maxQue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> minQue = new PriorityQueue<Integer>();
		
		for(String str: operations) {
			String[] splited = str.split(" ");
			if(splited[0].equals("I")) {
				maxQue.add(Integer.parseInt(splited[1]));
				minQue.add(Integer.parseInt(splited[1]));
			}
			
			if(splited[0].equals("D")) {
				if(!minQue.isEmpty()) {
					if(splited[1].equals("1")) {
						int max = maxQue.peek();
						minQue.remove(max);
						maxQue.remove(max);
					}else {
						int min = minQue.peek();
						minQue.remove(min);
						maxQue.remove(min);
					}
				}
			}
		}
		if(!minQue.isEmpty()) {
			answer[0] = maxQue.peek();
			answer[1] = minQue.peek();
		}
		return answer;
	}
}	
