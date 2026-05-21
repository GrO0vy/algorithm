package simulation;

import java.util.*;
public class NumberOfSeat {
    public int[] solution(int c, int r, int k){
        if(c * r < k) return new int[]{0, 0};

        int[] answer = {0, -1};
        boolean[][] visited = new boolean[c][r];

        int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;

        while(k > 0){
            int nextX = answer[0] + deltas[dir][0];
            int nextY = answer[1] + deltas[dir][1];

            if(-1 < nextX && nextX < c && -1 < nextY && nextY < r && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                answer[0] = nextX;
                answer[1] = nextY;
                k--;
            }
            else dir = (dir + 1) % 4;
        }

        answer[0]++;
        answer[1]++;

        return answer;
    }

    public static void main(String[] args){
        NumberOfSeat T = new NumberOfSeat();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
