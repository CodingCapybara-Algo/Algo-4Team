package week_5.harvartz;
import java.util.*;

public class PGS_전화번호목록 {
    public boolean solution(String[] phone_book) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String x : phone_book){
            hashMap.put(x, 1);
        }

        for(int x = 0; x<phone_book.length; x++){
            for(int y = 1; y<phone_book[x].length(); y++){
                // 문자열의 모든 경우의 수를 확인하여 map에 포함되어 있는지 확인하고
                // 있으면 false 처리를 한다.
                if(hashMap.containsKey(phone_book[x].substring(0,y))){
                    return false;
                }
            }
        }

        return true;
    }
}
