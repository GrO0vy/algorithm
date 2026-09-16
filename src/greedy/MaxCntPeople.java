package greedy;

import java.util.*;
import java.util.PriorityQueue;

public class MaxCntPeople {
    public int solution(int n, int[][] trains, int[][] bookings){
        int answer=0;

        int[] capacity = new int[n + 1];
        for(int[] train: trains){
            int start = train[0];
            int end = train[1];
            int cap = train[2];

            capacity[start] += cap;
            capacity[end] -= cap;
        }

        for(int i = 1; i <= n; i++){
            capacity[i] = capacity[i - 1] + capacity[i];
        }

        PriorityQueue<int[]> waiting = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int[] booking: bookings) waiting.offer(booking);

        TreeMap<Integer, Integer> passengers = new TreeMap<>();
        int cntPassenger = 0;

        for(int i = 1; i <= n; i++){
            if(passengers.get(i) != null){
                Integer count = passengers.remove(i);

                answer += count;
                cntPassenger -= count;
            }

            while(!waiting.isEmpty() && waiting.peek()[0] == i){
                int[] booking = waiting.poll();

                passengers.put(booking[1], passengers.getOrDefault(booking[1], 0) + 1);
                cntPassenger++;
            }

            while(cntPassenger > capacity[i]){
                Map.Entry<Integer, Integer> entry = passengers.lastEntry();
                int key = entry.getKey();
                int value = entry.getValue();

                int cntRemove = Math.min(value, cntPassenger - capacity[i]);

                if(cntRemove == value) passengers.remove(key);
                else passengers.put(key, value - cntRemove);

                cntPassenger -= cntRemove;
            }
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
    // 현재 역에서 내릴 사람을 모두 내린 후 가장 도착역이 가까운 순으로 최대 인원을 수용한다.

    // 1. 각 역에서의 수용 가능한 인원 수를 배열 형태로 저장한다.
    // 2. 시작 지점 오름차순으로 정렬된 우선순위큐에 예약 정보들을 저장한다.
    // 3. 트리 맵으로 [도착역: 인원수] 형태로 승객 정보를 저장한다. ( 트리 맵은 가장 작거나 큰 key의 value 에 빠르게 접근 가능하다. -> 이진 탐색 트리로 키 들을 관리 )
    // 4. 1 ~ n 번 역을 차례로 방문하면서 아래의 과정을 반복한다.
    // 4-1. 역에 도착했을 때 해당 역에 내리는 승객 수만큼 현재 인원수를 빼고, 정답에 카운트한다.
    // 4-2. 시작지점이 현재 역인 인원을 트리 맵에 저장하고 현재 인원 수도 갱신한다.
    // 4-3. 현재 인원 수가 현재 역의 수용 가능 인원 수보다 크면 트리 맵에서 가장 먼 역을 골라 현재 인원 수가 최대 수용 인원 수가 될 때까지 인원 수를 내린다.
    // ( 트리 맵에서 가장 먼 역 선택 -> 트리 맵에 저장된 인원 수와, 현재 인원 수를 상황에 맞게 갱신 )
    // 5. 최종적으로 모든 역에서 내린 사람 수를 리턴한다.
}
