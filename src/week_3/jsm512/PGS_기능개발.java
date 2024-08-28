package week_3.jsm512;

import java.util.*;
public class PGS_기능개발 {
    static class Solution {
        /*
        ArrayList에 값이 있으면 -> list.size > 0
        ArrayList = {93, 30, 55} -> {100, 240, 90}
        -> q에 넣음 -> {100, 240, 90} => 100넘는거 cnt
        cnt 값 answer 배열에 저장 후 cnt 만큼 ArraList remove
        하면 => ArrayList = {90} ->+2 => {100}
        -> q에 넣음 -> {100} => 100 넘는거 cnt(1)
        cnt 값 answer 배열에 저장
        */
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            ArrayList<Integer> list = new ArrayList<>();
        /*
        Queue를 선언하는 두 가지 방법
        https://velog.io/@sweet_sumin/%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C%EB%8A%94-%ED%81%90-%EC%84%A0%EC%96%B8%ED%95%A0%EB%95%8C%EB%8F%84-%EB%91%90%EA%B0%80%EC%A7%80-%EB%B0%A9%EB%B2%95%EC%9D%B4-%EC%9E%88%EC%96%B4%EC%9A%94
        */
            Queue<Integer> q = new ArrayDeque<>();

            //남은 진도를 저장함
            int[] arr = new int[progresses.length];
            for(int i = 0; i < progresses.length; i++){
                arr[i] = 100 - progresses[i]; //7 70 45
            }
            //올림계산
            for(int i = 0; i < progresses.length; i++){
                //7 3 9
                q.offer((int)Math.ceil(arr[i] / speeds[i]));
            }

            while(!q.isEmpty()){
                int day = q.poll();
                int cnt = 0;

                //뒤에가 먼저 끝나 있으면 cnt++
                while(!q.isEmpty() && day >= q.peek()){
                    cnt++;
                    q.poll();
                }

                list.add(cnt+1);
            }
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
//         int sum = 0;
//         while(true){
//             int cnt = 0;
//             if(sum == progresses.length) break;

//             for(int i = sum; i < speeds.length; i++){
//                 progresses[i] += speeds[i];
//             }

//             if(progresses[sum] >= 100){
//                 for(int i = sum; i < progresses.length; i++){
//                     if(progresses[i] >= 100){
//                         cnt++;
//                     }
//                 }
//             }
//             list.add(cnt);
//         }
//         int[] answer = new int[list.size()];
//         for(int i = 0; i < list.size(); i++){
//             answer[i] = list.get(i);
//         }

//         System.out.println(list);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[]progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(s.solution(progresses, speeds))); // return [2, 1]

        progresses = new int[] {95, 90, 99, 99, 80, 99};
        speeds = new int[] {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(s.solution(progresses, speeds)));
    }
}
