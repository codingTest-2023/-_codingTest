import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//프로그래멋 lv2 삼각 달팽이
//https://school.programmers.co.kr/learn/courses/30/lessons/68645
public class _0329_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6));
    }
    static class Solution {
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int[] n_arr = new int[1001];
        int n;
        int[][] map;
        public List<Integer> solution(int n) {
            List<Integer> answer = new ArrayList<>();
            int nx, ny, x = 0, y = 0, dir = 0;
            this.n = n;
            for (int i = 1; i < 1001; i++) {
                n_arr[i] = n_arr[i - 1] + i;
            }
            map = new int[n][n];
            for (int i = 0; i <= n_arr[n]; i++){
                map[x][y] = i + 1;
                nx = x + dx[dir];
                ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0 || nx < ny){
                    dir = (dir + 1) % 3;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (map[i][j] != 0){
                        answer.add(map[i][j]);
                    }
                }
            }
            System.out.println(Arrays.deepToString(map));
            return answer;
        }
    }
}
