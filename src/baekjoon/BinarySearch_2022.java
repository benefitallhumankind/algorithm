package baekjoon;
import java.util.Scanner;

//백준 2022 사다리
public class BinarySearch_2022 {
	static double x;
	static double y;
	static double c;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		x = scan.nextDouble();
		y = scan.nextDouble();
		c = scan.nextDouble();
		scan.close();
		
		if(x<y) {
			double temp = x;
			x = y;
			y = temp;
		}
		
		double low = 0;
		double high = y;	//d는 x와 y보다 작을 수 밖에 없으므로 커봤자 y밑
		
		while(true) {
			double d = (low+high)/2;
			double myC = getC(d);
			if(Math.abs(myC - c) <= 0.001) {	//오차가 0.001 이하일 경우
				System.out.println(d);
				break;
			}
			if(myC > c) {
				low = d;
			} else {
				high = d;
			}
		}
	}
	static double getC(double d) {
		double a = Math.sqrt(x*x - d*d);
		double b = Math.sqrt(y*y - d*d);
		return (a*b)/(a+b);
	}

}
