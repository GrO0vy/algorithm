package timeParsing;

import java.util.*;

public class Election {
    public String solution(String[] votes, int k) {
        String answer = " ";

        Map<String, Integer> cntRecommend = new HashMap<>();
        Map<String, List<String>> recommenders = new HashMap<>();

        for(String vote: votes){
            String[] log = vote.split(" ");

            String recommender = log[0];
            String candidate = log[1];

            cntRecommend.put(candidate, cntRecommend.getOrDefault(candidate, 0) + 1);

            recommenders.putIfAbsent(candidate, new ArrayList<>());
            recommenders.get(candidate).add(recommender);
        }

        Map<String, Integer> cntGift = new HashMap<>();

        for(String candidate: cntRecommend.keySet()){
            if(cntRecommend.get(candidate) < k) continue;

            for(String recommender: recommenders.get(candidate)){
                cntGift.put(recommender, cntGift.getOrDefault(recommender, 0) + 1);
            }
        }

        String maxName = "";
        int maxCnt = 0;

        for(String voter: cntGift.keySet()){
            if(cntGift.get(voter) < maxCnt) continue;

            if(maxCnt == cntGift.get(voter) && voter.compareTo(maxName) > 0){
                continue;
            }

            maxName = voter;
            maxCnt = cntGift.get(voter);
        }

        answer = maxName;

        return answer;
    }

    public static void main(String[] args) {
        Election T = new Election();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
