package baekjoon;
import java.util.PriorityQueue;
import java.util.Scanner;

//백준 카드정렬하기 1715
public class Baek_Heap_1715 {

	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0; i<n; i++) {
			heap.add(scan.nextInt());
		}
		scan.close();
		int total=0;
		int sum = heap.poll();
		while(!heap.isEmpty()) {
			heap.add(sum);
			int x = heap.poll();
			int y = heap.poll();
			sum = x + y;
			total += sum;
		}
		System.out.println(total);
	}

}
