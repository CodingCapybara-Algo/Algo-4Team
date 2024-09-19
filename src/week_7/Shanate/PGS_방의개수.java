package week_7.Shanate;

import java.util.ArrayList;
import java.util.HashMap;

public class PGS_방의개수 {

    static int solution(int[] arrows) {
        int answer = 0;
        int minW = 0, maxW = 0, minH = 0, maxH = 0; // 좌표 최소 최대 범위 추적
        int width = 0, height = 0; // 현재 너비와 높이 추적

//        6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0

        for(int i = 0; i < arrows.length; i++) {
            if (arrows[i] == 0 || arrows[i] == 1 || arrows[i] == 7) // 위쪽으로 이동
                height++;
            maxH = Math.max(maxH, height); // 최대 높이 업데이트
            if (arrows[i] == 3 || arrows[i] == 4 || arrows[i] == 5) // 아래쪽으로 이동
                height--;
            minH = Math.min(minH, height); // 최소 높이 업데이트
            if (arrows[i] == 1 || arrows[i] == 2 || arrows[i] == 3) // 오른쪽으로 이동
                width++;
            maxW = Math.max(maxW, width); // 최대 너비 업데이트
            if (arrows[i] == 5 || arrows[i] == 6 || arrows[i] == 7) // 왼쪽으로 이동
                width--;
            minW = Math.min(minW, width); // 최소 너비 업데이트
        }
        int x = maxH, y = -minW; //원점의 위치를 설정
        width = maxW - minW + 1; // 너비
        height = maxH - minH + 1; // 높이

        //좌표 (a,b)가 어떤 좌표와 연결되어있는지
        HashMap<Integer, ArrayList<Integer>> connect = new HashMap<>();
        // 각 노드를 키로 두고, 그 노드 직전의 연결 좌표 저장을 값으로
        connect.put( x*width + y, new ArrayList<>());
        // x*width + y => 2차원 좌표를 1차원 인덱스로 변환
        // 메모리 공간 확보, HashMap에서 좌표를 쉽게 키로 사용할 수 있음
        // index = x * width + y,    width는 2차원 배열의 가로 크기

        // 방문 배열
        boolean[][] visited = new boolean[height][width];
        visited[x][y] = true; //시작점은 이미 지나간거니까 방문으로 설정

        // arrows 배열을 순회하며 좌표를 이동하고 방의 개수를 계산
        for(int i = 0; i < arrows.length; i++) {
            int prev_x = x, prev_y = y; // 이전 좌표를 저장

            // 현재 좌표 업데이트

            if (arrows[i] == 0 || arrows[i] == 1 || arrows[i] == 7)
                x -= 1; // 위쪽으로 이동
            if (arrows[i] == 3 || arrows[i] == 4 || arrows[i] == 5)
                x += 1; // 아래쪽으로 이동
            if (arrows[i] == 1 || arrows[i] == 2 || arrows[i] == 3)
                y += 1; // 오른쪽으로 이동
            if (arrows[i] == 5 || arrows[i] == 6 || arrows[i] == 7)
                y -= 1; // 왼쪽으로 이동

            // 방문하지 않은 점이면 Map에도 해당 노드 추가
            if (!connect.containsKey(x*width + y)) {
                connect.put(x*width+y, new ArrayList<>());
            }
            //해당 노드를 한번 더 방문하고, 이전에 그어지지 않았던 간선이면 방이 생성된다.
            if (visited[x][y] == true) {
                if (connect.get(x*width+y).contains(prev_x*width+prev_y) == false)
                    answer++;
            }
            //대각선 검사 : 교차할때 방 만들어짐, 단 이미 그었던 선은 안됨.
            if (connect.get(x*width+y).contains(prev_x*width+prev_y) == false) {
                if (arrows[i] == 7 && connect.containsKey((x+1)*width+y))
                    if (connect.get((x+1)*width+y).contains(x*width+(y+1)) == true)
                        answer++;
                if (arrows[i] == 5 && connect.containsKey((x-1)*width+y))
                    if (connect.get((x-1)*width+y).contains(x*width+(y+1)) == true)
                        answer++;
                if (arrows[i] == 3 && connect.containsKey((x-1)*width+y))
                    if (connect.get((x-1)*width+y).contains(x*width+(y-1)) == true)
                        answer++;
                if (arrows[i] == 1 && connect.containsKey(x*width+(y-1)))
                    if (connect.get(x*width+(y-1)).contains((x+1)*width+y) == true)
                        answer++;
            }
            if (visited[x][y] == false) {
                visited[x][y] = true;
            }
            // 노드 연결(현재 노드와 이전 노드)
            connect.get(x*width+y).add(prev_x*width+prev_y);
            connect.get(prev_x*width+prev_y).add(x*width+y);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arrows = new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        System.out.println(solution(arrows)); // return 3
    }
}
