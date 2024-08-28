package week_5.harvartz;
import java.util.*;

public class PGS_완주하지못한선수 {
    // 목적: 완주하지 못한 선수의 이름을 return 하는 것이 목적이다.
    public String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        // 참가자들을 map에 넣고, 동명이인이 있을 수 있으므로 value값에는 이름에 대한 횟수를 넣어준다.
        for(String p : participant){
            // getOrDefault는 해당 key가 없으면 0이고 있으면 Key에 매핑되노 값을 반환한다.
            hashMap.put(p, hashMap.getOrDefault(p,0)+1);
        }

        // 만약 해당 선수가 완주했으면, 해당 선수 이름에 대한 key를 찾아서 -1를 해준다.
        for(String c : completion){
            hashMap.put(c, hashMap.get(c)-1);
        }

        // keySet()을 통해서 Key값을 set자료구조로 반환한다.
        for(String r : hashMap.keySet()){
            // 만약에 해당 key가 0이 아니다? 완주를 하지 못했다는 뜻이다.
            if(hashMap.get(r) != 0){
                answer = r;
            }
        }

        return answer;
    }
}
