package simulation;

import java.util.*;

public class Password {
    public int solution(int[] keypad, String password){
        int answer = 0;

        int rowLen = 3;
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int[][] distance = new int[keypad.length + 1][keypad.length + 1];
        for(int[] row: distance) Arrays.fill(row, 2);

        for(int i = 0; i < keypad.length; i++){
            distance[keypad[i]][keypad[i]] = 0;

            int fromX = i / rowLen;
            int fromY = i % rowLen;

            for(int[] delta: deltas){
                int toX = fromX + delta[0];
                int toY = fromY + delta[1];

                if(!inRange(toX, toY, rowLen)) continue;

                distance[keypad[i]][keypad[rowLen * toX + toY]] = 1;
            }
        }

        for(int i = 0; i < password.length() - 1; i++){
            int from = (int)(password.charAt(i) - '0');
            int to = (int)(password.charAt(i + 1) - '0');

            answer += distance[from][to];
        }

        return answer;
    }

    boolean inRange(int x, int y, int max){
        return -1 < x && x < max && -1 < y && y < max;
    }

    public static void main(String[] args){
        Password T = new Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
