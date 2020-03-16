package programmers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueue04 {
	public static void main(String[] args) {

		int[] priorities = { 1,1,9,1,1,1 };
		int location = 0;
		System.out.println(solution(priorities, location));

	}

	private static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Integer> order = new LinkedList<Integer>();
		for (int i : priorities) {
			order.add(i);
		}
		order: while (answer <= priorities.length) {
			int head = order.poll();
			location--;
			Iterator<Integer> it = order.iterator();
			while (it.hasNext()) {
				int next = it.next();
				if (head < next) {
					order.add(head);
					if (location < 0) {
						location = order.size() - 1;
					}
					continue order;
				}
			}
			answer++;
			if (location < 0) {
				return answer;
			}
		}
		return answer;
		/*
		 * 단순하게 문제 그대로 실행함
		 * 앞에거 뽑고 다른 중요도와 비교 후 가장 큰 숫자이면 프린트
		 */
	}
}
