package week_2.jsm512;

public class PSG_최소직사각형 {
    static class Solution {
        /*
        가로와 세로 각 max값 구하기
        각 max값에 해당하는 명함을 가로 세로 돌려서 max값과 비교해보기?
        */
        public int solution(int[][] sizes) {
            int answer = 0;

            int x_max = 0;
            int y_max = 0;

            for(int i = 0; i < sizes.length; i++){
                if(sizes[i][0] < sizes[i][1]){
                    int tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }
                x_max = Math.max(x_max, sizes[i][0]);
                y_max = Math.max(y_max, sizes[i][1]);
            }

            answer = x_max * y_max;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
    }
}
