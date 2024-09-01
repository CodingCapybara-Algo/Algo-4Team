package week_6.harvartz;

import java.util.*;

public class PGS_게임맵최단거리 {

    // 목적: 목표거리까지 최단 거리를 구하는 것이 목적
    // 핵심: dfs를 이용하여 현재 위치에서 길이를 하나씩 더해서 다음에 갈 수 있는 다음 위치를 찾는 문제이다

    // 게임 맵의 크기가 유동적이라서 다음과 같이 변수를 지정한다.
    int n;
    int m;
    // 맵의 각 칸의 거리를 나타내는 것이다.
    int[][] dist;
    Queue<int[]> qu = new LinkedList<>(); // dfs를 위한 큐
    // 사방탐색을 위한 좌표 배열
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        // 1. 변수 초기 세팅
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];

        dfs(0, 0, maps);

        // 목적지 좌표의 거리가 0이라면 해당 좌표에 도착하지 않았다는 뜻이니 -1을 리턴한다.
        if (dist[n - 1][m - 1] == 0) return -1;
        // 배열의 특성상 인덱스는 n-1, m-1에 해당하는 좌표를 찾아야 한다.
        return dist[n - 1][m - 1];
    }

    public void dfs(int x, int y, int[][] maps) {
        // 처음 들어간 위치에 대한 거리 초기값을 넣어준다.
        dist[x][y] = 1;
        qu.offer(new int[]{x, y});

        while (!qu.isEmpty()) {
            int[] now = qu.poll();
            // 사방탐색 반복문이다.
            for (int i = 0; i < 4; i++) {
                int d_x = now[0] + dx[i];
                int d_y = now[1] + dy[i];

                // 맵 밖을 벗어나면 안된다는 조건문이다.
                if (0 <= d_x && d_x < n && 0 <= d_y && d_y < m) {
                    // 거리가 0이라면 방문을 하지 않았다는 뜻 && 탐색 좌표의 값이 1이라면 벽이 아니라는 뜻
                    if (dist[d_x][d_y] == 0 && maps[d_x][d_y] == 1) {
                        // 중심 좌표 거리 값에서 +1을 해서 탐색 좌표 거리 값에 대입한다.
                        dist[d_x][d_y] = dist[now[0]][now[1]] + 1;
                        // 그런데 만약 탐색 좌표가 도착지라면? 해당 함수를 리턴한다.
                        if (d_x == n - 1 && d_y == m - 1) {
                            return;
                        }
                        // 그렇지 않다면 큐에 넣어준다.
                        int[] in = new int[]{d_x, d_y};
                        qu.offer(in);
                    }
                }
            }
        }
    }
}
