package week_5.harvartz;
import java.util.*;

public class PGS_폰켓몬 {
    public int solution(int[] nums) {

        int max = nums.length / 2;

        HashSet<Integer> hset = new HashSet<Integer>();

        for (int n : nums) {
            hset.add(n);
        }

        if (hset.size() > max) {
            return max;
        } else {
            return hset.size();
        }
    }
}
