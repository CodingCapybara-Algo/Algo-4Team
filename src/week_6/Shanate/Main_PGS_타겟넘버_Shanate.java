package week_6.Shanate;

/*
dfs 구현이 더 쉬우니까 dfs로 구현.
타고 들어가는 depth와 numbers의 길이가 같을 때를 체크.
같지 않으면 depth + 1을 해 dfs 호출

*/

public class Main_PGS_타겟넘버_Shanate {
        static int answer;

    static void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, depth+1, sum+numbers[depth]);
        dfs(numbers, target, depth+1, sum-numbers[depth]);
    }

    static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target)); // return 5

        numbers = new int[]{4, 1, 2, 1};
        target = 4;
        System.out.println(solution(numbers, target)); // return 2
    }
}
