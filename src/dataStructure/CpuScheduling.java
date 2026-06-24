package dataStructure;

import java.util.*;

public class CpuScheduling {
    public int[] solution(int[][] tasks){
        int[] answer = new int[tasks.length];

        PriorityQueue<Integer> taskQueue = new PriorityQueue<>((o1, o2) -> {
            if(tasks[o1][0] != tasks[o2][0]) return tasks[o1][0] - tasks[o2][0];

            if(tasks[o1][1] != tasks[o2][1]) return tasks[o1][1] - tasks[o2][1];

            return o1 - o2;
        });

        PriorityQueue<Integer> waitingQueue = new PriorityQueue<>((o1, o2) -> {
            if(tasks[o1][1] == tasks[o2][1]) return o1 - o2;

            return tasks[o1][1] - tasks[o2][1];
        });

        for(int i = 0; i < tasks.length; i++) taskQueue.offer(i);

        int idx = 0;
        int time = 0;
        while(!taskQueue.isEmpty() || !waitingQueue.isEmpty()){
            if(waitingQueue.isEmpty()) waitingQueue.offer(taskQueue.poll());

            int current = waitingQueue.poll();

            time = Math.max(time, tasks[current][0]) + tasks[current][1];
            while(!taskQueue.isEmpty() && tasks[taskQueue.peek()][0] <= time){
                waitingQueue.offer(taskQueue.poll());
            }

            answer[idx++] = current;
        }

        return answer;
    }

    // 1. 호출시간이 빠른 순으로 정렬되는 우선 순위 큐를 만든다. ( 남은 작업 목록 큐 )
    // 2. 실행시간이 짧은 순으로 정렬되는 우선 순위 큐를 만든다. ( 대기 큐 )
    // 3. 대기 큐에서 작업 하나를 poll 한다. 만약 대기 큐에 작업이 없다면 남은 작업 목록 큐에서 작업 하나를 poll 한다.
    // 4. 현재 실행 중인 작업을 answer 에 기록한다.
    // 5. 남은 작업 목록 큐에서 현재 작업의 실행 완료시간보다 호출 시간이 빠른 작업들을 대기 큐로 옮긴다.
    // 6. 3 ~ 5 과정을 모든 큐가 빌 때 까지 진행한다.
    // 7. answer 에 기록된 결과를 반환한다.

    public static void main(String[] args){
        CpuScheduling T = new CpuScheduling();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
