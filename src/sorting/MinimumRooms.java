package sorting;

import java.util.*;

public class MinimumRooms {
    public int solution(int[][] meetings){
        int answer = 0;

        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> inProgress = new PriorityQueue<>();

        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];

            while(!inProgress.isEmpty() && inProgress.peek() <= start) inProgress.poll();

            inProgress.offer(end);

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

    // 1. 회의 시간을 시작 시간 순 정렬
    // 2. 현재 진행 중인 회의의 종료 시간을 저장 할 우선 순위 큐를 만든다.
    // 3. 시작 시간 순으로 회의를 순회하면서 아래의 과정을 반복
    // 3-1. 진행 중인 회의 중 선택된 회의 시작시간 전에 종료되는 회의를 모두 제거한다.
    // 3-2. 선택된 회의를 진행 중인 회의 큐에 넣는다.
    // 3-3. 진행 중 큐 크기의 최대 크기를 구한다.
}
