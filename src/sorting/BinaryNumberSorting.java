package sorting;

import java.util.*;

public class BinaryNumberSorting {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        List<Number> numbers = new ArrayList<>();
        for(int num: nums){
            numbers.add(new Number(num, getCntOne(num)));
        }

        Collections.sort(numbers, (o1, o2) ->{
            if(o1.cntOne != o2.cntOne) return o1.cntOne - o2.cntOne;

            return o1.num - o2.num;
        });

        for(int i = 0; i < nums.length; i++){
            answer[i] = numbers.get(i).num;
        }

        return answer;
    }

    private int getCntOne(int num){
        String binary = Integer.toBinaryString(num);

        return binary.replace("0", "").length();
    }

    public static void main(String[] args){
        BinaryNumberSorting T = new BinaryNumberSorting();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

    class Number{
        int num;
        int cntOne;

        public Number(int num, int cntOne){
            this.num = num;
            this.cntOne = cntOne;
        }
    }
}
