package week_6.harvartz;

public class PGS_단어변환 {
    int answer = 0;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String word, String target, String[] words, int depth) {
        // 만약 바꾼 단어가 target과 일치하다? 그러면 바로 return
        if (word.equals(target)) {
            answer = depth;
            return;
        }

        // 1. 바꿀 수 있는 문자가 있는지 문자 배열을 순회한다.
        for (int i = 0; i < words.length; i++) {
            // 방문하지 않았으며 isPossible 함수를 통과한 문자
            if (!visited[i] && isPossible(word, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 단어를 하나만 바꿀 수 있다. 즉, 비교하는 단어들이 2개의 문자는 같고 1개의 문자는 달라야 한다.
    public boolean isPossible(String now, String compare) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != compare.charAt(i)) {
                count++;
            }
        }
        if (count == 1) return true;
        else return false;
    }
}
