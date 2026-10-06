package dfs;

import java.util.*;

public class CntPalindrome {
    int length;
    Set<String> palindromes;
    Map<Character, Integer> cnt;

    public String[] solution(String s){
        String[] answer = {};

        length = s.length();
        palindromes = new HashSet<>();

        cnt = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        int cntOdd = 0;
        for(char letter: cnt.keySet()){
            if(cnt.get(letter) % 2 == 1) cntOdd++;

            if(cntOdd >= 2) return answer;
        }

        dfs(new StringBuilder());

        answer = palindromes.toArray(new String[0]);

        return answer;
    }

    void dfs(StringBuilder sb){
        if(sb.length() == length){
            palindromes.add(sb.toString());
            return;
        }

        for(char letter: cnt.keySet()){
            if(cnt.get(letter) >= 2){
                sb.insert(0, letter).append(letter);
                cnt.put(letter, cnt.get(letter) - 2);
                dfs(sb);
                sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
                cnt.put(letter, cnt.get(letter) + 2);
            }
            else if(cnt.get(letter) == 1){
                sb.insert(sb.length() / 2, letter);
                cnt.put(letter, cnt.get(letter) - 1);
                dfs(sb);
                sb.deleteCharAt(sb.length() / 2);
                cnt.put(letter, cnt.get(letter) + 1);
            }
        }
    }

    public static void main(String[] args){
        CntPalindrome T = new CntPalindrome();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }

    // 1. Map 에 [알파벳, 개수] 형태로 구성된 알파벳 정보를 저장한다.
    // 2. 1의 과정에서 홀 수개인 알파벳이 두 개 이상이라면 바로 빈 배열을 리턴한다.
    // 3. 그렇지 않다면 아래의 방식으로 dfs 를 이용해 가능한 팰린드롬을 조합한다.
    // 3-1. 개수가 2 이상이면 만들어진 문자열의 양 끝에 문자를 붙인 뒤 알파벳 개수를 -2 한다.
    // 3-2. 개수가 1 이면 문자열의 중간에 문자를 삽입한다.
    // 3-3. 문자열의 길이가 원본 문자열의 길이 ( N ) 과 같으면 정답 배열에 팰린드롬을 추가한다.
}
