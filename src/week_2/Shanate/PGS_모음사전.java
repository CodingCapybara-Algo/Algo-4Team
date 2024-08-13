package week_2.Shanate;

import java.util.ArrayList;

/*
1st thinking : word의 길이는 1이상 5이하이다. => 각 자리에 들어올 수 있는 경우의 수는 5가지이다.
5 X 5 X 5 X 5 X 5 = 3,125가 이 사전의 총 단어 개수
A -> E가 아니라, A -> AA다.
A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> AAAAO -> AAAAU ->
AAAE -> AAAI -> AAAO -> AAAU -> AAE ...
? 멀리 갔다가 다시 돌아오는데
재귀인가? -> DFS?
를 고려해봐야할거같다.
*/

public class PGS_모음사전 {
        static char[] str = {'A','E','I','O','U'}; // 모음
        static ArrayList<String> dic = new ArrayList<>();

    private static void dfs(String word) {
        if(word.length()> 5) return; // 종료조건.
        dic.add(word);
        for(char vowel : str) {
            //for(int i=0; i<str.length; i++)
            //dfs(word + str[i]);
            dfs(word + vowel);
        }
    }

    static int solution(String word){
        int answer = 0;
        dic.clear();
        dfs("");

        return dic.indexOf(word);
    }

    public static void main(String[] args) throws Exception {

        String word = "AAAAE";
        System.out.println(solution(word));

        word = "AAAE";
        System.out.println(solution(word));

        word = "I";
        System.out.println(solution(word));

        word = "EIO";
        System.out.println(solution(word));

    }
}
