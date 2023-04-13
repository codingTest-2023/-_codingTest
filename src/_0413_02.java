//https://school.programmers.co.kr/learn/courses/30/lessons/12911
//프로그래머스 lv2 다음 큰 숫자
public class _0413_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(78));
    }
    static class Solution {
        public int solution(int n) {
            int answer = 0;
            int cnt = Integer.bitCount(n);
            for (int i = n + 1; i <= 1000000; i++) {
                if (cnt == Integer.bitCount(i)) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
