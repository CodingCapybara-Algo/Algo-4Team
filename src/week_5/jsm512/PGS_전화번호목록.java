package week_5.jsm512;

import java.util.*;
public class PGS_전화번호목록 {
    static class Solution {
        /*
        접두어 -> startWith
        굳이 해시?를 안써도 될 거 같은디
        해시를 사용하면 이점이 뭐임?
        */
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book);

            for(int i = 0; i < phone_book.length - 1; i++){
                if(phone_book[i+1].startsWith(phone_book[i])) return false;
            }


            return answer;
        }
    }
}
