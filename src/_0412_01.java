//https://school.programmers.co.kr/learn/courses/30/lessons/12900
//프로그래머스 lv2 2 x n 타일링
public class _0412_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }
    static class Solution {
        final int mod = 1000000007;
        public int solution(int n) {
            int answer = 0;
            int[] arr = new int[n + 1];
            arr[1] = 1;
            arr[2] = 2;
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 2] + arr[i - 1]) % mod;
            }
            answer = arr[n];
            return answer;
        }
    }
}
