package week_2.jsm512;

import java.util.*;
public class PSG_전력망을둘로나누기 {
    static class Solution {
        boolean[] check;
        List<Integer>[] list;
        int ans = Integer.MAX_VALUE;
        public int solution(int n, int[][] wires) {
            int answer = -1;
            list = new List[n+1];
            for(int i = 0; i < list.length; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < wires.length; i++){
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }

            // System.out.println(Arrays.toString(list));
            for(int i = 1; i <= n; i++){
                check = new boolean[n+1];
                check[i] = true;
                dfs(1);
                optimal(n);
            }
            answer = ans;
            return answer;
        }
        void dfs(int start){
            for(int i = 0; i < list[start].size(); i++){
                if(!check[list[start].get(i)]){
                    check[list[start].get(i)] = true;
                    dfs(list[start].get(i));
                }

            }
        }
        void optimal(int n){
            int cnt = 1;
            for(int i = 1; i < check.length; i++){
                if(!check[i]) cnt++;
            }
            int tmp = n - cnt; //연결된 전선
            ans = Math.min(ans, Math.abs(tmp - cnt));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,7},{7,8},{7,9}}));
    }
}
