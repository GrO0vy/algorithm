    package simulation;

    public class PickUpFruits {
        public int solution(int[][] fruit){
            int answer = 0;

            int[] minFruit = new int[fruit.length];

            for(int i = 0; i < fruit.length; i++){
                int idx = 0;
                int cnt = fruit[i][0];

                for(int j = 1; j < fruit[i].length; j++){
                    if(fruit[i][j] < cnt){
                        idx = j;
                        cnt = fruit[i][j];
                    }
                }

                minFruit[i] = idx;
            }

            boolean[] exchanged = new boolean[fruit.length];

            for(int i = 0; i < fruit.length; i++){
                int cnt = 0;
                for(int j = 0; j < fruit[i].length; j++){
                    if(fruit[i][j] == fruit[i][minFruit[i]]) cnt++;
                }

                if(cnt > 1) {
                    exchanged[i] = true;
                    answer += fruit[i][minFruit[i]];
                }
            }

            for(int i = 0; i < fruit.length; i++){
                if(exchanged[i]) continue;

                for(int j = i + 1; j < fruit.length; j++){
                    if(exchanged[j] || minFruit[i] == minFruit[j]) continue;

                    int iMin = fruit[i][minFruit[i]];
                    int iGive = fruit[i][minFruit[j]];

                    int jMin = fruit[j][minFruit[j]];
                    int jGive = fruit[j][minFruit[i]];

                    if(iGive >= iMin + 2 && jGive >= jMin + 2){
                        exchanged[i] = true;
                        exchanged[j] = true;
                        answer += iMin + jMin + 2;
                        break;
                    }
                }
            }

            for(int i = 0; i < fruit.length; i++){
                if(!exchanged[i]) answer += fruit[i][minFruit[i]];
            }

            return answer;
        }

        public static void main(String[] args){
            PickUpFruits T = new PickUpFruits();
            System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
            System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
            System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
            System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
        }
    }
