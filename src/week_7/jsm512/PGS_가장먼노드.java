package week_7.jsm512;

import java.util.*;
public class PGS_가장먼노드 {

    static class Solution {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        boolean[] check;
        int answer = 0;
        public int solution(int n, int[][] edge) {

            for(int i = 0; i <= n; i++){
                arr.add(new ArrayList<>());
            }

            //양방향 연결
            for(int i = 0; i < edge.length; i++){
                int a = edge[i][0];
                int b = edge[i][1];
                arr.get(a).add(b);
                arr.get(b).add(a);
            }
            check = new boolean[n+1];

            bfs();

            return answer;
        }

        void bfs(){
            Queue<int[]> q = new ArrayDeque<>();
            //시작노드, depth를 q에 넣음
            q.add(new int[]{1,0});
            check[1] = true;
            int cnt = 0;

            while(!q.isEmpty()){
                int[] now = q.poll();
                int v = now[0];
                int depth = now[1];

                //depth가 cnt와 같으면 => 같은 깊이가 있으먄 answer++
                if(cnt == depth) answer++;
                    //depth가 cnt보다 깊으면 => 최대 깊이가 변경
                else if(cnt < depth){
                    //최대 깊이 재설정 및 answer 초기화
                    cnt = depth;
                    answer = 1;
                }

                for(int i = 0; i < arr.get(v).size(); i++){
                    int w = arr.get(v).get(i);
                    if(!check[w]){
                        q.add(new int[]{w, depth + 1});
                        check[w] = true;
                    }
                }
            }
        }
    }
}
