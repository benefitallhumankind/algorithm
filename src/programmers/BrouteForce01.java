package programmers;
import java.util.Stack;

public class BrouteForce01 {
	public static void main(String[] args) {
		int[] answers = { 1,2,3,4,5 };

		int[] answer = solution(answers);
		for(int i : answer) {
			System.out.print(i+" ");
		}
	}

	static int[] solution(int[] answers) {
		int[] scores = {getScore1(answers), getScore2(answers), getScore3(answers)};
		System.out.println( scores[0]+" "+ scores[1]+" "+ scores[2]);
		Stack<Integer> st = new Stack<Integer>();
		st.add(0);
		for(int i=1; i<scores.length; i++) {
			if( scores[st.peek()] < scores[i] ) {
				st.pop();
				st.push(i);
			} else if( scores[st.peek()] == scores[i]) {
				st.push(i);
			}
		}
		int[] answer = new int[st.size()];
		for(int i=st.size()-1; i>=0 ; i--) {
			answer[i]= st.pop()+1;
		}
		return answer;
	}

	static int getScore1(int[] answers) {
		int count = 0;
		for (int i = 0; i < answers.length; i++) {
			int answer = (i % 5 + 1 != 0 ? i % 5 + 1 : 5);
			if (answers[i] == answer) {
				count++;
			}
		}
		return count;
	}

	static int getScore2(int[] answers) {
		int count = 0;
		for (int i = 0; i < answers.length; i++) {
			int answer;
			if (i % 2 == 0) {
				answer = 2;
			} else { // 1,3,4,5,1,3,4,5
				switch ((i + 1) % 8) {
				case 2:
					answer = 1;
					break;
				case 4:
					answer = 3;
					break;
				case 6:
					answer = 4;
					break;
				case 0:
					answer = 5;
					break;
				default:
					answer = -1;
					break;
				}
			}
			if (answers[i] == answer) {
				count++;
			}
		}
		return count;
	}

	static int getScore3(int[] answers) {
		int count = 0;
		for (int i = 0; i < answers.length; i++) {
			int answer;
			switch (i % 10) {
			case 0:
			case 1:
				answer = 3;
				break;
			case 2:
			case 3:
				answer = 1;
				break;
			case 4:
			case 5:
				answer = 2;
				break;
			case 6:
			case 7:
				answer = 4;
				break;
			case 8:
			case 9:
				answer = 5;
				break;
			default:
				answer = -1;
				break;
			}
			if (answers[i] == answer) {
				count++;
			}
		}
		return count;
	}
}
