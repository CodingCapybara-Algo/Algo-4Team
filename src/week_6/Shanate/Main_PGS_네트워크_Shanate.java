package week_6.Shanate;

public class Main_PGS_네트워크_Shanate {
    static int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i = 0; i < computers.length; i++) {

        }







        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][] { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };
        System.out.println(solution(n, computers)); // return 2

        n = 3;
        computers = new int[][] { {1, 1, 0}, {1, 1, 0}, {0, 1, 1} };
        System.out.println(solution(n, computers)); // return 1
    }
}
