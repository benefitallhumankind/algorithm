package myTest;
import java.util.Stack;

/*
 * 스택 2개로 큐 구현하기
 */
public class QueueFrom2Stack {
	public static void main(String[] args) {
		Que myQue = new Que();
		
		myQue.add(1);
		myQue.add(2);
		System.out.println(myQue.pop());
		myQue.add(3);
		myQue.add(4);
		System.out.println(myQue.pop());
		System.out.println(myQue.pop());
		
	}
	static class Que{
		Stack<Integer> inStack = new Stack<Integer>();
		Stack<Integer> outStack = new Stack<Integer>();
		
		void add(int n) {
			inStack.add(n);
		}
		int pop() {
			if(outStack.isEmpty())	//나가는 스택이 비어있을 때만 들어오는 스택에서 옮긴다.
			while(!inStack.isEmpty()) {
				outStack.add(inStack.pop());
			}
			return outStack.pop();
		}
	}
}
