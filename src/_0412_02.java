//https://school.programmers.co.kr/learn/courses/30/lessons/12902
//프로그래머스 lv2 3 x n 타일링
public class _0412_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(8));
    }
    static class Solution {
        final int mod = 1000000007;
        public int solution(int n) {
            if (n < 2) {
                return 0;
            }
            int answer = 0;
            long sum = 1;
            long[] arr = new long[n + 1];
            arr[2] = 3;
            for (int i = 4; i <= n; i = i +2) {
                arr[i] = (arr[i - 2] * 3 + sum * 2) % mod;
                sum = arr[i - 2];
            }
            answer = (int)arr[n];
            return answer;
        }
    }
}
