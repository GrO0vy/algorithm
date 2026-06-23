package dataStructure;

import java.util.*;

public class Dermatology{
    public int solution(int[] laser, String[] enter){
        int answer = 0;

        PriorityQueue<Reservation> reservations = new PriorityQueue<>(Comparator.comparingInt(res -> res.enter));
        PriorityQueue<Reservation> waiting = new PriorityQueue<>(Comparator.comparingInt(res -> res.enter));

        for(int i = 0; i < enter.length; i++){
            String[] details = enter[i].split("\\s+");;
            int time = parseTime(details[0]);
            int type = Integer.parseInt(details[1]);

            reservations.offer(new Reservation(time, laser[type]));
        }

        while(!reservations.isEmpty()){
            Reservation current = null;

            if(!waiting.isEmpty()) current = waiting.poll();
            else current = reservations.poll();

            while(!reservations.isEmpty() && current.enter + current.processTime > reservations.peek().enter){
                waiting.offer(reservations.poll());
            }

            answer = Math.max(answer, waiting.size());
        }

        return answer;
    }

    // 1. 입장 시간과 시술 시간을 가지는 클래스를 만든다.
    // 2. 입장 시간 오름차순으로 정렬된 우선순위 큐를 두 개 만들고 하나는 시술 대기큐, 하나는 남은 예약 목록 큐로 사용한다.
    // 3. 예약 목록 큐에 정보들을 모두 offer 한다.
    // 4. 시술 대기큐에서 한 명을 꺼내 치료하고 대기 큐에서 시술이 완료되는 동안의 예약 목록들을 대기 큐로 옮긴다.
    // 4-1. 4에서 시술 대기큐에 아무도 없다면 예약 목록 큐에서 한 명을 꺼낸 후 치료하고 시술이 완료되는 동안의 예약 목록들을 대기 큐로 옮긴다.
    // 5. 시술시간 동안 쌓인 대기큐 크기를 최대 대기 인원과 비교해서 값을 갱신한다.
    // 6. 최종적으로 계산된 최대 대기 인원을 반환한다.

    private int parseTime(String strTime){
        String[] details = strTime.split(":");

        return Integer.parseInt(details[0]) * 60 + Integer.parseInt(details[1]);
    }

    public static void main(String[] args){
        Dermatology T = new Dermatology();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }

    static class Reservation{
        int enter;
        int processTime;

        public Reservation(int enter, int processTime){
            this.enter = enter;
            this.processTime = processTime;
        }
    }
}
