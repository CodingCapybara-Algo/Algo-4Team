package week_7.jsm512;

public class PGS_순위 {

    static class Solution {
    /*
    순위.. -> 플로이드 와샬?
    0번째 인덱스 이김
    1번째 인덱스 진거
    */
        public int solution(int n, int[][] results) {
            int answer = 0;
            int[][] floyd = new int[n+1][n+1];

            for(int i = 0; i < results.length; i++){
                int a = results[i][0];
                int b = results[i][1];

                //이긴쪽
                floyd[a][b] = 1;
                //진쪽
                floyd[b][a] = -1;
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    for(int k = 1; k <= n; k++){

                        //ex [1][2] == 1 [2][3] == 1 => [1][3] == 1
                        if(floyd[i][k] == 1 && floyd[k][j] == 1){
                            floyd[i][j] = 1;
                            floyd[j][i] = -1;
                        }
                        if(floyd[i][k] == -1 && floyd[k][j] == -1){
                            floyd[i][j] = -1;
                            floyd[j][i] = 1;
                        }
                    }
                }
            }

            //행에 0의 개수가 n-1이면 순위가 정해짐
            for(int i = 1; i <= n; i++){
                int cnt = 0;
                for(int j = 1; j <= n; j++){
                    if(floyd[i][j] != 0) cnt++;
                }
                if(cnt == n-1) answer++;
            }

            return answer;
        }
    }
}
