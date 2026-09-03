    package greedy;

    import java.util.*;

    public class cntMove {
        public int solution(int[] nums){
            int answer = 0;

            int two = 0;
            int three = 0;

            for(int num: nums){
                if(num == 2) two++;
                else if(num == 3) three++;
                else answer++;
            }

            int pair = Math.min(two, three);
            two -= pair;
            three -= pair;

            answer += pair;

            answer += (two + 1) / 2; // 아래 두 줄의 압축버전
            // answer += two / 2;
            // answer += two % 2;

            answer += three;

            return answer;
        }

        public static void main(String[] args){
            cntMove T = new cntMove();
            System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
            System.out.println(T.solution(new int[]{2, 3, 4, 5}));
            System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
        }
    }

    // nums 내의 짐의 무게가 2kg ~ 5kg 으로만 구성된 점을 이용
    // 1. 2 와 3의 개수를 센다.
    // 2. 4 와 5는 바로 이동 횟수를 카운트 한다. ( 4, 5 는 한 번에 하난만 이동 가능하기 때문 )
    // 3. 2 ~ 3 의 짝 구하고, 나머지에서 2로 나는 몫, 2로 나눈 나머지를 더한다.