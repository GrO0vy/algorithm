package simulation;

import java.util.*;

public class MaxLenBitonic {
    public int solution(int[] nums){
        int answer = 0;

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]) left[i] = left[i - 1] + 1;
        }

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1]) right[i] = right[i + 1] + 1;
        }

        for(int i = 0; i < n; i++){
            if(left[i] > 0 && right[i] > 0) answer = Math.max(answer, left[i] + right[i] + 1);
        }

        return answer;

    }

    public static void main(String[] args){
        MaxLenBitonic T = new MaxLenBitonic();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
