package timeParsing;

import java.util.*;

public class TheftOfDocuments {
    public String[] solution(String[] reports, String times) {
        String[] answer = {};

        String[] targetTime = times.split(" ");
        int start = parseTime(targetTime[0]);
        int end = parseTime(targetTime[1]);

        List<Log> logs = new ArrayList<>();
        for (String report : reports) {
            String[] log = report.split(" ");

            String name = log[0];
            int enterTime = parseTime(log[1]);

            logs.add(new Log(name, enterTime));
        }

        List<Log> targetUser = new ArrayList<>();
        for (Log log : logs) {
            if (start <= log.enterTime && log.enterTime <= end) targetUser.add(log);
        }

        answer = targetUser.stream()
                .sorted(Comparator.comparingInt(o -> o.enterTime))
                .map(log -> log.name)
                .toArray(String[] :: new);

        return answer;
    }

    private int parseTime(String strTime){
        String[] timeDetail = strTime.split(":");

        return Integer.parseInt(timeDetail[0]) * 60 + Integer.parseInt(timeDetail[1]);
    }

    public static void main(String[] args){
        TheftOfDocuments T = new TheftOfDocuments();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

    class Log{
        String name;
        int enterTime ;

        public Log(String name, int enterTime){
            this.name = name;
            this.enterTime = enterTime;
        }
    }
}
