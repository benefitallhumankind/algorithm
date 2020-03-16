package programmers;
import java.util.HashSet;
//소수찾기
public class BrouteForce02 {
	
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println("answer : "+solution(numbers));
	}
	
	static int solution(String numbers) {
		HashSet<Integer> nSet = new HashSet<Integer>(); //조합 가능한 숫자리스트
		int answer=0;
		int n = numbers.length();
		char[] arr = new char[n];
		for( int i=0; i<n; i++ ) {
			char num = numbers.charAt(i);
			arr[i]=num;
		}
		for(int i=1; i<=n; i++) {
			permutation(nSet,arr, 0, n, i);
		}
		for(int num : nSet) {
			if(isPrime(num)) {
				answer++;
			}
		}
		return answer;
	}
	
	//순열
	static void permutation(HashSet<Integer> nSet, char[] arr, int depth, int n, int r) {
		if(depth == r) {
			addSet(nSet, arr, r);
			return;
		}
		for(int i=depth;i<n; i++) {
			swap(arr, depth, i);
			permutation(nSet, arr, depth+1, n, r);
			swap(arr, depth, i);
		}
	}
	//Set에 완성된 숫자 넣기
	static void addSet(HashSet<Integer> nSet, char[] arr, int r) {
		String num = "";
		for(int i=0; i<r; i++) {
			num += arr[i];
		}
		System.out.println(Integer.valueOf(num));
		nSet.add(Integer.valueOf(num));
	}
	
	//소수인지 판별
	static boolean isPrime(int num){
		if(num==1 || num==0) return false;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	static void swap(char[] arr, int depth, int i) {
		char temp = arr[depth];
		arr[depth]= arr[i];
		arr[i] = temp;
	}
}
