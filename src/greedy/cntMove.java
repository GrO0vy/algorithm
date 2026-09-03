package greedy;

import java.util.*;

public class cntMove {
    public int solution(int[] nums){
        int answer = 0;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int sum = nums[right];

            while(left < right && sum + nums[left] <= 5){
                sum += nums[left];
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        cntMove T = new cntMove();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}

// 1. 배열을 정렬한다.
// 2. 가장 큰 무게를 선택한다.
// 3. 가장 작은 무게부터 누적 합을 한 결과가 5이하 일 때까지 작은 무게를 더한다.
// 4. 누적 합이 5를 초과하면 이동 횟수를 1증가 시킨다.
// 5. 최종적으로 모든 물건을 다 이동시키고 난 후 이동 횟수를 리턴한다.

