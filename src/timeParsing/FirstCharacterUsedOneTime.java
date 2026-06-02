package timeParsing;

import java.util.*;

public class FirstCharacterUsedOneTime {
    public int solution(String s){
        int answer = -1;

        Map<Character, Integer> cnt = new HashMap<>();
        for(char c: s.toCharArray()) cnt.put(c, cnt.getOrDefault(c, 0) + 1);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(cnt.get(c) == 1) return i + 1;
        }

        return answer;
    }

    public static void main(String[] args){
        FirstCharacterUsedOneTime T = new FirstCharacterUsedOneTime();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }

}
