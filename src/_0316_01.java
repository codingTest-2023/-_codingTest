import java.util.*;
//프로그래머스 리코쳇 로봇 lv2
public class _0316_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
    static class Solution {
        String[] board;
        int startX, startY;
        int endX, endY;
        int boardXLen, boardYLen;
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
        public int solution(String[] board) {
            int answer = 0;
            this.board = board;
            this.boardXLen = board.length;
            this.boardYLen = board[0].length();
            getStartEnd();
            answer = bfs();
            System.out.println(board[0].charAt(6));
            return answer;
        }

        public void getStartEnd(){
            for (int i = 0; i < this.boardXLen; i++){
                for (int j = 0; j < boardYLen; j++){
                    if (board[i].charAt(j) == 'R'){
                        this.startX = i;
                        this.startY = j;
                    }
                    if (board[i].charAt(j) == 'G'){
                        this.endX = i;
                        this.endY = j;
                    }
                }
            }
        }

        public int bfs(){
            int[][] visited = new int[boardXLen][boardYLen];
            for (int i = 0; i < boardXLen; i++){
                Arrays.fill(visited[i],Integer.MAX_VALUE);
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startX,startY,0,-1});
            visited[0][0] = 0;
            while (!queue.isEmpty()){
                int[] current =queue.poll();
                int x = current[0], y = current[1];
                int dis = current[2], dir = current[3];
                if (x == endX && y == endY) return dis;
                for (int i = 0; i < 4; i++){
                    int nx = x + this.dx[i];
                    int ny = y + this.dy[i];

                    if (nx < 0 || nx >= boardXLen || ny < 0 || ny >= boardYLen ) {
                        continue;
                    }
                    if (board[nx].charAt(ny) == 'D') continue;
                    int cost;
                    if (dir != -1 && dir != i){
                        cost = dis + 1;
                    } else {
                        cost = dis;
                    }
                    if (visited[nx][ny] > cost){
                        visited[nx][ny] = cost;
                        queue.offer(new int[]{nx,ny,cost,i});
                    }
                }
            }
            return -1;
        }
    }


}
