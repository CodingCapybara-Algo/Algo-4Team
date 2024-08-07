package week_2.jsm512;

import java.util.*;
public class PSG_소수찾기 {
    static class Solution {
        //numbers의 모든 조합을 저장할 list
        ArrayList<String> list = new ArrayList<>();
        //numbers가 가질 수 있는 최대 길이가 7이니까 그냥 초기화 해버림
        boolean[] check = new boolean[7];
        //중복된 숫자 ex) 11과 011을 거르기 위해 set 자료구조 사용
        Set<Integer> set = new HashSet<>();
        public int solution(String numbers) {
            int answer = 0;

            for(int i = 0; i < numbers.length(); i++){
                //매개변수로는 list담길 문자열, dfs의 깊이, 주어진 numbers 문자열
                dfs("",i+1, numbers);
            }

            // for(int i = 0; i < list.size(); i++){
            //     System.out.println(list.get(i));
            // }

            //list에 담긴 모든 조합들을 Interger로 형변환 해주면서 set을 사용해 중복 제거
            for(int i = 0; i < list.size(); i++){
                set.add(Integer.parseInt(list.get(i)));
            }

            //set 자료구조는 index를 갖고있지 않아 -> Iterator사용해서 접근
            Iterator<Integer> si = set.iterator();
            //set 자료구조에 남아있는 값이 없을 때까지 반복
            while(si.hasNext()){
                //prime_num이라는 메소드를 만들어 소수인지 판단 true면 소수로 판단하고 answer++
                if(prime_num(si.next())) answer++;
            }

            return answer;
        }
        //소수 판단 알고리즘
        boolean prime_num(int num){
            //1 이하의 값은 소수가 아니다 false 리턴
            if(num < 2) return false;
            // 2는 소수이다 true 리턴
            if(num == 2) return true;

            //
            for(int i = 2; i <= Math.sqrt(num); i++) {
                //나누어 떨어지면 소수가 아님 false 리턴
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        void dfs(String str, int depth, String number){
            if(str.length() == depth){
                list.add(str);
                return;
            }

            for(int i = 0; i < number.length(); i++){
                if(!check[i]){
                    check[i] = true;
                    dfs(str+number.charAt(i), depth, number);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("17"));
    }
}
