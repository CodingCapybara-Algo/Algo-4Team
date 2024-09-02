package week_6.Shanate;

public class PGS_아이템줍기 {
    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;







        return answer;
    }

    public static void main(String[] args) {
        int[][] rectangle = new int[][] { {1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8} };
        int characterX = 1;    int characterY = 3;    int itemX = 7;     int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 17

        rectangle = new int[][] { {1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7} };
        characterX = 9;    characterY = 7;    itemX = 7;    itemY = 1;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 11

        rectangle = new int[][] { {1, 1, 5, 7} };
        characterX = 1;    characterY = 1;    itemX = 4;    itemY = 7;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 9

        rectangle = new int[][] { {2, 1, 7, 5}, {6, 4, 10, 10} };
        characterX = 3;    characterY = 1;    itemX = 7;    itemY = 10;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 15

        rectangle = new int[][] { {2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6} };
        characterX = 1;    characterY = 4;    itemX = 6;    itemY = 3;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // return 10
    }
}
