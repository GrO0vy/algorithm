package timeParsing;

import java.util.*;

public class SubsequenceContainsNegative {
    public int solution(int[] nums, int m){
        int answer = 0;

        Map<Integer, Integer> cntSum = new HashMap<>();
        cntSum.put(0, 1);

        int sum = 0;

        for(int num: nums){
            sum += num;

            answer += cntSum.getOrDefault(sum - m, 0);

            cntSum.put(sum, cntSum.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        SubsequenceContainsNegative T = new SubsequenceContainsNegative();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
