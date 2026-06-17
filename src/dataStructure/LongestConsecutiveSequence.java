package dataStructure;

import java.util.*;

public class LongestConsecutiveSequence {
    public int solution(int[] nums){
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: set) pq.offer(num);

        while(!pq.isEmpty()){
            int length = 1;
            int prev = pq.poll();

            while(!pq.isEmpty() && pq.peek() == prev + 1){
                prev = pq.poll();
                length++;
            }

            answer = Math.max(answer, length);
        }
        return answer;
    }
    
    // 1. set 으로 nums 의 중복제거
    // 2. 우선순위큐에 set 의 모든 원소 삽입 (정렬)
    // 3. pq 의 원소를 뽑고 다음 원소가 현재 원소 + 1 이면 다음 원소를 뽑아 현재 원소로 갱신하는 과정 반복
    // 4. 연속된 수의 길이를 구한다.
    // 5. pq 가 빌 때까지 3~4 과정 반복
    // 6. 최대 길이를 반환

    public static void main(String[] args){
        LongestConsecutiveSequence T = new LongestConsecutiveSequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
