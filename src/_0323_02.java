import java.util.*;
//프로그래머스 lv2 전력망을 둘로 나누기
public class _0323_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }
    static class Solution {
        boolean[][] wires;
        boolean[] visited;
        int min , n;
        public int solution(int n, int[][] wires) {
            this.n = n;
            this.min = n;
            this.wires = new boolean[n + 1][n + 1];
            this.visited = new boolean[n + 1];
            for (int[] wire : wires){
                int x = wire[0], y = wire[1];
                this.wires[x][y] = true;
                this.wires[y][x] = true;
            }
            dfs(1);
            return min;
        }
        public int dfs(int v){
            visited[v] = true;
            int child = 1;
            for (int i = 1; i <= n; i++){
                if (!visited[i] && wires[v][i]){
                    visited[i] = true;
                    child += dfs(i);
                }
            }
            min = Math.min(min, Math.abs(child - (n - child)));
            return child;
        }
    }
}
