package simulation;

import java.util.*;

public class Cleaning {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        int n = board.length;

        int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;

        int[] current = {0, 0};

        for(int i = 0; i < k; i++){
            int[] delta = deltas[dir];

            int nextX = current[0] + delta[0];
            int nextY = current[1] + delta[1];

            if(inRange(nextX, nextY, n) && board[nextX][nextY] == 0){
                current[0] = nextX;
                current[1] = nextY;
            }
            else dir = (dir + 1) % 4;
        }

        answer = current;

        return answer;
    }

    boolean inRange(int x, int y, int n){
        return -1 < x && x < n && -1 < y && y < n;
    }

    public static void main(String[] args){
        Cleaning T = new Cleaning();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
