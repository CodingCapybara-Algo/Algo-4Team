package week_7.Shanate;

import java.util.ArrayDeque;
import java.util.ArrayList;
/*
확정 순위의 개수
노드 간의 순서가 존재. -> 위상 정렬
*/

public class PGS_순위 {
    static int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[n+1]; // 진입차수
        int[] rank = new int[n+1];
        int cnt = 0; // 순위 게산

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 승자-패자 관계 구성
        for(int[] edge : results) {
            graph.get(edge[0]).add(edge[1]); // edge[0] : 승자, edge[1] : 패자
            inDegree[edge[1]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            rank[cur] = ++cnt;

        for(int next : graph.get(cur)) {
            if(--inDegree[next] == 0) {
                queue.offer(next);
            }
        }
    }

        if(cnt < n){
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            boolean canDetermine = true;
            for (int j = 1; j <= n; j++) {
                if (i != j && rank[i] > rank[j]) {
                    canDetermine = false;
                    break;
                }
            }
            if (canDetermine) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] results = new int[][] { {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5} };
        System.out.println(solution(n, results)); // return 2

    }
}
