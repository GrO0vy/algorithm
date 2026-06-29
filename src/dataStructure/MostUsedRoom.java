package dataStructure;

import java.util.*;

public class MostUsedRoom {
    public int solution(int n, int[][] meetings){
        int answer = 0;

        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<Meeting> inProgress = new PriorityQueue<>(Comparator.comparingInt(Meeting::getEndTime).thenComparingInt(Meeting::getRoomNum));

        for(int i = 0; i < n; i++) availableRooms.offer(i);

        int[] cntUsed = new int[n];

        for(int[] meeting: meetings){
            while(!inProgress.isEmpty() && inProgress.peek().endTime <= meeting[0]){
                Meeting endMeeting = inProgress.poll();
                availableRooms.offer(endMeeting.getRoomNum());
            }

            if(!availableRooms.isEmpty()){
                int roomNum = availableRooms.poll();
                int endTime = meeting[1];

                inProgress.add(new Meeting(roomNum, endTime));
                cntUsed[roomNum]++;

                continue;
            }

            Meeting endMeeting = inProgress.poll();

            int roomNum = endMeeting.roomNum;
            int runningTime = meeting[1] - meeting[0];
            int endTime = Math.max(meeting[0], endMeeting.endTime) + runningTime;

            inProgress.offer(new Meeting(roomNum, endTime));
            cntUsed[roomNum]++;
        }

        for(int i = 0; i < n; i++){
            if(cntUsed[i] > cntUsed[answer]) answer = i;
        }

        return answer;
    }

    // 1. 회의 클래스를 만든다 ( 회의실 번호, 회의 종료시간 )
    // 2. 회의 시작 시간을 기준으로 meetings 정렬
    // 3. 비어 있는 회의실을 저장 할 큐를 만든다 ( 회의실 번호 오름차순 우선순위큐 )
    // 4. 진행 중인 회의를 저장 할 큐를 만든다. ( 회의 종료시간 오름차순 우선순위큐 )
    // 5. 0 ~ n - 1 번까지 비어 있는 회의실 큐에 삽입
    // 6. 비어있는 회의실이 있다면 poll 후 사용 횟수를 1증가 시킨 후 회의 정보를 진행 중 회의 큐에 저장
    // 7. 비어있는 회의실이 없다면 가장 빠르게 종료되는 회의를 하나 종료 시킨 후 6의 과정을 진행한다.
    // 8. 각 회의실을 사용횟수를 비교해서 가장 많이 사용된 회의실 번호를 반환한다.

    public static void main(String[] args){
        MostUsedRoom T = new MostUsedRoom();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
    }

    class Meeting{
        private int roomNum;
        private int endTime;

        public int getRoomNum(){
            return roomNum;
        }

        public int getEndTime(){
            return endTime;
        }

        public Meeting(int roomNum, int endTime){
            this.roomNum = roomNum;
            this.endTime = endTime;
        }
    }
}
