package dfs;

public class NearestBigNumber {
    private final int DEFAULT = Integer.MAX_VALUE;

    int n;
    int answer;
    boolean[] visited;

    public int solution(int n){
        this.n = n;
        answer = DEFAULT;

        String origin = Integer.toString(n);
        visited = new boolean[origin.length()];

        for(int i = 0; i < origin.length(); i++){
            visited[i] = true;
            getNumber(origin, String.valueOf(origin.charAt(i)));
            visited[i] = false;
        }

        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    void getNumber(String origin, String newNum){
        if(newNum.length() == origin.length()){
            int num = Integer.parseInt(newNum);
            if(num > n) answer = Math.min(answer, num);

            return;
        }

        for(int i = 0; i < origin.length(); i++){
            if(!visited[i]) {
                visited[i] = true;
                getNumber(origin, newNum + origin.charAt(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        NearestBigNumber T = new NearestBigNumber();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }

    // 1. 각 자리의 숫자에 대해 방문 여부를 저장 할 visited 배열을 둔다.
    // 2. dfs 로 모든 자리의 수를 방문해서 방문 순서에 따른 조합을 구한다.
    // 3. 조합 중 n 보다 큰 수 중 가장 작은 값을 targetNumber 에 저장한다.
    // 4. answer 에 Integer.MAX_VALUE ( 초기 값 ) 이 그대로 저장되어 있다면 -1 을 리턴하고 그렇지 않으면 answer 를 리턴한다.
}
