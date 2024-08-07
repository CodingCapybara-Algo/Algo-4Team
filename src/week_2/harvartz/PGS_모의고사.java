package week_2.harvartz;
import java.util.*;
import java.io.*;

public class PGS_모의고사 {

        public ArrayList<Integer> solution(int[] answers) {
            int[] answer = new int[3];
            int[][] counts = new int[3][];

            counts[0] = new int[]{1,2,3,4,5};
            counts[1] = new int[]{2,1,2,3,2,4,2,5};
            counts[2] = new int[]{3,3,1,1,2,2,4,4,5,5};

            for(int i = 0; i<3; i++){
                int z = 0;
                for(int j = 0; j < answers.length; j++){
                    if(counts[i][z] == answers[j]){
                        answer[i]+=1;
                    }
                    if(z== counts[i].length-1){ // 규칙이 끝나면, 처음부터 다시 시작하기 위해서 변수 값을 0으로 변환해준다.
                        z = 0;
                    }else{
                        z++;
                    }
                }
            }
            // 이렇게 하면 한줄로 간단하게 끝낼 수 있다.
            // 모듈러 연산자를 사용하여
            // if(answer[i] == counts[i][z%5]) scores[i]++;

            ArrayList<Integer> result = new ArrayList<>(); //인덱스를 담은 배열
            int max = Integer.MIN_VALUE;
            // 최댓값을 찾는다.
            // int max = Math.max(score[0], Math.max(score[1], score[2])); // 이런 코드도 존재한다.
            for(int i = 0; i<answer.length; i++){
                max = Math.max(max, answer[i]);
            }
            for(int i = 0; i<answer.length;i++){
                if(max == answer[i]){
                    result.add(i+1); // 사람을 찾는 것이기 때문에 인덱스 + 1을 해준다
                }
            }
            return result;
        }
}
