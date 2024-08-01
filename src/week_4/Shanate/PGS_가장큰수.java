package week_4.Shanate;

import java.util.Arrays;
/* first thinking - Permutation을 사용해 입력에 따른 모든 가지 수를 만들고, collection.sort 사용해서 배열 후 큰 수 출력
* 문제점 -> 입력값이 많아지면 많아질수록, 만들어지는 배열 크기가 장난 아니다. ex) 입력 갯수가 10개 -> 출력 = 10P10
*/
/* second thinking - 순열이 아닌 각 입력값을 compareTo 사용하면 출력을 좀 더 효율적으로 해낼 수 있을거 같음.
*
*/


public class PGS_가장큰수 {         // [6, 10, 2]   -> "6210"
     public String solution(int[] numbers) {
        // 받은 정수를 통해 순열을 만든 후 새 배열에 집어넣은 후, sort
        // return은 문자열로
        String answer = "";

        String[] str = new String[numbers.length]; // 입력 개수만큼 문자열 배열 생성
         for(int i=0; i<numbers.length; i++){
             str[i] = String.valueOf(numbers[i]); // 문자열 배열에 정수형 입력을 문자형 입력으로 변환해 대입
         }

         Arrays.sort(str, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        //compareTo의 return 양수 : 크다 |   0 : 같다  |   음수 : 작다

         StringBuilder sb = new StringBuilder();
         for(String s : str){
             sb.append(s);
         }
        if(sb.charAt(0) == '0') {
            return "0";
        }


        return sb.toString();
        }
    }



//테스트 1  〉	통과 (308.82ms, 115MB)
//테스트 2  〉	통과 (83.20ms, 111MB)
//테스트 3  〉	통과 (207.16ms, 123MB)
//테스트 4  〉	통과 (14.53ms, 90.7MB)
//테스트 5  〉	통과 (176.34ms, 108MB)
//테스트 6  〉	통과 (156.34ms, 126MB)
//테스트 7  〉	통과 (2.21ms, 72.4MB)
//테스트 8  〉	통과 (2.09ms, 78.5MB)
//테스트 9  〉	통과 (1.61ms, 74.3MB)
//테스트 10 〉	통과 (1.78ms, 73.2MB)
//테스트 11 〉	통과 (1.70ms, 80.7MB)
//테스트 12 〉	통과 (1.61ms, 75.7MB)
//테스트 13 〉	통과 (1.84ms, 73.2MB)
//테스트 14 〉	통과 (1.85ms, 76.2MB)
//테스트 15 〉	통과 (1.66ms, 76.4MB)