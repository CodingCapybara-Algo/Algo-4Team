package week_4;

import java.util.*;

public class PGS_가장큰수 {
    public String solution(int[] numbers) {

        String[] result = new String[numbers.length];

        for(int x=0; x<numbers.length;x++){
            result[x] = String.valueOf(numbers[x]);
        }

        Arrays.sort(result, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });

        if(result[0].equals("0")){
            return "0";
        }

        String answer = "";
        for(String a : result){
            answer += a;
        }
        return answer;
    }
}