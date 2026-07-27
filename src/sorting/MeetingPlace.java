package sorting;

import java.util.*;

public class MeetingPlace {
    public int solution(int[][] board){
        int answer=0;

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(board[x][y] == 1){
                    xList.add(x);
                    yList.add(y);
                }
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);

        int centerX = xList.get(xList.size() / 2);
        int centerY = yList.get(yList.size() / 2);

        for(int i = 0; i < xList.size(); i++){
            answer += Math.abs(centerX - xList.get(i));
            answer += Math.abs(centerY - yList.get(i));
        }

        return answer;
    }

    public static void main(String[] args){
        MeetingPlace T = new MeetingPlace();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
