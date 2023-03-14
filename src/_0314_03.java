import java.util.*;
//프로그래머스 명예의 전당 (1) lv 1
public class _0314_03 {
    public static void main(String[] args) {

    }
    static class Solution {
        public List<Integer> solution(int k, int[] score) {
            List<Integer> answer = new ArrayList<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
            for (int s : score){
                queue.add(s);
                if (queue.size() > k){
                    queue.poll();
                }
                answer.add(queue.peek());
            }
            return answer;
        }
    }
}
