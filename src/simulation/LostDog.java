package simulation;

public class LostDog {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;

        int[] person = new int[2];
        int[] dog = new int[2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2) person = new int[]{i, j};
                if(board[i][j] == 3) dog = new int[]{i, j};
            }
        }

        int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int dirPerson = 0;
        int dirDog = 0;

        while((person[0] != dog[0] || person[1] != dog[1]) && answer <= 10000){
            int personX = person[0] + deltas[dirPerson][0];
            int personY = person[1] + deltas[dirPerson][1];
            int dogX = dog[0] + deltas[dirDog][0];
            int dogY = dog[1] + deltas[dirDog][1];

            if(inRange(personX, personY, n) && board[personX][personY] != 1){
                person[0] = personX;
                person[1] = personY;
            }
            else dirPerson = (dirPerson + 1) % 4;

            if(inRange(dogX, dogY, n) && board[dogX][dogY] != 1){
                dog[0] = dogX;
                dog[1] = dogY;
            }
            else dirDog = (dirDog + 1) % 4;

            answer++;
        }

        return answer <= 10000 ? answer : 0;
    }

    boolean inRange(int x, int y, int n){
        return -1 < x && x < n && -1 < y && y < n;
    }

    public static void main(String[] args){
        LostDog T = new LostDog();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
