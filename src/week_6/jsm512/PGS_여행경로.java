package week_6.jsm512;

import java.util.*;

public class PGS_여행경로 {
    static class Solution {
        /*
        항상 ICN 공항에서 출력...
        가능한 경로가 2개 이상 -> 알파벳 순서로 return ====> 정렬
        모든 항공권 사용 -> dfs로 배열에 경로 저장하자..

        --> tickets 배열을 정렬하는 경우
        도착 경로 알파벳이 가장 빠른게 마지막 경유지라면 -> 티켓을 모두 사용할 수 없음;;
        정렬로 풀면 안되고 모든 경우의 수를 구한 다음에 정렬해서 출력하면 될 듯?
        */
        boolean[] check;
        ArrayList<String> root;
        public String[] solution(String[][] tickets) {
            String[] answer;
            check = new boolean[tickets.length];
            root = new ArrayList<>();
            //가능한 경로가 2개 이상일 경우 알파벳 순서라니까 정렬

            //매개변수로 tickets 배열, 경로를 저장할 str, 현재 경로인 str, depth를 줌
            dfs(tickets, "ICN", "ICN", 0);

            //알파벳 순으로 가장 빠른 경로를 선택해야되니까 정렬
            Collections.sort(root);

            //정렬된 list에서 0번째 인덱스를 저장
            answer = root.get(0).split(" ");

            return answer;
        }

        void dfs(String[][] tickets, String str, String start, int depth){
            //모든 경로를 경유했으면
            if(depth == tickets.length){
                root.add(str); //list에 경로를 저장
                return;
            }

            for(int i = 0; i < tickets.length; i++){
                //방문한적 없고 && 현재 경로("ICN")와 시작하는 경로가 같다면
                if(!check[i] && start.equals(tickets[i][0])){
                    //백트래킹
                    check[i] = true;
                    dfs(tickets, str+" "+tickets[i][1], tickets[i][1], depth+1);
                    check[i] = false;
                }
            }
        }
    }
}
