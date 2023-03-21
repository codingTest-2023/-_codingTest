import java.util.*;
// 프로그래머스 양궁대회 lv2
public class _0321_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3}));

    }
    static class Solution {
        List<Integer> answer;
        List<Integer> info;
        final List<Integer> visited = new ArrayList<>(Collections.nCopies(11,0));
        int n;
        int max = 0, peach = 0, zero_num = 0;
        public List<Integer> solution(int n, int[] info) {
            this.info = new ArrayList<>(List.of(Arrays.stream(info).boxed().toArray(Integer[]::new)));
            this.n = n;

            for (int i = 0; i < 11; i++){
                if (this.info.get(i) != 0){
                    peach += 10 - i;
                }
            }
            dfs(0, n,0, this.peach);
            return max == 0 ? List.of(-1) : answer;
        }
        public void dfs(int v, int n, int lion, int peach){
            if (max < (lion - peach) && n <= 0){
                max = (lion - peach);
                zero_num = check_zero();
                answer = new ArrayList<>(visited);
                return;
            }
            if (max == (lion - peach) && n <= 0){
                int zero_num = check_zero();
                if (this.zero_num > zero_num){
                    answer = new ArrayList<>(visited);
                    this.zero_num = zero_num;
                }
                return;
            }


            for (int i = v; i < 11; i++){
                if (visited.get(i) == 0 && (n > info.get(i))) {
                    visited.set(i, info.get(i) + 1);
                    n -= info.get(i) + 1;
                    lion += (10 - i);
                    peach = info.get(i) == 0 ? peach : peach - (10 - i);

                    dfs(i, n, lion, peach);

                    n += info.get(i) + 1;
                    lion  -= (10 - i);
                    peach = info.get(i) == 0 ? peach : peach + (10 - i);
                    visited.set(i, 0);
                    continue;
                }
                if (max < (lion - peach) && i == 10){
                    visited.set(i, n);
                    n-= n;
                    dfs(i, n, lion, peach);
                    n+= n;
                    visited.set(i, 0);
                }
            }
        }
        public int check_zero(){
            int num = 0;
            for (int i : visited){
                if (i == 0){
                    num += 1;
                }
            }
            return num;
        }
    }
}
