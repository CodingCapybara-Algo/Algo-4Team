package week_6.jsm512;

import java.util.*;

public class PGS_아이템줍기 {

    static class Solution {
        /*
        최대 좌표의 값이 그렇게 크지 않으니까(50) -> 배열을 50x50으로 시작해서
        테두리 부분을 이동할 수 있는 경로인 1로 초기화
        => 직사각형 테두리를 1로 초기화 => 다른 직사각형이 들어 왔을 때, 테두리 안에 1이 있으면 0으로
        => bfs로 최단 거리 탐색
        좌표로 주어진 문제를 -> 배열로 바꾸는 과정에서 아직도 헷갈림...........
        */
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int[][] maps = new int[101][101];
        boolean[][] check = new boolean[101][101];
        Queue<int[]> q = new ArrayDeque<>();
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int answer = 0;

            init(rectangle); //이동 경로 설정

            //그래프랑 배열은 x,y가 반대임
            answer = bfs(characterY*2, characterX*2, itemY*2, itemX*2);

            return answer;
        }
        int bfs(int x, int y, int endX, int endY){
            q.offer(new int[]{x,y,0});
            check[x][y] = true;

            while(!q.isEmpty()){
                int[] now = q.poll();
                x = now[0];
                y = now[1];
                int z = now[2];

                //bfs의 종료 조건
                if(x == endX && y == endY){
                    return z / 2;
                }

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps.length){
                        if(!check[nx][ny] && maps[nx][ny] == 1){
                            check[nx][ny] = true;
                            q.offer(new int[]{nx,ny,z+1});
                        }
                    }
                }

            }
            return 0;
        }

        //직사각형 그리는 함수
        void init(int[][] rectangle){

            for(int i = 0; i < rectangle.length; i++){
                //그래프랑 배열이랑 좌료는 x,y가 서로 반대임 + 직사각형의 크기를 2배 해줄거니까 *2 연산
                int sr = rectangle[i][1] * 2;
                int sc = rectangle[i][0] * 2;
                int er = rectangle[i][3] * 2;
                int ec = rectangle[i][2] * 2;


                for(int r = sr; r <= er; r++){
                    for(int c = sc; c <= ec; c++){
                        if(maps[r][c] == 2) continue; //겹치는 직사각형이 들어왔을 때, 그냥 넘어가 갈 수 없는 구역으로 표시
                        maps[r][c] = 2; //범위안의 모든 배열을 2로 초기화
                        //테두리 부분을 갈 수 있는 경로인 1로 초기화
                        if(r == sr || r == er || c == sc || c == ec){
                            maps[r][c] = 1;
                        }
                    }
                }


            }

        }
    }
}
