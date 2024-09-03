package week_6.jsm512;

public class PGS_네트워크 {

    static class Solution {
        /*
        dfs로 연결
        dfs가 한번 작동할 때 answer++해주면 네트워크 형태가 완성됨
        */
        boolean[] check;

        public int solution(int n, int[][] computers) {
            int answer = 0;

            check = new boolean[n];

            //모든 네트워크 탐색
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    dfs(computers, i);
                    answer++;
                }
            }

            return answer;
        }

        void dfs(int[][] computers, int idx) {
            check[idx] = true; //자기 자신을 탐색하지 않기 위해 방문 체크

            for (int i = 0; i < computers.length; i++) {
                //방문한적이 없고, 방문할 수 있는 곳이라면
                if (!check[i] && computers[idx][i] == 1) {
                    check[i] = true;
                    //연결 가능한 모든 네트워크를 연결함
                    dfs(computers, i);
                }
            }
        }
    }
}