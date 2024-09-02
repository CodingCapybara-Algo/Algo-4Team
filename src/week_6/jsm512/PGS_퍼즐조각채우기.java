package week_6.jsm512;

import java.util.*;
import java.util.stream.*;
public class PGS_퍼즐조각채우기 {
    static class Solution {
        /*
        마지막 5번 퍼즐은 왜 안채우는거지? => 인접한 칸이 모두 1이어야됨
        최대한 많은 -> dfs? 아닌데? dfs말고 탐색해야되니까 bfs로 가야될듯?
        회전을 어떻게 구현하지?
        1. bfs로 퍼즐의 좌표, 보드에 빈 공간 좌표를 저장
        2. 비교.. -> 회전을 어떻게 처리?
        */
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        ArrayList<List<int[]>> board_list = new ArrayList<>();
        ArrayList<List<int[]>> puzzle_list = new ArrayList<>();

        boolean[][] check_board;
        boolean[][] check_puzzle;
        int answer = 0;
        public int solution(int[][] game_board, int[][] table) {
            int n = game_board.length;
            check_board = new boolean[n][n];
            check_puzzle = new boolean[n][n];

            //퍼즐이 들어갈 수 있는 공간을 0에서 1로 변경
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(game_board[i][j] == 1) game_board[i][j] = 0;
                    else game_board[i][j] = 1;
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0;j < n; j++){
                    if(!check_board[i][j] && game_board[i][j] == 1){
                        bfs(game_board, i, j, check_board, board_list);
                    }
                    if(!check_puzzle[i][j] && table[i][j] == 1){
                        bfs(table, i, j, check_puzzle, puzzle_list);
                    }
                }
            }

            //List에 제대로 들어갔는지 stream으로 확인..개어려움
            // System.out.println(board_list.size() + " " + puzzle_list.size());
//            IntStream.range(0, board_list.size())
//                    .forEach(i -> {
//                        System.out.println("List " + i + ":");
//                        board_list.get(i).stream()
//                                .forEach(arr -> {
//                                    for (int value : arr) {
//                                        System.out.print(value + " ");
//                                    }
//                                    System.out.println();
//                                });
//                        System.out.println("----");
//                    });

            checkSize(board_list, puzzle_list);


            return answer;
        }
        boolean rotation(List<int[]> board, List<int[]> puzzle){
            /*
            회전 비교 => 꽉찬 배열을 두개 만들어서 puzzle을 돌려가면서 비교
            => 배열이 정사각형이 아니면 구현하기 힘들어짐... 그냥 좌표로 풀어야될듯?
            포기포기포기포기포기포기포기포기푀고피ㅗㄱ푀고피괴포기ㅗ피고피ㅗ기포기ㅗ피고피ㅗ기ㅗ피고피
             */


            return false;
        }
        void checkSize(ArrayList<List<int[]>> board, ArrayList<List<int[]>> puzzle){
            /*
            들어갈 공간과 puzzle의 사이즈를 비교해서 size가 같은 공간과 퍼즐이 있다면, rotation을 통해 넣을 수 있는지 판단
             */
            boolean[] check_puzzle = new boolean[puzzle.size()];

            for(int i = 0; i < board.size(); i++){

                List<int[]> cur_board = board.get(i);

                for(int j = 0; j < puzzle.size(); j++){
                    if(!check_puzzle[j] && cur_board.size() == puzzle.get(j).size()){
                        List<int[]> cur_puzzle = puzzle.get(j);

                        if(rotation(cur_board, cur_puzzle)){
                            answer += cur_puzzle.size();
                            check_puzzle[j] = true;
                            break;
                        }
                    }
                }
            }



        }

        void bfs(int[][] maps, int x, int y, boolean[][] check, ArrayList<List<int[]>> p){
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{x,y});
            check[x][y] = true;

            List<int[]> tmp = new ArrayList<>();
            tmp.add(new int[]{x-x,y-y});
            while(!q.isEmpty()){

                int[] now = q.poll();
                int cur_x = now[0];
                int cur_y = now[1];

                for(int i = 0; i < 4; i++){
                    int nx = cur_x + dx[i];
                    int ny = cur_y + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps.length){
                        if(!check[nx][ny] && maps[nx][ny] == 1){
                            check[nx][ny] = true;
                            //이 부분에서 -x,-y를 하면 나중에 0,0기준으로 바꿔주는 로직을 구현 안해도 됨
                            tmp.add(new int[]{nx-x,ny-y});
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        /*
        공간을 저장하는 로직 ex) [[1,1,0],[0,1,0],[0,1,1]]
        -> ㄹ자 공간을 나타냄 1이 ㄹ자 모양 -> 탐색하는 과정에서 시작위치를 빼주면 자동으로 (0,0)기준으로 저장됨
        */
            p.add(tmp); //퍼즐 or 들어갈 공간 좌표 원본 list에 저장
        }
    }
}
