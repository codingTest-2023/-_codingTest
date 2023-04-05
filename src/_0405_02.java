//https://school.programmers.co.kr/learn/courses/30/lessons/60058
//프로그래머스 lv2 괄호 변환
public class _0405_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("()))((()"));
    }
    static class Solution {
        public String solution(String p) {
            StringBuilder answer = new StringBuilder();
            if ("".equals(p)) {
                return p;
            }
            int idx = 0, left = 0, right = 0;
            for (char c : p.toCharArray()) {
                if ('(' == c) left += 1;
                else right += 1;
                idx += 1;
                if (left == right) {
                    break;
                }
            }
            String u = p.substring(0,idx);
            String v = p.substring(idx);
            if (isCorrect(u)){
                return u + solution(v);
            }
            answer.append("(");
            answer.append(solution(v));
            answer.append(")");
            u = u.substring(1, u.length() - 1);
            for (char c : u.toCharArray()) {
                if (c == '(') {
                    answer.append(")");
                } else {
                    answer.append("(");
                }
            }
            return answer.toString();
        }
        public boolean isCorrect(String u){
            int cnt = 0;
            for (char c : u.toCharArray()) {
                if (c == '(') cnt += 1;
                else cnt -= 1;
                if (cnt < 0) return false;
            }
            return true;
        }
    }
}
