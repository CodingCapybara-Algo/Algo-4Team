package week_2.harvartz;

public class PGS_최소직사각형 {
        public int solution(int[][] sizes) {
            int answer = 0;
            int max_v = 0;
            int max_h = 0;
            for(int x = 0; x < sizes.length; x++){
                int v = Math.max(sizes[x][0], sizes[x][1]);
                int h = Math.min(sizes[x][0], sizes[x][1]);
                max_v = Math.max(v, max_v);
                max_h = Math.max(h, max_h);
            }
            answer = max_v * max_h;
            return answer;
        }
}
