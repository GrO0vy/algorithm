package dataStructure;

import java.util.*;

public class EnterAndExitOrder {
    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];

        List<Employee> enter = new ArrayList<>();
        List<Employee> exit = new ArrayList<>();

        for(int i = 0; i < arrival.length; i++){
            Employee emp = new Employee(i, arrival[i]);

            if(state[i] == 0) enter.add(emp);
            else exit.add(emp);
        }

        Collections.sort(enter, (o1, o2) -> o1.time - o2.time);
        Collections.sort(exit, (o1, o2) -> o1.time - o2.time);

        int enterIdx = 0;
        int exitIdx = 0;
        int time = 0;

        while(enterIdx < enter.size() || exitIdx < exit.size()){
            if(enterIdx >= enter.size() || exitIdx < exit.size() && exit.get(exitIdx).time <= enter.get(enterIdx).time){
                time = Math.max(time, exit.get(exitIdx).time);

                while(exitIdx < exit.size() && exit.get(exitIdx).time <=time ){
                    answer[exit.get(exitIdx).num] = time;

                    time++;
                    exitIdx++;
                }
            }
            else{
                time = Math.max(time, enter.get(enterIdx).time);

                while(enterIdx < enter.size() && enter.get(enterIdx).time <= time){
                    answer[enter.get(enterIdx).num] = time;

                    time++;
                    enterIdx++;
                }
            }
        }

        return answer;
    }

//  1. 사원번호, 도착 시간, 상태를 저장하는 클래스를 만든다.
//  2. 1에서 만든 클래스의 리스트를 두 개 만든다. ( 입장 리스트, 퇴장 리스트 )
//  3. 2의 리스트에 정보들을 저장하고 도착 시간이 빠른 순으로 정렬한다.
//  4. enterIdx 와 exitIdx 를 둔다.
//  5. enterIdx 의 도착시간과 exitIdx의 도착시간을 비교해서 exitIdx 의 도착 시간이 빠르거나 같으면 퇴장을 진행, 그렇지 않으면 입장을 진행한다.
//  6. 입장과 퇴장은 한 명이 입장하고 1초 뒤에 입장 또는 퇴장을 이어서 하는 사람이 없을 때 까지 진행한다.
//  7. 입장 또는 퇴장의 첫 시작은 Math.max(현재 시간, 도착 시간) 으로 하고 그 이후의 시간들은 while 문에서 1씩 더해 저장한다.
//  8. 5 ~ 8 과정을 enterIdx 와 exitIdx가 각 리스트의 끝에 도달 할 때 까지 반복한다.

    public static void main(String[] args){
        EnterAndExitOrder T = new EnterAndExitOrder();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }

    class Employee{
        int num;
        int time;

        public Employee(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
}
