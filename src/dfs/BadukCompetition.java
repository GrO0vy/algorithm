package dfs;

public class BadukCompetition {
    int cntCans;
    int maxCntTeam;
    int answer;

    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;

        cntCans = cans.length;
        maxCntTeam = cntCans / 2;

        dfs(cans, 0, 0, 0, 0, 0);

        return answer;
    }

    void dfs(int[][] cans, int idx, int scoreBlack, int scoreWhite, int cntBlack, int cntWhite){
        if(idx == cntCans){
            answer = Math.min(answer, Math.abs(scoreBlack - scoreWhite));
            return;
        }

        if(cntBlack < maxCntTeam) dfs(cans, idx + 1, scoreBlack + cans[idx][0], scoreWhite, cntBlack + 1, cntWhite);
        if(cntWhite < maxCntTeam) dfs(cans, idx + 1, scoreBlack, scoreWhite + cans[idx][1], cntBlack, cntWhite + 1);
    }

    public static void main(String[] args){
        BadukCompetition T = new BadukCompetition();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }

    // cans 의 모든 요소를 dfs 로 방문하면서 흰 돌을 선택했을 때와 검은 돌을 선택했을 때의 경우를 모두 구한다.
}
