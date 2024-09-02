package week_6.Shanate;

import java.util.ArrayDeque;

public class PGS_게임맵최단거리 {
    
        static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
        static int[] dy = {0, 1, 0, -1};
        static boolean[][] v;
        
    static int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length; // 행의 수
        int m = maps[0].length; // 열의 수

        v = new boolean[n][m];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int x = current[0];
                int y = current[1];

                // 도착 지점에 도달했는지 확인
                if (x == n - 1 && y == m - 1) {
                    return answer;
                }

                // 상하좌우 이동
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];

                    // 유효한 위치인지, 방문한 적이 없는지, 벽이 아닌지 확인
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && !v[newX][newY] && maps[newX][newY] == 1) {
                        q.add(new int[]{newX, newY});
                        v[newX][newY] = true;
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maps = new int[][] { {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1} };
        System.out.println(solution(maps)); // return 11

        maps = new int[][] { {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1} };
        System.out.println(solution(maps)); // return -1
    }
}
