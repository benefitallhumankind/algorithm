package programmers;
import java.util.*;

// 프로그래머스 연습
public class Hash03 {
	public static void main(String[] args) {
		
		String[][] clothes = 
			{
				{"yellow_hat", "face"},
				{"yellow_hat", "face"}
			};
		
		System.out.println( solution1(clothes) );
		
	}
	public static int solution1(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for( int i = 0; i<clothes.length; i++ ) {
        	String kind = clothes[i][1];
        	hm.put(kind, hm.getOrDefault(kind, 0)+1);
        }        
        if(hm.size() == 1) {
        	return clothes.length;
        } else {
        	answer = 1;
        	for( Map.Entry<String, Integer> elem : hm.entrySet()) {
        		answer *= (elem.getValue()+1);
        	}
        	answer--;
        }        
        return answer;
	}
}
