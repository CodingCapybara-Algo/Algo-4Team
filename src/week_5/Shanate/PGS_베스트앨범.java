package week_5.Shanate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PGS_베스트앨범 {
    static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> TotalPlays = new HashMap<>(); // 장르별 비교 -> 먼저 추출할 장르 위한 장치

        HashMap<String, PriorityQueue<int[]>> PlaysInGenres = new HashMap<>(); // 장르 안에서 곡 비교 -> 우선순위 큐 사용

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            TotalPlays.put(genre, TotalPlays.getOrDefault(genre, 0) + plays[i]); // 누적총합
        // 장르가 처음 들어왔을 때, 큐를 생성
            if (!PlaysInGenres.containsKey(genre)) {
        // 재생 횟수 기준으로 내림차순 정렬
                PlaysInGenres.put(genre, new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]));
            }
        // 곡 인덱스와 재생횟수 추가
            PlaysInGenres.get(genre).add(new int[]{i, plays[i]});
        }
        // 장르 재생횟수에 따른 정렬
        ArrayList<String> list = new ArrayList<>(TotalPlays.keySet());
        list.sort((o1, o2) -> TotalPlays.get(o2) - TotalPlays.get(o1));

        ArrayList<Integer> answerList = new ArrayList<>();
        // 정렬된 장르 순으로 곡 선정
        for (String genre : list) {
            PriorityQueue<int[]> songs = PlaysInGenres.get(genre);
            answerList.add(songs.poll()[0]);
        // 두 번째 곡 선정 | 곡이 없을 시에는 스킵
            if(!songs.isEmpty()){
                answerList.add(songs.poll()[0]);
            }
        }

    answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays))); // return [4, 1, 3, 0]

    }
}
