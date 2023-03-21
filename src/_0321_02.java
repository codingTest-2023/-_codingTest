import java.util.*;
// 프로그래머스 피로도 lv2
public class _0321_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
    static class Solution {
        final List<List<Integer>> dungeons = new ArrayList<>();
        int ans_max = 0;
        List<Boolean> visited;
        public int solution(int k, int[][] dungeons) {
            Arrays.sort(dungeons,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
            for (int[] arr : dungeons){
                this.dungeons.add(List.of(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
            }
            visited = new ArrayList<>(Collections.nCopies(dungeons.length,false));
            dfs(0, k, 0);
            return ans_max;
        }
        public void dfs(int v, int k, int ans){
            if (v == dungeons.size()){
                ans_max = Math.max(ans,ans_max);
                return;
            }
            int min_fatigue, csp_fatigue;
            for (int i = 0; i < dungeons.size(); i++){
                min_fatigue = dungeons.get(i).get(0);
                csp_fatigue = dungeons.get(i).get(1);
                if (!visited.get(i) && k >= min_fatigue){
                    visited.set(i,true);
                    dfs(v + 1, k - csp_fatigue, ans + 1);
                    visited.set(i, false);
                    continue;
                }
                if (!visited.get(i)) {
                    visited.set(i,true);
                    dfs(v + 1, k, ans);
                    visited.set(i, false);
                }
            }
        }
    }
}
