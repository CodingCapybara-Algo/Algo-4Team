package week_5.Shanate;

import java.util.HashMap;

/*
각 종류별 한 가지 의상 착용 가능.
착용을 안 할 수는 있으나(+1) 모두 안 착용하는 경우는 없음.(sum-1)
*/

public class PGS_의상 {
    static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();

        for(String cloth[] : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1); // yellow_hat, blue_sunglasses, green_turban
        }                                                                    // headgear : 2    eyewear : 1
        for(String cloth : map.keySet()){                                    // headgear : 3    eyewear : 2
            answer *= map.get(cloth) + 1;                                    // 3 * 2 = 6
        }
        answer = answer-1;                                                   // 6-1 = 5

        return answer;
    }

    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"},
                                            {"blue_sunglasses", "eyewear"},
                                            {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
        clothes = new String[][]{{"crow_mask", "face"},
                                 {"blue_sunglasses", "face"},
                                 {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }
}
