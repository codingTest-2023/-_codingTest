//https://school.programmers.co.kr/learn/courses/30/lessons/42883
//프로그래머스 lv2 큰 수 만들기
public class _0405_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("1924", 2));
    }
    static class Solution {
        public String solution(String number, int k) {
            String answer = "";
            int idx = 0, max;
            for (int i = 0; i < number.length() - k; i++){
                max  = 0;
                for (int j = idx; j <= k + i; j++) {
                    if (max < number.charAt(j) - '0') {
                        max = number.charAt(j) - '0';
                        idx = j + 1;
                    }
                }
            }
            return answer;
        }
    }
}
