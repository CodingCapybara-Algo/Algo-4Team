package week_6.jsm512;

import java.util.*;
public class PGS_게임맵최단거리 {
    static class Solution {
        /*
        최단 거리 문제 -> bfs로 접근
        4방 탐색
        도착하지 못한 경우 -> -1출력 해야되니까 그냥 원본 배열에 cnt을 넣는 식으로 가자
        return maps[n][m];
        */
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        //maps 배열에 누적할 변수
        int cnt = 1;

        Queue<int[]> q = new ArrayDeque<>();

        public int solution(int[][] maps) {

            //방문 체크를 위해 maps의 정보를 사용해 NxM boolean 배열을 만든다.
            boolean[][] check = new boolean[maps.length][maps[0].length];

            //매개변수로 시작위치, 방문 배열, 원본 배열
            bfs(0,0,check, maps);

            //maps에 cnt를 누적 -> maps의 endpoint가 최단거리
            int answer = maps[maps.length-1][maps[0].length-1];
            if(answer == 1){
                return -1;
            }
            return answer;
        }

        void bfs(int x, int y, boolean[][] check, int[][] maps){
            check[x][y] = true;
            maps[x][y] = cnt++;
            q.offer(new int[]{x,y,cnt});
            while(!q.isEmpty()){
                int[] now = q.poll();
                x = now[0];
                y = now[1];
                int z = now[2];
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length){
                        if(!check[nx][ny] && maps[nx][ny] == 1){
                            check[nx][ny] = true;
                            maps[nx][ny] = z;
                            q.offer(new int[]{nx,ny,z+1});
                        }
                    }
                }
            }
        }
    }
}
