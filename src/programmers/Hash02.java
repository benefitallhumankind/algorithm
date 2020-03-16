package programmers;
import java.util.*;

// 프로그래머스 연습
public class Hash02 {
	public static void main(String[] args) {
		
		String[] phone_book = {"119","123","1235","567","88"};
		
		System.out.println( solution1(phone_book) );
		
	}
	public static boolean solution1(String[] phone_book) {
		boolean answer = true;
		HashSet<String> numSet = new HashSet<String>();
		for(String str : phone_book) {
			numSet.add(str);
		}
		for (String str : numSet) {
			for(String str2 : numSet) {
				if(str == str2) {
					continue;
				}
				if(str2.indexOf(str) == 0) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}
}
