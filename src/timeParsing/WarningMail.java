package timeParsing;
import java.util.*;

public class WarningMail {
    public String[] solution(String[] reports, int time){
        String[] answer = {};

        Map<String, Integer> room = new HashMap<>();
        Map<String, Integer> usingTime = new HashMap<>();

        for(String report: reports){
            String[] log = report.split(" ");
            String name = log[0];
            String t = log[1];
            String type = log[2];

            if(type.equals("in")) room.put(name, parseTime(t));
            else{
                int timeIn = room.get(name);
                int timeOut = parseTime(t);

                usingTime.put(name, usingTime.getOrDefault(name, 0) + timeOut - timeIn);
                room.remove(name);
            }
        }

        List<String> warningUser = new ArrayList<>();
        for(String name: usingTime.keySet()){
            int total = usingTime.get(name);

            if(total > time) warningUser.add(name);
        }

        Collections.sort(warningUser);

        answer = warningUser.toArray(String[]::new);

        return answer;
    }

    private int parseTime(String time){
        String[] timeDetail = time.split(":");

        return Integer.parseInt(timeDetail[0]) * 60 + Integer.parseInt(timeDetail[1]);
    }

    public static void main(String[] args){
        WarningMail T = new WarningMail();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
