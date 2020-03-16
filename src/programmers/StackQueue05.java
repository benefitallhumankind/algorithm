package programmers;
import java.util.Stack;

public class StackQueue05 {
	public static void main(String[] args) {

		String arrangement0 = "()(((()())(())()))(())";
		String arrangement1 = "(())";
		String arrangement2 = "(()())";
		String arrangement3 = "((())())";

		System.out.println(solution(arrangement2));
	}

	private static int solution(String arrangement) {
		int answer = 0;
		
		char prev = 0;
		Stack<Character> pipe = new Stack<Character>();
		for( char c : arrangement.toCharArray() ) {
			//40, 41
			if(c==40) {
				pipe.push(c);
				answer++;
			} else {
				pipe.pop();
				if(prev==40) {
					answer--;
					answer += pipe.size();
				}
			}
			prev = c;
		}
		return answer;
	}
}
/*
 * ( 일경우 추가해주고 )일 경우 앞이 ( 이면 size를 더해주고 아니면 +1;
 */