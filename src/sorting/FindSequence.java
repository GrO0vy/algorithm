package sorting;

import java.util.*;

public class FindSequence {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        Arrays.sort(nums);

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        int idx = 0;
        for(int num: nums){
            if(freq.get(num) == 0) continue;

            answer[idx++] = num;

            freq.put(num, freq.getOrDefault(num, 0) - 1);
            freq.put(num * 2, freq.getOrDefault(num * 2, 0) - 1);
        }

        return answer;
    }

    // 1. nums 를 정렬한다.
    // 2. nums 를 복제한 리스트를 만든다.
    // 3. nums 를 순회하면서 복제한 리스트에 요소가 존재하고, nums[i] * 2 가 복제한 리스트에 존재하면 nums[i] * 2 를 리스트에서 제거한다.
    // 4. 리스트의 남은 결과를 배열 형태로 리턴한다.

    public static void main(String[] args){
        FindSequence T = new FindSequence();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
