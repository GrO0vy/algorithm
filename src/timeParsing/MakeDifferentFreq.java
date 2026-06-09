package timeParsing;

import java.util.*;

public class MakeDifferentFreq {
    private final int CNT_CHAR = 26;

    public int solution(String s){
        int answer = 0;

        int[] cnt = new int[CNT_CHAR];
        Set<Integer> used = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        for(int c: cnt){
            while(c > 0 && used.contains(c)) {
                c--;
                answer++;
            }

            if(c > 0) used.add(c);
        }

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
