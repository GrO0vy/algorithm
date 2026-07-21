package sorting;

import java.util.*;

public class Judge {
    public int solution(int[] score, int k){
        int answer = Integer.MAX_VALUE;

        Arrays.sort(score);

        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += score[i];
        }

        if(score[k - 1] - score[0] <= 10) return sum / k;

        for(int i = k; i < score.length; i++){
            sum -= score[i - k];
            sum += score[i];

            if(score[i] - score[i - k + 1] <= 10) return sum / k;
        }

        return answer;
    }

    public static void main(String[] args){
        Judge T = new Judge();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }

    // 1. 숫자 정렬
    // 2. k 간격을 유지 한 채로 이동하면서 첫 원소와 마지막 원소의 차이가 10이하 이면 평균의 최댓값을 갱신
}
