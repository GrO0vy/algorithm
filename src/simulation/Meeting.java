package simulation;

import java.util.*;

public class Meeting {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;

        int[] answer = new int[n];

        Set<Integer> room = new HashSet<>();
        int enterIdx = 0;

        for(int exitPerson: exit){
            while(!room.contains(exitPerson)){
                int enterPerson = enter[enterIdx];

                for(int person: room){
                    answer[person - 1]++;
                    answer[enterPerson - 1]++;
                }

                room.add(enterPerson);
                enterIdx++;
            }

            room.remove(exitPerson);
        }

        return answer;
    }

    public static void main(String[] args){
        Meeting T = new Meeting();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
