import java.util.*;
public class _0307_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4, 3, 1, 2, 5}));
    }
    static class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int i = 1; i <= order.length; i++){
                if (order[index] != i){
                    stack.add(i);
                    continue;
                }
                index++;
                answer++;
                while (stack.size() > 0 && order[index] == stack.peek()){
                    stack.pop();
                    index++;
                    answer++;
                }
            }
            return answer;
        }
    }
}
