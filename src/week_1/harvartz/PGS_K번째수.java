package week_1.harvartz;

import java.util.*;

public class PGS_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int x = 0; x< commands.length; x++){
            int i = commands[x][0]-1;
            int j = commands[x][1]-1;
            int k = commands[x][2]-1;
            int[] temp = new int[j-i+1];

            int index = 0;
            for(int y = i; y<=j; y++){
                temp[index++] = array[y];
            }

            Arrays.sort(temp);
            answer[x] = temp[k];
        }
        return answer;
    }
}