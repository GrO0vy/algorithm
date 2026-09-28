package dfs;

public class TugOfWar {
    private final int CNT_PEOPLE = 7;

    int answer;
    boolean[][] isFight;
    boolean[] visited;

    public int solution(int[][] fight){
        answer = 0;
        visited = new boolean[CNT_PEOPLE + 1];
        isFight = new boolean[CNT_PEOPLE + 1][CNT_PEOPLE + 1];

        for(int[] info: fight){
            int person1 = info[0];
            int person2 = info[1];

            isFight[person1][person2] = true;
            isFight[person2][person1] = true;
        }

        for(int i = 1; i <= CNT_PEOPLE; i++){
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }

        return answer;
    }

    void dfs(int person, int depth){
        if(depth == 6){
            answer++;

            return;
        }

        for(int i = 1; i <= CNT_PEOPLE; i++){
            if(!visited[i] && !isFight[person][i]){
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        TugOfWar T = new TugOfWar();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}

// 1. 싫어 하는 사람의 정보를 이차원 배열에 저장한다.
// 2. 학생이 선택됐는지를 저장 할 배열을 만든다.
// 3. 1 ~ 7 번을 dfs 를 이용해서 줄을 세우는데 현재 선택 된 사람과 사이가 좋은 경우에만 줄을 세운다.
// 4. 만약 남은 사람 중 사이가 좋은 사람이 없다면 dfs 를 중단한다.
// 5. 7명 모두를 줄 세운 경우를 카운트하고 최종적으로 몇 개의 경우의 수가 있는지를 리턴한다.
