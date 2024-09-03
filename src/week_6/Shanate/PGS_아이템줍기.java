package week_6.Shanate;

import java.util.*;

public class PGS_아이템줍기 {

    static int[][] map = new int[101][101]; // 좌표 확장
    static int[] di = {0, 1, 0, -1}; // 상 우 하 좌
    static int[] dj = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int answer;

    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        visited = new boolean[101][101];

        mapping(rectangle);


        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;

    }

    static void mapping(int[][] rectangle) {
        for(int[] rect : rectangle) {
            int startI = rect[1] * 2;
            int endI = rect[3] * 2;

            int startJ = rect[0] * 2;
            int endJ = rect[2] * 2;

            for(int i = startI; i <= endI; i++) {
                for(int j = startJ; j <= endJ; j++) {
                    if(i == startI || i == endI || j == startJ || j == endJ) {
                        if(map[i][j] == 2) {
                            continue;
                        }
                        map[i][j] = 1;
                    }
                    else{
                        map[i][j] = 2;
                    }
                }
            }
        }
    }

    static void bfs(int characterX, int characterY, int itemX, int itemY) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY, characterX, 0}); //x , y , step
//        visited[characterY][characterX] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];
            int currentStep = current[2];

            if (currentI == itemY && currentJ == itemX) {
                answer = currentStep/2;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextI = currentI + di[i];
                int nextJ = currentJ + dj[i];

                if(nextI>=1 && nextI <=100 && nextJ>=1 && nextJ <=100)
                {
                    if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                        visited[nextI][nextJ] = true;
                        q.add(new int[]{nextI, nextJ, currentStep + 1});
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        int[][] rectangle = new int[][] { {1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8} };
        int characterX = 1;    int characterY = 3;    int itemX = 7;     int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 17

        rectangle = new int[][] { {1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7} };
        characterX = 9;    characterY = 7;    itemX = 6;    itemY = 1;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 11

        rectangle = new int[][] { {1, 1, 5, 7} };
        characterX = 1;    characterY = 1;    itemX = 4;    itemY = 7;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 9

        rectangle = new int[][] { {2, 1, 7, 5}, {6, 4, 10, 10} };
        characterX = 3;    characterY = 1;    itemX = 7;    itemY = 10;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 15

        rectangle = new int[][] { {2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6} };
        characterX = 1;    characterY = 4;    itemX = 6;    itemY = 3;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 10
    }
}
