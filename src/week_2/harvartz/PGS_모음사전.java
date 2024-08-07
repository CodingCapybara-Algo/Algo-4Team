package week_2.harvartz;
import java.util.*;
public class PGS_모음사전 {
        static List<String> list = new LinkedList<>();
        static char[] w = {'A', 'E', 'I', 'O', 'U'};
        int answer = 0;
        public int solution(String word) {
            dfs(0, "");
            // 리스트에 모든 경우의 수를 넣었으면 word와 같은 값에 해당핳는 인덱스 값을 정답 변수에 대입한다.
            for(String find : list){
                if(find.equals(word)){
                    answer = list.indexOf(find);
                }
            }
            return answer;
        }

        // 범위가 얼마 되지 않기 때문에 전체 경우의 수를 리스트에 넣는다.
        public void dfs(int level, String str){
            list.add(str);
            if(level == 5){
                return;
            }
            for(int i = 0; i<5; i++){
                dfs(level + 1, str + w[i]);
            }
        }
}
