package programmers;

public class Sort02 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {121,12,21,121,12,1212}; //6210
		System.out.println(s.solution(numbers));
	}
	static class Solution {
		public String solution(int[] numbers) {
			String answer="";
			int[] a =quickSort(numbers, 0, numbers.length-1);
			for(int i : a) {
				answer+=i+" ";
			}
			if(a[0] == 0) return "0";
			return answer;
		}
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
			String n = Integer.toString(pivot);
			String m = Integer.toString(array[j]);
			String longer = m.length()>n.length()?m:n;
			for(int k=0; k < longer.length(); k++) {
				try {
					if( m.charAt(k) != n.charAt(k) ) {
						if(m.charAt(k) > n.charAt(k)) {
							i++;
							swap(array, i, j);
						} 
						break;
					}
				} catch (Exception e) {
					if(longer.equals(m) && longer.charAt(k)>=longer.charAt(k-1) || longer.equals(n) && longer.charAt(k)<longer.charAt(k-1)) {
						i++;
						swap(array, i, j);
					}
					break;
				}
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
	/*
	 * 퀵정렬 , 자릿수 비교해서 크면 앞으로
	 */
}
