package week_6.harvartz;

public class PGS_타겟넘버 {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = count;
        return count;
    }

    public void dfs(int[] numbers, int level, int target, int result){
        if(level == numbers.length){
            if(target == result){
                count++;
            }
            return;
        }
        // 현재 레벨까지 더한 수에서 다음 비교하는 수를 더한다.
        int plus = result + numbers[level];
        // 현재 레벨까지 더한 수에서 다음 비교하는 수를 뺀다.
        int minus = result - numbers[level];

        // 위에서 결과가 나온 값에 대해서 dfs를 돌린다.
        dfs(numbers, level+1, target, plus);
        dfs(numbers, level+1, target, minus);
    }
}
