package week_6.Shanate;

import java.io.*;
import java.util.*;

/*
처음 생각했을 때,
{"hot", "dot", "dog", "lot", "log", "cog"} 이걸 순서대로 가는거라 생각.
그게 아닌, 현재 단어에서 한 알파벳만 제외하고 일치하는 것을 찾아서 가는 것이 목표.
hit에서 hot을 가는 이유는 순서가 그래서 그런 것이 아닌, o 하나만 다르기에 이를 바꿀 수 있어서다.
*/

public class PGS_단어변환 {
    static int answer;
    static boolean[] visited;

    static int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];

        Arrays.fill(visited, false);

        dfs(begin, target, words, 0);
        return answer;
    }

    static void dfs(String cur, String target, String[] words, int depth) {
        if(cur.equals(target)) { // 현재 단어와 타겟 단어 일치 시 종료
            answer = depth;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) { // 중복 방문 제거 처리
                continue;
            }
            int k = 0; // 현재 단어와 찾은 단어 간의 문자 수를 카운팅
            for(int j=0; j<cur.length(); j++){ // 현재 단어와 찾은 문자열 비교
                if(cur.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }
            if(k==cur.length()-1) { // 일치한 문자열 갯수 = 현재 단어에서 한 글자 뺀 경우의 갯수 -> 한 글자만 다를 경우
                visited[i] = true; // 방문 처리
                dfs(words[i], target, words, depth + 1); // 카운팅 증가하고 다음 단어를 찾으러 재귀 호출
                visited[i] = false; // 백트래킹
            }
        } // if 문 조건 불만족 시, for 루프 재실행하여 그 다음 문자열 탐색
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words)); // return 4

        begin = "hit";
        target = "cog";
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words)); // return 0
    }
}
