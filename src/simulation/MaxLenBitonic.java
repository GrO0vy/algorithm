package simulation;

import java.util.*;

public class MaxLenBitonic {
    public int solution(int[] nums){
        int answer = 0;

        List<Integer> turningPoint = new ArrayList<>();

        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                turningPoint.add(i);
            }
        }

        for(int t: turningPoint){
            answer = Math.max(answer, getLength(t, nums));
        }

        return answer;
    }

    int getLength(int mid, int[] nums){
        int start = mid;
        int end = mid;

        while(start > 0 && nums[start - 1] < nums[start]) start--;
        while(end < nums.length - 1 && nums[end + 1] < nums[end]) end++;

        return end - start + 1;
    }

    public static void main(String[] args){
        MaxLenBitonic T = new MaxLenBitonic();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
