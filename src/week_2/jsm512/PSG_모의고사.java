package week_2.jsm512;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PSG_모의고사 {
    static class Solution {
        public int[] solution(int[] answers) {
            int[][] person = {
                    {1,2,3,4,5},
                    {2,1,2,3,2,4,2,5},
                    {3,3,1,1,2,2,4,4,5,5}
            };
            int[] sol = new int[3];
            int[] answer = {};

            //1번 수포자 ~ 3번 수포자
            for(int i = 0; i < person.length; i++){
                //맞춘 정답의 수를 저장할 변수
                int cnt = 0;
                //찍는 방법과 정답을 비교할 for문
                for(int j = 0; j < answers.length; j++){
                    // 각 수포자가 찍는 방법을 모두 저장할 수 없으니까
//                 % 주기로 계산해 answers의 모든 원소와 비교할 수 있게 만들어줌
                    if(person[i][j%person[i].length] == answers[j]) cnt++;
                }
                sol[i] = cnt;
            }
            // System.out.println(Arrays.toString(sol));
            // 여기서부터는 index가 중요하지 않음 key를 오름차순으로 정렬하기 위해 TreeMap 사용
            Map<Integer, List<Integer>> map = new TreeMap<>();

            //
            for(int i = 0; i < sol.length; i++){
                List<Integer> list = map.get(sol[i]);
                if(list == null){
                    list = new ArrayList<>();
                    map.put(sol[i],list);
                }
                list.add(i+1);
            }
            Integer lastKey = ((TreeMap<Integer, List<Integer>>) map).lastKey();

            List<Integer> lastList = map.get(lastKey);

            answer = new int[lastList.size()];
            for (int j = 0; j < lastList.size(); j++) {
                answer[j] = lastList.get(j);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,2,3,4,5}));
    }
}
