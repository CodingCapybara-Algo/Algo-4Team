package week_5.harvartz;
import java.util.*;

public class PGS_베스트엘범 {
    public static class PlayList{
        int idx;
        int play;

        public PlayList(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }
    public ArrayList<Integer> solution(String[] genres, int[] plays) {

        // 1. 제일 플레이가 많이 된 장르를 찾는다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< genres.length; i++){
            // 같은 장르가 나오면 조회수를 누적해서 더해준다.
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> mapToGenres = new ArrayList<>();
        for(String item : map.keySet()){
            mapToGenres.add(item);
        }
        // 많이 조회가 된 순으로 정렬해준다.
        // 해당 .get()을 통해서 value가 큰 순서대로 정렬한다. 이런식으로도 정렬할 수 있구나
        mapToGenres.sort((o1, o2) -> map.get(o2) - map.get(o1));

        // 2. 장르별로 분리한 뒤 play 순으로 정렬을 하여 결과 값에 넣어준다.
        ArrayList<Integer> answer = new ArrayList<>();
        for(String item : mapToGenres){
            // 장르별로 담을 플레이리스트를 생성한다.
            ArrayList<PlayList> playLists = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                // 만약 탐색하고 있는 장르가 현재 나와야 하는 장르와 같다면?
                if(item.equals(genres[i])){
                    // 플레이 리스트라는 클래스에 고유번호와 조회수를 넣는다.
                    playLists.add(new PlayList(i, plays[i]));
                }
            }

            // 조회수가 같으면 고유 번호 순서대로 출력하자.
            playLists.sort((o1, o2) -> {
                if(o1.play == o2.play){
                    return o1.idx - o2.idx;
                }
                return o2.play - o1.play;
            });

            // 이 부분이 잘 이해가 가지 않네
            // 장르가 1개인 항목도 있고, 2개인 항목도 있으니 조건문을 걸어 2개 이상일 때만 한 개 더 리스트에 add를 한다.
            answer.add(playLists.get(0).idx);
            if(playLists.size() != 1){
                answer.add(playLists.get(1).idx);
            }
        }
        // 장르 내에서 많이 재생된 노래를 먼저 수록
        return answer;
    }
}
