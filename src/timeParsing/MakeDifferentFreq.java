package timeParsing;

import java.util.*;

public class MakeDifferentFreq {
    private final int CNT_CHAR = 26;

    public int solution(String s){
        int answer = 0;

        int[] freq = new int[CNT_CHAR];
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        int maxFreq = 0;
        int remain = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < CNT_CHAR; i++) {
            map.put(freq[i], map.getOrDefault(freq[i], 0) + 1);
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        for(int i = maxFreq; i > 0; i--){
            if(map.containsKey(i)){
                answer += remain + map.get(i) - 1;
                remain += map.get(i) - 1;
            }
            else{
                remain = Math.max(0, remain - 1);
                answer += remain;
            }
        }

//        answer += Math.max(0, remain);

        return answer;
    }

    public static void main(String[] args){
        MakeDifferentFreq T = new MakeDifferentFreq();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
        System.out.println(T.solution("ceabaacb")); //2
    }
}
