package sorting;

import java.util.*;

public class MinimumRooms {
    public int solution(int[][] meetings){
        int answer = 0;

        PriorityQueue<int[]> inProgress = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        PriorityQueue<int[]> waiting = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int[] meeting: meetings) waiting.offer(meeting);

        Arrays.sort(meetings, (o1, o2) -> o1[1] - o2[1]);

        for(int[] meeting: meetings){
            while(!inProgress.isEmpty() && inProgress.peek()[1] <= meeting[0]){
                inProgress.poll();
            }

            while(!waiting.isEmpty() && waiting.peek()[0] <= meeting[0]){
                inProgress.offer(waiting.poll());
            }

            answer = Math.max(answer, inProgress.size());
        }

        return answer;
    }

    public static void main(String[] args){
        MinimumRooms T = new MinimumRooms();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }

    // 1. 회의 시간을 시작 시간 순 정렬, 끝나는 시간 순 정렬한다.
    // 2. 현재 진행 중인 회의를 저장 할 큐를 만든다. ( 종료 시간 순 우선순위 큐 )
    // 3. 제일 먼저 끝나는 회의를 선택한다.
    // 4. 선택한 회의의 시작 시간보다 일찍 종료되는 회의를 진행 큐에서 제거한다.
    // 5. 대기 큐의 회의 중 선택한 회의보다 일찍 또는 동시에 시작하는 회의를 모두 진행 큐에 넣는다.
    // 6. 큐의 사이즈와 정답과 비교해서 동시에 진행되는 회의의 최댓값을 구한다.
}
