package week_6.harvartz;

import java.util.*;

public class PGS_여행경로 {
// 특징 1. 주어진 모든 항공권을 이용해야 한다.
// 특징 2. 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 한다
// 방법 1. 정렬을 먼저 하면 처리가 되는가?
// 방법 2. 도착지를 뽑을 때, 그때마다 다른 도착지의 배열을 정렬해서 뽑으면 되는건가

    class Solution {
        boolean[] visited;
        ArrayList<String> result = new ArrayList<>();

        public String[] solution(String[][] tickets) {
            visited = new boolean[tickets.length];

            dfs(0, "ICN", "ICN", tickets);
            Collections.sort(result); // 여기에서 정렬하면 모든 경우의 수에서 알파벳 순으로 정렬된다.

            String[] answer = result.get(0).split(" ");
            return answer;
        }

        // 백트랙킹 , 문자열이기 때문에  좌료를 찾아서 하나씩 갱신해주는 route라는 매개변수를 사용한다.
        public void dfs(int depth, String start, String route, String[][] tickets) {
            // 1. 탈출 조건
            if (depth == tickets.length) {
                result.add(route);
                return;
            }
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals(start) && !visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                    visited[i] = false; // 백트랙킹을 위해 방문을 해제한다.
                }
            }
        }
    }
}
