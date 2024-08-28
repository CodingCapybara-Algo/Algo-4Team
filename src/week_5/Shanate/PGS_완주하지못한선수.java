package week_5.Shanate;

import java.util.HashMap;

/*
폰켓몬과 다르게 중복 제거하면 안 된다.
무조건 탈락한 한 명을 낙인시킨다.
*/

public class PGS_완주하지못한선수 {
    static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String participants : participant) { // 참가자를 카운팅. 동명이인 가능성을 두고 getOrDefault 사용
            hashMap.put(participants, hashMap.getOrDefault(participants, 0) + 1);
        }
        for (String completions : completion) { // 참가자를 디카운팅. 0이 되면 레이스 완주 성공
            hashMap.put(completions, hashMap.get(completions) - 1);
        }

        for(String key : hashMap.keySet()) { // 완주하지 못한 선수 색출
            if (hashMap.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[] {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        completion = new String[] {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));

    }
}
