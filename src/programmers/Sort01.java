package programmers;

public class Sort01 {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		for(int i : solution(array,commands)) {
			System.out.print(i+" ");
		}
	}
	
	static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length;i++) {
			int startIdx = commands[i][0]-1;
			int endIdx = commands[i][1]-1;
			int selectIdx = commands[i][2]-1;
			int[] part = new int[endIdx - startIdx +1];
			for(int j=0; j<part.length ; j++) {
				part[j] = array[j+startIdx];
			}
			quickSort(part,0,part.length-1);
			answer[i] = part[selectIdx];
		}
		
		return answer;
	}
	
	//퀵정렬
	static int[] quickSort(int[] array, int l, int r) {
		if(l < r) {
			int p = partition(array,l,r);
			quickSort(array,l,p-1);
			quickSort(array,p+1,r);
		}
		return array;
	}
	static int partition(int[] array, int l, int r) {
		int pivot = array[r];
		int i = l-1;
		for(int j=l; j<r; j++) {
			if(array[j]<=pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array,i+1,r);
		return i+1;
	}
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
