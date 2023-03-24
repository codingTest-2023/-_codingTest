//프로그래머스 lv2 n^2 배열 자르기
public class _0324_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3,2,5));
    }
    static class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int)(right - left) + 1];
            for (int i = 0; i < answer.length; i++) {
                int y = (int)(left / n + 1);
                int x = (int)(left % n + 1);
                left++;
                answer[i] = Math.max(y, x);
            }

            return answer;
        }
    }
}
