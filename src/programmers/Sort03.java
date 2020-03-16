package programmers;

public class Sort03 {
	public static void main(String[] args) {
		int[] c = {2,3,5,5,5};	//2,3,5,5,5
		System.out.println("The answer is "+solution(c));
	}
	
	static int solution(int[] citations) {
		int answer=0;
		int[] a = quickSort(citations,0,citations.length-1);
		for(int i=0; i<a.length;i++) {
			int n = a[i];
			for(int j= i-1<0?1:a[i-1] ;j<=n;j++) {
				if(a.length-i == j) {
					answer= j;
				}
			}
		}
		return answer;
		/*
		 * 퀵 정렬 후
		 * 논문 개수 증가시키며 남은 원소 수와 비교해서 같으면 answer에 추가
		 */
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
