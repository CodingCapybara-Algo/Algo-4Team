package week_2.harvartz;

public class PGS_카펫 {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int row = 0;
            int col = 0;
            // i는 세로
            for(int i = 1; i<= yellow; i++){
                row = yellow / i + 2;   // i층일 때, 가로 = (yellow 가로) / i + 2;
                col = i + 2;       // i층일 때, 세로 = i+2;
                if(row >= col && (yellow + brown) == (row * col)){
                    answer[0] = row;
                    answer[1] = col;
                }
            }
            return answer;
        }
}
