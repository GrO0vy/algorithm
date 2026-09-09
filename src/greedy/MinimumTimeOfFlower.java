package greedy;

import java.util.ArrayList;

import java.util.*;

public class MinimumTimeOfFlower {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;

        List<Plant> plants = new ArrayList<>();
        for(int i = 0; i < plantTime.length; i++){
            plants.add(new Plant(plantTime[i], growTime[i]));
        }

        Collections.sort(plants, (o1, o2) -> o2.growTime - o1.growTime);

        int start = 0;
        int end = 0;

        for(Plant plant: plants){
            int complete = start + plant.plantTime + plant.growTime;

            start += plant.plantTime;
            end = Math.max(end, complete);
        }

        answer = end;

        return answer;
    }

    public static void main(String[] args){
        MinimumTimeOfFlower T = new MinimumTimeOfFlower();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }

    class Plant{
        int plantTime;
        int growTime;

        public Plant(int plantTime, int growTime){
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }

    // 자라는 시간이 가장 긴 식물부터 심는 것이 해법
    // --> 심는 시간은 결국 다 거쳐야 한다.
    // 그러면 마지막 식물은 심는데에 걸리는 시간이 모든 식물이 심는데에 걸리는 시간과 같다.
    // 그랬을 때 제일 빠르게 종료 되어야 한다면 마지막 식물은 자라는 시간이 제일 짧은 식물이어야한다.
    // 결국 전체가 최적의 선택이 되기 위해서는 n ~ 1 번 째 식물이 각각 1 ~ n 번 째로 큰 식물과 매칭되어야 한다.
    // 그렇기 때문에 자라는 시간이 가장 긴 식물부터 심는 것이 정답이 된다.

    // 1. 식물 클래스를 만들고 심는 시간과 자라는 시간을 기록한다.
    // 2. 자라는 시간을 기준으로 식물들을 내림차순 정렬한다.
    // 3. 심기 완료된 시간과 자라기 완료된 시간을 기록 할 변수를 두 개 만든다.
    // 4. 이전에 저장된 자라기 완료된 시간과 현재 선택 된 식물의 다 자라는데 걸리는 시간 중 더 오래 걸리는 것으로 갱신한다.
    // 5. 심기 완료 시간을 갱신한다.
    // 6. 모든 식물에 대해 4 ~ 5 과정을 반복한다.
    // 7. 최종적으로 모두 다 자란 시간을 리턴한다.
}
