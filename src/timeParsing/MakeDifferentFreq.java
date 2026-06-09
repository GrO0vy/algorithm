package timeParsing;

import java.util.*;

public class MakeDifferentFreq {
    private final int CNT_CHAR = 26;

    public int solution(String s){
        int answer = 0;

        Map<Character, Integer> cnt = new HashMap<>();
        Set<Integer> used = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(char key: cnt.keySet()){
            while(cnt.get(key) > 0 && used.contains(cnt.get(key))){
                answer++;
                cnt.put(key, cnt.get(key) - 1);
            }

            if(cnt.get(key) > 0) used.add(cnt.get(key));
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
