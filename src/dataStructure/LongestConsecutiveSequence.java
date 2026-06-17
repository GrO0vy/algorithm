package dataStructure;

import java.util.*;

public class LongestConsecutiveSequence {
    public int solution(int[] nums){
        int answer = 1;

        Arrays.sort(nums);

        int[] maxLen = new int[nums.length];
        maxLen[0] = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] + 1 == nums[i]){
                maxLen[i] = maxLen[i - 1] + 1;
                answer = Math.max(answer, maxLen[i]);
            }
            else if(nums[i - 1] == nums[i]) maxLen[i] = maxLen[i - 1];
            else maxLen[i] = 1;
        }

        return answer;
    }

    // 1. 정렬을 한다
    // 2. 각 원소를 끝 원소로 했을 때의 최대 연속 수열 길이를 저장 할 배열 선언 ( maxLen )
    // 3. maxLen 배열의 첫 원소를 1로 초기화
    // 4. for 문으로 두 번 쨰 원소부터 모든 원소를 순회하며 아래의 과정 수행
    // 4-1. 만약 이전 원소와의 차이가 1이라면 이전 원소의 연속 수열 길이 + 1 을 현재 원소의 연속 수열 길이로 한 후 이전까지의 최대 길이와 비교해서 최대 길이를 갱신한다.
    // 4-2. 만약 이전 원소와 현재 원소가 같다면 이전 원소의 연속 수열 길이를 현재 원소의 연속 수열 길이로 한다.
    // 4-3. 이외의 경우는 현재 원소의 연속 수열 길이를 1로 한다.
    // 5. 결과로 최댓값을 리턴한다.

    public static void main(String[] args){
        LongestConsecutiveSequence T = new LongestConsecutiveSequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
