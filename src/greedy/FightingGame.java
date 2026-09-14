package greedy;

import java.util.*;

public class FightingGame {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        Map<String, Integer> teamSum = new HashMap<>();
        int totalSum = 0;

        List<Student> stuList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] info = students[i].split(" ");

            int idx = i;
            int power = Integer.parseInt(info[1]);
            String team = info[0];

            Student student = new Student(idx, power, team);
            stuList.add(student);

            teamSum.put(team, 0);
        }

        Collections.sort(stuList, (o1, o2) -> {
            if(o1.power != o2.power) return o1.power - o2.power;

            return o1.team.compareTo(o2.team);
        });

        for(int i = 0; i < n; i++){
            Student student = stuList.get(i);
            int myScore = totalSum - teamSum.get(student.team);
            int cnt = 1;

            answer[student.idx] = myScore;
            teamSum.put(student.team, teamSum.get(student.team) + student.power);

            while(i + 1 < n && student.power == stuList.get(i + 1).power){
                Student next = stuList.get(i + 1);

                if(!student.team.equals(next.team)) myScore = totalSum - teamSum.get(next.team);

                answer[next.idx] = myScore;
                teamSum.put(next.team, teamSum.get(next.team) + next.power);

                student = next;
                cnt++;
                i++;
            }

            totalSum += student.power * cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        FightingGame T = new FightingGame();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }

    class Student{
        int idx;
        int power;
        String team;

        public Student(int idx, int power, String team){
            this.idx = idx;
            this.power = power;
            this.team = team;
        }
    }

    // 1. 각 팀의 공격력 누적합을 저장 할 맵을 만든다.
    // 2. 현재까지 모든 공격력 누적합을 저장 할 변수를 만든다.
    // 3. 학생 정보를 저장 할 클래스를 만들어 모든 학생 정보를 리스트에 저장한다. ( 인덱스, 공격력, 팀을 필드로 가진 클래스 )
    // 4. 3 과정에서 각 팀의 누적합도 함께 초기화한다.
    // 5. 리스트를 학생 공격력 오름차순으로 정렬한다.
    // 6. 리스트의 모든 요소에 대해 아래의 과정 수행한다.
    // 6-1. (총 누적합 - 팀 누적합) 을 자신의 최종 점수로 저장한다.
    // 6-2. 총 누적합과 팀 누적합에 자신의 공격력을 더한다.
    // 7. 최종적으로 각 학생의 최종 점수가 기록된 배열을 반환한다.
}
