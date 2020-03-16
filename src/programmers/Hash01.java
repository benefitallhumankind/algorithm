package programmers;
import java.util.*;

// 프로그래머스 연습
public class Hash01 {
	public static void main(String[] args) {
		
		String[] participant = {"leo", "kiki", "eden", "leo"};
		String[] completion = {"kiki", "eden", "leo"};
		
		System.out.println( solution2(participant, completion) );
		
	}
	public static String solution1(String[] participant, String[] completion) {
		String answer="";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for(int i = 0; i<participant.length; i++) {
			if( i==completion.length || !participant[i].equals(completion[i]) ) {
				answer = participant[i-1];
				break;
			}
		}		
		return answer;
	}
    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for( String name : participant ) {
    		hm.put( name, hm.getOrDefault(name, 0)+1 );
        }
        for( String name : completion ) {
    		hm.put( name, hm.get(name)-1 );
        }
        for( Map.Entry<String, Integer> elem : hm.entrySet() ) {
        	if( elem.getValue() == 1) {
        		answer = elem.getKey();
        		break;
        	}
        }
        return answer;
    }
}
