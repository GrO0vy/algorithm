package dataStructure;

import java.util.*;

public class LongestConsecutiveSequence {
    public int solution(int[] nums){
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        for(int num: set){
            if(set.contains(num - 1)) continue;

            int len = 1;
            while(set.contains(num + 1)){
                len++;
                num++;
            }

            answer = Math.max(answer, len);
        }

        return answer;
    }

    // 1. set 에 nums 의 원소를 저장한다 ( 중복제거 )
    // 2. set 의 원소를 순회하면서 만약 원소 - 1 의 값이 set에 존재한다면 continue ( 시작점이 아닌 부분은 거른다 )
    // 3. 시작점이라면 +1 을 해나가면서 연속된 원소의 개수를 센다.
    // 4. 최대 길이와 연속된 원소의 개수를 비교한다.
    // 5. 최대 길이를 반환한다.

    public static void main(String[] args){
        LongestConsecutiveSequence T = new LongestConsecutiveSequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
