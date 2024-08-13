package week_2.Shanate;

/*
1st thinking
[i, j]가 있을 때, i, j 중 최댓값이 i로 올 수 있도록 위치. -> i의 최댓값 정하기
i를 기준으로 [i,j]가 정렬이 됐으면 이후 j의 최댓값 정하기
before  [60, 50], [30, 70], [60, 30], [80, 40]
after   [60, 50], [70, 30], [60, 30], [80, 40]
*/

public class PGS_최소직사각형 {
    static int solution(int[][] sizes) {
        int answer = 0;
        int maxi = 0;
        int maxj = 0;

        for (int i = 0; i < sizes.length; i++) {
//            sizes[i][0] = (sizes[i][0] > sizes[i][1]) ? sizes[i][0] : sizes[i][1]; 값이 교체가 안 됨.
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0]; // tmp로 배열 정리
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        for (int i = 0; i < sizes.length; i++) {
            maxi = Math.max(maxi, sizes[i][0]);
        }
        for (int j = 0; j < sizes.length; j++) {
            maxj = Math.max(maxj, sizes[j][1]);
        }

        answer = maxi * maxj;
        return answer;
    }

        public static void main (String[] args) throws Exception {
            int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
            System.out.println(solution(sizes)); // return 4,000

            sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
            System.out.println(solution(sizes)); // return 120

            sizes = new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
            System.out.println(solution(sizes)); // return 133
        }
    }
