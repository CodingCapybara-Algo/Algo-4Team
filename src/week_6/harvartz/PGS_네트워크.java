package week_6.harvartz;

public class PGS_네트워크 {
    int count = 0;
    int[][] network;
    // 노드에 방문했는지 안했는지 확인하는 배열
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, n, computers);
            if(isComplete(visited)) {
                count++;
                return count;
            }
            if(!isComplete(visited)){
                count++;
            }
        }
        return count;
    }

    public void dfs(int start, int size, int[][] computers){
        for(int i = 0; i<size; i++){
            // 연결되어있는지 && 다음 탐색하려는 노드가 방문안했다면
            if(computers[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, size, computers);
            }
        }
    }

    public boolean isComplete(boolean[] visited){
        for(boolean i : visited){
            if(!i) return false;
        }
        return true;
    }
}
