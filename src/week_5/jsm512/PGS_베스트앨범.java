package week_5.jsm512;

import java.util.*;
import java.util.stream.*;

public class PGS_베스트앨범 {


    static class Solution {
        /*
        1. 각 장르 별 재생된 총합을 구함
        2. 많이 재생된 장르 순으로 정렬 -> list 자료구조를 사용해 1.에서 생성한 Map의 Value값을 기준으로 내림차순으로 정렬
        3. 각 장르에 속한 음악들을 Plays 기준으로 내림차순 정렬 -> Map<String, Map<Integer, Integer>> 형태의 자료구조를 사용
        4. 각 장르 별 최대 두 개씩 꺼내 answer 배열에 담는다.
        -> TreeMap으로 풀어보기
        */
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();

            //각 장르의 재생 수를 기록
            Map<String, Integer> genre = new HashMap<>();
            for(int i = 0; i < genres.length; i++){
                genre.put(genres[i],genre.getOrDefault(genres[i],0) + plays[i]);
            }

            //장르를 key값으로 모든 음악의 재생 횟수와 index를 저장
            Map<String, Map<Integer, Integer>> music = new HashMap<>();
            for(int i = 0; i < genres.length; i++){
                if(music.containsKey(genres[i])){
                    music.get(genres[i]).put(i,plays[i]);
                }else{
                    Map<Integer, Integer> tmp = new HashMap<>();
                    tmp.put(i, plays[i]);
                    music.put(genres[i],tmp);
                }
            }
            // System.out.println(music);

            //장르들에 대해 재생된 횟수를 기준으로 내림차순 정렬을 해줌 -> stream() 사용
            List<String> genresOrderDesc = genre.keySet().stream() //앞서 생성한 각 장르 별 재생 횟수들을 stream 적용
                    .sorted(Comparator.comparing(s -> genre.get(s)).reversed()) //.sorted 메서드를 사용해서 장르들의 value를 비교해 내림차순으로 정렬해준다.
                    .collect(Collectors.toList()); //toList() 메소드를 사용해 List 형태로 반환


            for(String s : genresOrderDesc){ //정렬된 장르들을 순차적으로 접근
                Map<Integer, Integer> idx_play = music.get(s); //s가 "classic"이면 -> music.get(s)로 반환되는 Map은 => {0=500, 2=150, 3=800} 이다.
                List<Integer> key = idx_play.keySet().stream() //각 장르 별로 Value값인 Map에 들어있는 모든 Key값을 stream 적용
                        .sorted(Comparator.comparing((Integer i) -> idx_play.get(i)).reversed() //재생된 횟수를 기준으로 내림차순 정렬
                                .thenComparing(i -> i)) //재생된 횟수가 같으면 -> index를 기준 오름차순으로 정렬
                        .limit(2) // 각 Key별 그니까, 장르 별로 가져올 수 있는 음악의 수를 2개로 제한해줌
                        .collect(Collectors.toList()); // List로 반환
                // 이때 생성된 List는 => [4,1,3,0]을 가지고 있음
                answer.addAll(key); // List의 모든 값들을 answer로 옮긴다
            }
//         System.out.println(answer);
            return answer.stream().mapToInt(i->i).toArray(); //answer는 List 객체이므로 -> Array로 변환이 필요함 -> mapToInt로 IntStream으로 변환해 toArray() 메소드를 사용
        }
    }
}
