package timeParsing;

import java.util.*;

public class MakeSameFreq {
    public int[] solution(String s){
        int[] answer = new int[5];

        int max = 0;

        Map<Character, Integer> cnt = new HashMap<>();
        for(char c = 'a'; c <= 'e'; c++) cnt.put(c, 0);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            cnt.put(c, cnt.getOrDefault(c, 0) + 1);

            max = Math.max(max, cnt.get(c));
        }

        for(char key: cnt.keySet()){
            answer[key - 'a'] = max - cnt.get(key);
        }

        return answer;
    }

    public static void main(String[] args){
        MakeSameFreq T = new MakeSameFreq();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
