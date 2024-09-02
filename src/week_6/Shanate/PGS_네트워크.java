package week_6.Shanate;

import java.io.*;
import java.util.*;
/*
각 노드가 연결되어 있는지 아닌지를 파악하는 것이 중요.
연결되어 있으면 하나의 네트워크로 보고, 아니라면 네트워크 수가 증가한다.
-> 즉, 방문 처리가 안된 노드가 있을 때 +1이 되는 방식.

*/
public class PGS_네트워크 {

    static int solution(int n, int[][] computers) {
        int answer = 0; // 카운트
        boolean[] v = new boolean[computers.length];

        Arrays.fill(v, false); // 방문 처리 초기화

        for(int i=0; i<computers.length; i++) {
            if(v[i] == false) {
                answer++;
                dfs(i, v, computers);
            }
        }
        return answer;
    }

    static void dfs(int cpu, boolean[] v, int[][] computers) {
        v[cpu] = true; // 방문 표시

        for(int i=0; i<computers.length; i++) {
            if(v[i] == false && computers[cpu][i] == 1){ // 현재 컴퓨터와 연결된 다른 컴퓨터 확인
                dfs(i, v, computers); // 또 다른 컴퓨터와 연결되어 있는지 확인하기 위해 dfs 호출
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][] { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };
        System.out.println(solution(n, computers)); // return 2

        n = 3;
        computers = new int[][] { {1, 1, 0}, {1, 1, 1}, {0, 1, 1} };
        System.out.println(solution(n, computers)); // return 1
    }
}
