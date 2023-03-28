import java.util.*;
// 프로그래머스 lv2 거리두기 확인하기
public class _0327_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(	new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
    }
    static class Solution {
        String[] place;
        int[] dx = {-1, 0, 1, 0}, dy = {0,-1,0,1};
        List<Integer> answer = new ArrayList<>();
        public List<Integer> solution(String[][] places) {
            for (int i = 0; i < 5; i++){
                place = places[i];
                getAnswer();
            }
            return answer;
        }
        public void getAnswer(){
            boolean isTrue = false;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        isTrue = bfs(i,j);
                    }
                    if (isTrue) {
                        answer.add(0);
                        return;
                    }
                }
            }
            answer.add(1);
        }
        public boolean bfs(int x, int y){
            Deque<int[]> deque = new ArrayDeque<>();
            deque.offer(new int[]{x, y, 0});
            while (!deque.isEmpty()) {
                int[] cur = deque.poll();
                for (int i = 0; i < 4; i++){
                    int nx = cur[0] + dx[i], ny = cur[1] + dy[i], v = cur[2] + 1;
                    if (nx < 0 || nx > 4 || ny < 0 || ny > 4 || (nx == x && ny == y)) {
                        continue;
                    }

                    if (v > 2 || place[nx].charAt(ny) == 'X') continue;

                    if (place[nx].charAt(ny) == 'P'){
                        return true;
                    }
                    deque.add(new int[] {nx, ny, v});
                }
            }
            return false;
        }
    }
}
