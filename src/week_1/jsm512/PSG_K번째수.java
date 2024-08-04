package week_1.jsm512;

import java.util.*;
public class PSG_K번째수 {
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i = 0; i < commands.length; i++){
                int start = commands[i][0];
                int end = commands[i][1];
                ArrayList<Integer> arr = new ArrayList<>();
                for(int j = start-1; j < end; j++){
                    arr.add(array[j]);
                }
                Collections.sort(arr);
                answer[i] = arr.get(commands[i][2]-1);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3}, {4,4,1}, {1,7,3} }));
    }
}
