package programmers;

public class DfsBfs01 {

	public static void main(String[] args) {
		int[] numbers = {1,2,3};
		int target = 3;
		solution(numbers, target);
	}
	
	static int solution(int[] numbers, int target) {
		int answer =0;
		int size = numbers.length;
		//이진트리 만들기
		int[] tree = new int[(int)(Math.pow(2, size+1))+1];
		for(int i=1; i<tree.length; i++) {
			int q = i-1;	//현재 index를 2의 제곱수로 나눈 몫 : depth
			int ss = 0;	//super script : 윗첨자
			while(q!=0) {
				ss++;
				q = q/2;
				System.out.println("ss : "+ss);
			}
			int r = i%((int)Math.pow(2, ss));
			int n = numbers[ss];
			if(r%2==0) {
				n = n*(-1);
			}
			tree[i] = n;
		}
		for(int i : tree) {
			System.out.print(i+" ");
		}
		return answer;
	}

}
