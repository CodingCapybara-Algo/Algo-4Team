package week_2.jsm512;

import java.util.*;
public class PSG_전력망을둘로나누기 {
    static class Solution {
        boolean[] check; //방문여부를 기준으로 ans를 갱신할거
        List<Integer>[] list; //이어지는 전선들을 저장할거임 -> index는 해당 전선
        int ans = Integer.MAX_VALUE;
        public int solution(int n, int[][] wires) {
            int answer = -1;
            //전선의 정보를 저장할 list 초기화
            list = new List[n+1];
            for(int i = 0; i < list.length; i++){
                list[i] = new ArrayList<>();
            }
            //양방향으로 이어지게 저장
            for(int i = 0; i < wires.length; i++){
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }

            // System.out.println(Arrays.toString(list));
            //0번 index는 사용하지 않으니까 1번부터 검사
            for(int i = 1; i <= n; i++){
                //1~n까지 가면서 check배열은 계속 초기화 되야됨 -> for문안에 선언
                check = new boolean[n+1];
                //전선이 1부터 n까지 있으니까 i번에서 이어지는 전선을 자름 -> check = true
                check[i] = true;
                //1번 전선부터 시작
                dfs(1);
                //차이가 최소가 되는 값을 뽑을 메소드
                optimal(n);
            }
            answer = ans;
            return answer;
        }

        //모든 전선을 방문하기위해 dfs를 사용 -> bfs도 가능
        void dfs(int start){
            //1번 전선이랑 이어지는 전선들에 대해 dfs수행
            for(int i = 0; i < list[start].size(); i++){
                if(!check[list[start].get(i)]){
                    check[list[start].get(i)] = true;
                    dfs(list[start].get(i));
                }

            }
        }
        void optimal(int n){
            int cnt = 1; //1번 전선을 자를 때 for문안에서 true로 해주기 때문에(원래는 false임) 그래서 cnt의 초기 값은 1
            for(int i = 1; i < check.length; i++){ //1번 전선부터 n번 전선까지
                if(!check[i]) cnt++; //false라면 고립되어 있는거임 -> 그래서 고립된 전선(잘린 index의 전선과 묶인 전선들의 갯수)
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
