package week_6.Shanate;

import java.io.*;
import java.util.*;

public class PGS_단어변환 {
    static int solution(String begin, String target, String[] words) {
        int answer = 0;




        return answer;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words)); // return 4

        begin = "hit";
        target = "cog";
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words)); // return 0
    }
}
