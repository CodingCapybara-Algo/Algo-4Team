package week_5.Shanate;

import java.util.HashSet;

public class PGS_폰켓몬 {
    static int solution(int[] nums) {
        int answer = 0;
        int getPokemon = nums.length / 2;
        HashSet<Integer> set = new HashSet<>(); // 중복 원소 버리기 위해서 HashSet 사용

        for(int number : nums) {
            set.add(number); // 여기서 중복 제거
        }

        if(getPokemon >= set.size()) {
            return set.size();
        } else {
            return getPokemon;
        }
//        return answer;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 2, 3};
        System.out.println(solution(nums));
        nums = new int[]{ 3, 3, 3, 2, 2, 4};
        System.out.println(solution(nums));
        nums = new int[]{ 3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums));
    }
}
