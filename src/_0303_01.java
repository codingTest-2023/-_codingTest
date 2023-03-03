import java.util.*;
// 프로그래머스 덧칠하기
public class _0303_01 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(int n, int m, int[] section) {
            Stack<Integer> stack = new Stack<>();
            int answer;
            stack.add(section[0]);
            for (int i = 1; i < section.length; i++){
                if (stack.peek() + m < section[i]) {
                    stack.add(section[i]);
                }
            }
            answer = stack.size();
            return answer;
        }
    }
}