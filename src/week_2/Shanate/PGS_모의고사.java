package week_2.Shanate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1st thinking
학생 1 :  1   2   3   4   5                       반복
학생 2 :  2   1   2   3   2   4   2   5           반복
학생 3 :  3   3   1   1   2   2   4   4   5   5   반복
입력에 따른 정답 갯수 체크해서 비교 후 출력
*/
public class PGS_모의고사 {
        static int[] solution(int[] answers) {
            int[] answer = {};
// --------------------- 찍는 방식 --------------------- //
            int[] stu1 = new int[] {1, 2, 3, 4, 5}; // 5
            int[] stu2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5}; // 8
            int[] stu3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
// ex) answers(7개) :    1   1   2   2   3   3   4
// 반복할 수 있는 장치가 필요
// --------------------- 반복 장치 --------------------- //
            int[] stuAns1 = new int[answers.length];
            int[] stuAns2 = new int[answers.length];
            int[] stuAns3 = new int[answers.length];
        for(int i = 0; i < answers.length; i++) {
            stuAns1[i] = stu1[i%5];
            stuAns2[i] = stu2[i%8];
            stuAns3[i] = stu3[i%10];
        }

// --------------------- 정답 갯수 카운트 --------------------- //
            int ans1 = 0;
            int ans2 = 0;
            int ans3 = 0;
        for(int i = 0; i < answers.length; i++) {
            ans1 = (stuAns1[i] == answers[i]) ? ++ans1 : ans1;
            ans2 = (stuAns2[i] == answers[i]) ? ++ans2 : ans2;
            ans3 = (stuAns3[i] == answers[i]) ? ++ans3 : ans3;
        }
// --------------------- 갯수 비교 --------------------- //

            int maxScore = Math.max(ans1, Math.max(ans2, ans3));
            List<Integer> topScorers = new ArrayList<>();

            if (ans1 == maxScore) topScorers.add(1);
            if (ans2 == maxScore) topScorers.add(2);
            if (ans3 == maxScore) topScorers.add(3);

            answer = new int[topScorers.size()];
            for (int i = 0; i < topScorers.size(); i++) {
                answer[i] = topScorers.get(i);
            }


            return answer;
        }

    public static void main(String[] args) throws Exception {

        int[] answers = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answers))); // return [1]

        answers = new int[] {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers))); // return [1, 2, 3]

    }
}

/*
테스트 1 〉	통과 (0.04ms, 73.7MB)
테스트 2 〉	통과 (0.06ms, 78.1MB)
테스트 3 〉	통과 (0.04ms, 76MB)
테스트 4 〉	통과 (0.06ms, 77.4MB)
테스트 5 〉	통과 (0.05ms, 71.6MB)
테스트 6 〉	통과 (0.05ms, 74.6MB)
테스트 7 〉	통과 (0.54ms, 81MB)
테스트 8 〉	통과 (0.20ms, 83.3MB)
테스트 9 〉	통과 (0.91ms, 80.7MB)
테스트 10 〉	통과 (0.80ms, 75.6MB)
테스트 11 〉	통과 (1.37ms, 71.1MB)
테스트 12 〉	통과 (0.92ms, 76.1MB)
테스트 13 〉	통과 (0.18ms, 77.9MB)
테스트 14 〉	통과 (1.86ms, 75.9MB)
*/
