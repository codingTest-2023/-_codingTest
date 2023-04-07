//https://school.programmers.co.kr/learn/courses/30/lessons/42860
//프로그래머스 lv2 조이스틱
public class _0407_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("ZZZ"));
    }
    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int len = name.length();
            int min_move = len - 1;
            for (int i = 0; i < len; i++) {
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
                int next = i + 1;
                while (next < len && name.charAt(next) == 'A') next++;
                min_move = Math.min(min_move, i + len - next + Math.min(i, len - next));
            }
            return answer + min_move;
        }
    }
}
