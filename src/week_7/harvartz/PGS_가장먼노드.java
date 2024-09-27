package week_7.harvartz;

import java.util.*;

public class PGS_가장먼노드 {

    // 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지?
    // 1번 노드로부터 각 노드까지의 거리 = dfs의 깊이, bfs의 무엇?
    // 1번 노드로부터 각 노드까지의 최단 거리를 구하되,
    // 메모리 초과가 뜨는데 어디를 확인해야 하지? -> 인접 배열을 인접 리스트로 변환하자.
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] dist;

    public int solution(int n, int[][] edge) {
        // 초기화하기
        dist = new int[n];
        // -1이라는 것은 아직 방문하지 않았다는 뜻
        Arrays.fill(dist, -1);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 그리기
        for (int i = 0; i < edge.length; i++) {
            int startNode = edge[i][0] - 1;
            int endNode = edge[i][1] - 1;
            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        bfs(0, n);
        int max = Integer.MIN_VALUE;
        int answer = 0;
        // 구한 노드 중에서 가장 멀리 있는 값을 구한다.
        for (int i = 0; i < n; i++) {
            max = Math.max(dist[i], max);
        }

        for (int i = 0; i < n; i++) {
            // 가장 멀리 있는 노드의 개수를 구한다.
            if (max == dist[i]) {
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int node, int n) {
        // 처음 시작 노드는 방문처리를 위해 0으로 초기화
        dist[node] = 0;
        Deque<Integer> qu = new ArrayDeque<>();
        qu.offer(node);
        while (!qu.isEmpty()) {
            int now = qu.poll();
            for (int i : graph.get(now)) {
                if (dist[i] == -1) { // -1은 방문하지 않았다는 뜻
                    dist[i] = dist[now] + 1;
                    qu.offer(i);
                }
            }
        }
    }
}
