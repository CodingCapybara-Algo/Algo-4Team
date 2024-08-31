package week_6.harvartz;

public class PGS_네트워크 {
    int count = 0;
    boolean[] visited; // 노드에 방문했는지 안했는지 확인하는 배열

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            // 굳이 함수를 만들어서 모두 방문하지 않은 노드를 확인할 필요가 없다
            // 해당 for문 자체가 그 일을 하기 때문
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
                count++;
            }
        }
        return count;
    }

    public void dfs(int start, int size, int[][] computers) {
        for (int i = 0; i < size; i++) {
            // 연결되어있는지 && 다음 탐색하려는 노드가 방문안했다면
            if (computers[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, size, computers);
            }
        }
    }
}
