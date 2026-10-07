package dfs;

import java.util.*;

public class AlphaCode {
    int answer;
    public int solution(String s){
        answer = 0;

        dfs(s, 0);

        return answer;
    }

    void dfs(String s, int idx){
        if(idx == s.length()){
            answer++;
            return;
        }

        for(int i = 1; i <= 2; i++){
            if(idx + i <= s.length()){
                String num = s.substring(idx, idx + i);

                if(isPossible(num)) dfs(s, idx + i);
            }
        }
    }

    boolean isPossible(String num){
        if(num.startsWith("0")) return false;

        return Integer.parseInt(num) <= 26;
    }

    public static void main(String[] args){
        AlphaCode T = new AlphaCode();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }

    // 1. 문자열을 구성하는 숫자를 한 자리 또는 두 자리로 끊는다.
    // 2. 끊은 숫자가 유효한 숫자인지를 아래와 같이 판단한다.
    // 2-1. 끊은 숫자가 0으로 시작하면 유효한 숫자가 아니다.
    // 2-2. 끊어낸 숫자가 1 ~ 26 사이의 숫자가 아니면 유효한 숫자가 아니다.
    // 3. 만약 유효한 숫자라면 숫자를 해당 알파벳으로 변환하는 메서드를 통해 변환한다.
    // 4. 모든 숫자를 문자로 변환했다면 ( 인덱스의 끝에 도달했다면 ) 해석 가능한 코드의 경우의 수를 +1 한다.
    // 5. 최종적으로 해석 가능한 수를 리턴한다.

    // 시간 초과 가능성 o ( s의 길이가 50 일 때 50 자리에 대해 1 또는 2 자리로 끊는 연산 수행하면 2^50 회 )
}
