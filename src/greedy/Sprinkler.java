package greedy;

import java.util.*;

public class Sprinkler {
    public int solution(int n, int[] nums){
        int answer = 0;

        int[][] lines = new int[n + 1][2];

        for(int i = 0; i <= n; i++){
            lines[i][0] = Math.max(0, i - nums[i]);
            lines[i][1] = Math.min(n, i + nums[i]);
        }

        Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);

        int start = 0;
        int end = 0;
        int idx = 0;

        while(end < n){
            while(idx <= n && lines[idx][0] <= start) {
                end = Math.max(end, lines[idx][1]);
                idx++;
            }

            if(start == end) return -1;

            start = end;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Sprinkler T = new Sprinkler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }

    // 1. 각 스프링클러의 범위를 ( 시작 지점, 끝 지점 ) 형식으로 배열에 저장한다.
    // 2. 시작 지점의 오름차순으로 범위를 정렬한다.
    // 3. 아래의 과정을 통해 최적의 스프링클러를 선택한다.
    // 3-1. 이전에 선택한 최적 스프링클러의 위치를 저장 할 변수를 두 개 만든다. ( 시작점, 끝점 )
    // 3-2. 이전의 시작점보다 작거나 같은 스프링클러 중 끝 점이 가장 큰 스프링클러를 선택한다.
    // 3-3. 만약 선택된 스프링클러가 없는 경우 ( 선택한 스프링클러의 시작/끝 점이 같은 경우 ) -1을 리턴한다.
    // 3-4. 선택된 최적의 스플링클러가 있다면 갯수를 +1 하고, 그 끝점이 n과 같아지면 반복을 종료한다.
    // 4. 최종적으로 사용되는 스프링클러의 개수를 구한다.
}
