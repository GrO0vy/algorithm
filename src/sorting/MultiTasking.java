package sorting;

import java.util.*;

public class MultiTasking {
    public int solution(int[] tasks, long k) {
        int answer = 0;

        int[] orderByTime = new int[tasks.length + 1];
        for(int i = 1; i <= tasks.length; i++){
            orderByTime[i] = tasks[i - 1];
        }

        Arrays.sort(orderByTime);

        long remain = tasks.length;

        for(int i = 1; i <= tasks.length; i++){
            long time = remain * (orderByTime[i] - orderByTime[i - 1]);

            if(time > k){
                int idx = (int)(k % remain);
                int cnt = 0;

                for(int j = 0; j < tasks.length; j++){
                    if(tasks[j] >= orderByTime[i]){
                        if(idx == cnt) return j + 1;

                        cnt++;
                    }
                }

            }
            else{
                remain--;
                k -= time;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        MultiTasking T = new MultiTasking();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }

    // 1. 작업 시간 순으로 정렬한 배열을 하나 새로 만든다. ( 크기 + 1 )
    // 2. 작업 시간이 작은 순서대로 아래의 과정을 수행한다.
    // 2-1. 현재 작업을 처리하는데 걸리는 시간을 구한다.
    // 2-2. 만약 k 보다 작업 시간이 작으면 남은 작업 수를 하나 줄이고, k 에서 작업시간 만큼 뺀다.
    // 2-3. 만약 k 보다 작업 시간이 크면 원본 배열에서 현재 작업 시간보다 크거나 같은 작업 중 (k % 남은 작업 수) 번 쨰인 작업 번호를 리턴한다.
}
