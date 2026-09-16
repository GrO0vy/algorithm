package greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxCntPeople {
    public int solution(int n, int[][] trains, int[][] bookings){
        int answer=0;

        int[] capacity = new int[n + 1];
        for(int[] train: trains){
            for(int i = train[0]; i < train[1]; i++) capacity[i] += train[2];
        }

        PriorityQueue<int[]> waiting = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int[] booking: bookings) waiting.offer(booking);

        PriorityQueue<Integer> train = new PriorityQueue<>();
        PriorityQueue<Integer> remain = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i <= n; i++){
            while(!train.isEmpty() && train.peek() == i){
                remain.remove(train.poll());
                answer++;
            }

            while(!waiting.isEmpty() && waiting.peek()[0] == i){
                int[] booking = waiting.poll();

                train.offer(booking[1]);
                remain.offer(booking[1]);
            }

            while(!train.isEmpty() && train.size() > capacity[i]) train.remove(remain.poll());
        }

        return answer;
    }

    public static void main(String[] args){
        MaxCntPeople T = new MaxCntPeople();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }

    // 1. 각 역에서의 수용 가능한 인원 수를 배열 형태로 저장한다.
    // 2. 시작 지점을 기준으로 오름차순 한 우선순위큐 ( waiting ) 에 예약 정보를 모두 저장한다.
    // 3. 도착 지점을 기준으로 오름차순 한 우선순위큐 ( train )와 도착 지점을 기준으로 내림차순한 우선순위큐 ( remain ) 를 만든다.
    // 4. train 큐에서 n번째 역에 도착 한 사람을 모두 poll 해서 카운트한다.
    // 5. waiting 큐에서 시작 지점이 n인 사람을 train 과 remain 에 offer 한다.
    // 6. 만약 train 큐의 크기가 해당 역의 수용 인원보다 크면 remain 큐에서 가장 멀리서 내리는 사람 한명을 선택해서 제거한다.
    // 7. 최종적으로 모든 역에서 내린 사람의 수를 리턴한다.
}
