import java.util.*;

// 프로그래머스 두 큐 합 같게 만들기 lv2
public class _0320_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }
    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            long queue1_sum = Arrays.stream(queue1).reduce(Integer::sum).getAsInt();
            long queue2_sum = Arrays.stream(queue2).reduce(Integer::sum).getAsInt();
            if (queue1_sum == queue2_sum) return 0;

            Deque<Integer> deque1 = new ArrayDeque<>(List.of(Arrays.stream(queue1).boxed().toArray(Integer[] :: new)));
            Deque<Integer> deque2 = new ArrayDeque<>(List.of(Arrays.stream(queue1).boxed().toArray(Integer[] :: new)));
            int cnt_max = (deque1.size() + deque2.size()) * 2;
            int cnt = 0;

            while (cnt < cnt_max) {
                cnt += 1;
                if (queue1_sum > queue2_sum){
                    queue1_sum -= deque1.peek();
                    queue2_sum += deque1.peek();
                    deque2.add(deque1.poll());
                    continue;
                }
                if (queue1_sum < queue2_sum){
                    queue1_sum += deque2.peek();
                    queue2_sum -= deque2.peek();
                    deque1.add(deque2.poll());
                    continue;
                }
                return cnt - 1;
            }
            return -1;
        }
    }
}
