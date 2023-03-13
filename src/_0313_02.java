import java.util.*;
// 프로그래머스 디펜스 게임 lv 2

public class _0313_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(	7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }
    static class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            if (k >= enemy.length) return enemy.length;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int e : enemy){
                n -= e;
                answer += 1;
                priorityQueue.add(e);
                if (n < 0){
                    if (k == 0){
                        return answer -= 1;
                    }
                    n = n + priorityQueue.poll();
                    k--;
                }
            }
            return answer;
        }
    }
}
