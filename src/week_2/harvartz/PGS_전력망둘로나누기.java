package week_2.harvartz;
public class PGS_전력망둘로나누기 {
        // 문제를 잘 확인할 것: 분할한 전력망 네트워크는 트리여야 한다는 조건은 없다.
        // 또한, 트리는 단일 노드로 이루어진 트리라는 개념도 존재한다.
        static int[][] map;
        static boolean[] visited;
        static int aCount;
        static int bCount;
        static int nodeSize;
        static int degreeSize;

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            visited = new boolean[n];
            map = new int[n][n];
            nodeSize = n;
            degreeSize = wires.length;

            // 트리는 무방향(양방향 그래프)
            for(int i = 0; i< degreeSize ; i++){
                int aNode = wires[i][0] - 1;
                int bNode = wires[i][1] - 1;
                map[aNode][bNode] = 1;
                map[bNode][aNode] = 1;
            }

            // 2. DFS 순회 - 끊기고 나서도 순회를 해야하기 때문에 전체 반복문을 돌린다.
            // 연결을 한번씩 끊으면서 두 그래프가 비슷하게 나와야 한다.
            // 단, 끊었을 때 노드가 하나만 있으면 안된다. 트리는 부모 - 자식 간의 관계
            for(int i = 0; i < degreeSize; i++){
                // 두 노드의 연결이 끊겼을 때, 두 그래프를 count한다
                aCount = 0;
                visited = new boolean[nodeSize];

                int aNode = wires[i][0] - 1;
                int bNode = wires[i][1] - 1;

                map[aNode][bNode] = 0;
                map[bNode][aNode] = 0;

                dfs(0);

                // 분할한 네트워크는 두 개뿐이기 때문에 한번만 순회하여, 전체 네트워크에서 현재 순회한 네트워크 수를 빼준다.
                bCount = n - aCount;
                answer = Math.min(answer, Math.abs(aCount - bCount));
                // 절대 값이 작은 값으로 갱신한다. (두 네트워크의 차이를 제일 적게 한다.)

                // 다시 연결해놓는다.
                map[aNode][bNode] = 1;
                map[bNode][aNode] = 1;
            }
            return answer;
        }

        public void dfs(int start){
            visited[start] = true;
            aCount++;
            for(int i = 0; i < nodeSize; i++){
                if(!visited[i] && map[start][i] == 1){
                    dfs(i);
                }
            }
        }
}
