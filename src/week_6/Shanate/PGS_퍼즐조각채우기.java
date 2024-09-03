package week_6.Shanate;

import java.io.*;
import java.util.*;

public class PGS_퍼즐조각채우기 {
    static int solution(int[][] game_board, int[][] table) {
        int answer = -1;





        return answer;
    }
    public static void main(String[] args) {
        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println(solution(game_board, table)); // return 14

        game_board = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        table = new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};
        System.out.println(solution(game_board, table)); // return 0
    }
}
