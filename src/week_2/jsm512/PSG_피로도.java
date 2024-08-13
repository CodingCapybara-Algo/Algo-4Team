package week_2.jsm512;

public class PSG_피로도 {
    static class Solution {
        /*
        최소 피로도 / 소모 피로도
        던전이 요구하는 최소 피로도 <= 현재 피로도
        각 던전은 하루에 한번만 탐험 ->>> dfs(방문탐색)라는 느낌이 오죠?
        최대한 많은 -> 여기서 걍 dfs
        */
        int max_dungeons = 0; //최대로 돌 수 있는 던전을 갱신할 변수
        boolean[] check; //하루에 한번만 탐험 조건을 맞추기위해 방문탐색

        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            check = new boolean[dungeons.length];
            dfs(k,0,dungeons);
            answer = max_dungeons;
            return answer;
        }

        void dfs(int k, int cnt, int[][] dungeons){
            max_dungeons = Math.max(cnt, max_dungeons);

            for(int i = 0; i < dungeons.length; i++){
                if(!check[i] && k >= dungeons[i][0]){
                    check[i] = true;
                    dfs(k-dungeons[i][1], cnt+1, dungeons);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }
}
