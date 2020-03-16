package baekjoon;
import java.util.Scanner;

//백준 1920 수 찾기
public class Baek_binarySearch_1920 {
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		quickSort(arr,0,n-1);
		
		int m = scan.nextInt();
		for(int i=0; i<m; i++) {
			int x = scan.nextInt();
			System.out.println( bs(0, n-1, x) );
		}
	}
	//이진탐색
	static int bs(int low, int high, int target) {
		if(low>high) {
			return 0;
		} else {
			int mid = (low+high)/2;
			if(arr[mid] == target) {
				return 1;
			} else if(arr[mid] > target) {
				return bs(low, mid-1, target);
			} else {
				return bs(mid+1, high, target);
			}
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
