import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42626
//프로그래머스 lv2 더 맵게
public class _0411_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(List.of(Arrays.stream(scoville).boxed().toArray(Integer[]::new)));
            int n1, n2;
            while (!priorityQueue.isEmpty() && K > priorityQueue.peek()) {
                if (priorityQueue.size() >= 2) {
                    n1 = priorityQueue.poll();
                    n2 = priorityQueue.peek() == null ? 0 : priorityQueue.poll();
                    priorityQueue.add(n1 + n2 * 2);
                    answer += 1;
                }
                else return -1;
            }
            return answer;
        }
    }
}
