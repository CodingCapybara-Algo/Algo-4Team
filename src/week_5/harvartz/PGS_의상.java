package week_5.harvartz;
import java.util.*;

public class PGS_의상 {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i<clothes.length; i++){
            // 1번은 의상의 종류, 0번은 의상의 이름
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        // HashMap을 순회하기 위해 Iterator 객체를 만들어서 해당 객체에 Collection 객체를 대입한다
        // values() 함수는 Collection 객체로 반환하는 과정이다.
        Iterator<Integer> it = hashMap.values().iterator();
        int answer = 1;
        // 하나씩 순회한다.
        while(it.hasNext()){
            // +1을 해주는 과정은 해당 옷을 입지 않은 경우가 있기 때문이다.
            answer *= it.next().intValue() + 1;
        }

        return answer - 1;
    }
}
