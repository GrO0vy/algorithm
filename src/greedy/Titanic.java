package greedy;

import java.util.*;

public class Titanic {
    public int solution(int[] nums, int m){
        int answer = 0;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int weight = nums[left] + nums[right];

            if(weight <= m) left++;

            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Titanic T = new Titanic();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }

    // 1. 승객 몸무게를 낮은 순으로 정렬한다.
    // 2. 왼쪽 포인터와 오른쪽 포인터를 둔다.
    // 3. 왼쪽과 오른쪽의 몸무게의 합이 m을 넘어가면 오른쪽 포인터를 한 칸 앞으로 이동하고 횟수를 +1 카운트 한다.
    // 4. 왼쪽과 오른쪽의 몸무게의 합이 m을 넘지 않으면 왼쪽 포인터는 뒤로 한 칸 오른쪽 포인터는 앞으로 한 칸 이동하고 횟수를 +1 카운트 한다.
    // 5. 왼쪽 포인터가 오른쪽 포인터보다 왼쪽에 있을 때 까지 과정을 반복한다.
}
