package sorting;

import java.util.*;

public class PickingCard {
    public int solution(int[] nums, int k){
        int answer = 0;

        Arrays.sort(nums);

        List<Round> game = new ArrayList<>();

        for(int i = 0; i < nums.length; i+=2){
            int num1 = nums[i];
            int num2 = nums[i + 1];
            int diff = num2 - num1;

            game.add(new Round(num1, num2, diff));
        }

        Collections.sort(game, (o1, o2) -> o2.diff - o1.diff);

        for(Round round: game){
            if(k > 0){
                answer += round.num2;
                k--;
            }
            else answer += round.num1;
        }

        return answer;
    }

    public static void main(String[] args){
        PickingCard T = new PickingCard();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }

    static class Round{
        int num1;
        int num2;
        int diff;

        public Round(int num1, int num2, int diff){
            this.num1 = num1;
            this.num2 = num2;
            this.diff = diff;
        }
    }


    // 1. 숫자를 정렬한다.
    // 2. 라운드 클래스를 만든다.
    // 3. 숫자를 두 개 씩 끊어서 카드1, 카드2, 두 수의 차이를 라운드 클래스 형태로 저장한다.
    // 4. 라운드를 두 수의 차이 순으로 정렬한다.
    // 5. k > 0 이면 큰 수를 선택하고 k-- 하고, 그렇지 않으면 작은 수를 선택한다.
    // 6. 최종적으로 선택 한 수들의 합을 리턴한다.
}
