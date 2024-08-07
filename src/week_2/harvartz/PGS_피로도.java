package week_2.harvartz;
public class PGS_피로도 {
        // 순열 알고리즘을 사용하여 풀었다.
        static boolean[] visited;
        static int size;
        static int result = 0;
        static int max = Integer.MIN_VALUE;

        public int solution(int k, int[][] dungeons) {
            // 던전 크기가 동적이기 때문에 다음과 같이 선언함
            size = dungeons.length;
            visited = new boolean[size];
            recur(0, k, dungeons); // 시작 던전, 현재 피로도, 던전 배열
            return max;
        }

        public void recur(int level, int now, int[][] dungeons){
            for(int i = 0; i<size; i++){
                // 최소 필요 피로도 < 소모 필요도
                if(dungeons[i][0] <= now && !visited[i]){
                    result++; // 결과 값을 증가시킨다.
                    visited[i] = true; // 해당 던전은 방문했기 때문에 방문처리한다.
                    now -= dungeons[i][1]; // 해당 던전을 방문했으므로 던전에 해당하는 소모도를 현재 피로도에서 빼준다.
                    max = Math.max(max, result); // 방문할 때마다 result의 가장 큰 값으로 바꿔준다.

                    recur(level + 1, now, dungeons);
                    // 함수에서 탈출하면 현재의 던전은 방문하지 않은 것이기 때문에 위에서 한 연산을 돌려준다.
                    now += dungeons[i][1];
                    visited[i] = false;
                    result--;
                }
            }
        }
}
