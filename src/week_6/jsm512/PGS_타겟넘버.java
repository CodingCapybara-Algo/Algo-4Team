package week_6.jsm512;

public class PGS_타겟넘버 {

    static class Solution {
        int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(numbers,target, 0, 0);

            return answer;
        }

        void dfs(int[] numbers, int target, int sum, int depth){
            if(depth == numbers.length){ //모든 원소를 선택했을 때,
                if(sum == target){ //원소의 합이 target의 값과 같다면
                    answer++;
                    return;
                }
            /*
            여러개 중 하나를 선택하는 문제의 경우 -> dfs를 그만큼 만들어준다
            */
            }else{
                dfs(numbers, target, sum-numbers[depth], depth+1);
                dfs(numbers, target, sum+numbers[depth], depth+1);
            }
        }
    }
}
