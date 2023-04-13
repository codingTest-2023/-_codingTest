//https://school.programmers.co.kr/learn/courses/30/lessons/12905
//프로그래머스 lv2 가장 큰 정사각형 찾기
public class _0413_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }
    static class Solution {
        public int solution(int [][]board)
        {
            int answer = 0;
            int row = board.length;
            int col = board[0].length;
            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                dp[i][0] = board[i][0];
            }
            System.arraycopy(board[0], 0, dp[0], 0, col);
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (board[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    answer = Math.max(answer, dp[i][j]);
                }
            }
            return answer * answer;
        }
    }
}
