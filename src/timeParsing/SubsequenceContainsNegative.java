package timeParsing;

public class SubsequenceContainsNegative {
    public int solution(int[] nums, int m){
        int answer = 0;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }

        for(int i = 0; i < sum.length; i++){
            if(sum[i] == m) answer++;

            for(int j = 0; j < i; j++){
                if(sum[i] - sum[j] == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        SubsequenceContainsNegative T = new SubsequenceContainsNegative();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
