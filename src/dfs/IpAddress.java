package dfs;

import java.util.*;

public class IpAddress {
    List<String> numbers;
    List<String> result;

    public String[] solution(String s){
        String[] answer = {};

        numbers = new ArrayList<>();
        result = new ArrayList<>();

        dfs(s, 0, 0);

        answer = result.toArray(new String[0]);

        return answer;
    }

    void dfs(String str, int idx, int depth){
        if(depth == 4 || idx == str.length()){
            if(depth == 4 && idx == str.length()){
                String address = "";

                for(String num: numbers) address += num + " ";

                result.add(address.trim().replaceAll("\\s+", "\\."));
            }

            return;
        }

        numbers.add(str.substring(idx, idx + 1));
        dfs(str, idx + 1, depth + 1);
        numbers.removeLast();

        if (idx + 1 < str.length()) {
            String slice = str.substring(idx, idx + 2);

            if(isPossible(slice)){
                numbers.add(slice);
                dfs(str, idx + 2, depth + 1);
                numbers.removeLast();
            }
        }

        if (idx + 2 < str.length()) {
            String slice = str.substring(idx, idx + 3);

            if(isPossible(slice)){
                numbers.add(str.substring(idx, idx + 3));
                dfs(str, idx + 3, depth + 1);
                numbers.removeLast();
            }
        }
    }

    boolean isPossible(String num){
        int intNum = Integer.parseInt(num);

        return !num.startsWith("0") && 0 <= intNum && intNum <= 255;
    }

    public static void main(String[] args){
        IpAddress T = new IpAddress();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }

    // 1. 문자를 1 ~ 3 글자 단위로 쪼갠다.
    // 2. 문자의 시작이 0이 아닐 때만 2 ~ 3 글자 단위로 쪼갠다.
    // 3. 총 네 번을 쪼갰을 때 문자열의 모든 숫자가 포함되었을 때 ( 현재 인덱스 위치가 원본 문자열의 길이와 같을 때 ) IP 주소를 만들어 자장한다.
    // 4. 각 단계의 숫자들은 리스트에 순서대로 저장했다가 IP 주소를 만들 때 사용한다.
}
