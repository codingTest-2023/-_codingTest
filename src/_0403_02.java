import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/68936
//프로그래머스 lv2 쿼드압축 후 개수 세기
public class _0403_02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
    static class Solution {
        public int[] solution(int[][] arr) {
            int[] answer = new int[2];
            int n = arr.length;
            int cnt = 0;
            for (int[] value : arr) {
                for (int j = 0; j < n; j++) {
                    if (value[j] == 1) cnt += 1;
                }
            }
            if (cnt == 0) {
                answer[0] += 1;
                return  answer;
            }
            if (cnt == n *n){
                answer[1] += 1;
                return  answer;
            }
            int[][][] temp = new int[4][n/2][n/2];
            for(int i = 0; i< n/2; i++){
                for (int j = 0; j < n/2; j++){
                    temp[0][i][j] = arr[i][j];
                    temp[1][i][j] = arr[i][j + n/2];
                    temp[2][i][j] = arr[i + n/2][j];
                    temp[3][i][j] = arr[i + n/2][j + n/2];
                }
            }
            for (int[][] ints : temp) {
                int[] ints1 = solution(ints);
                answer[0] += ints1[0];
                answer[1] += ints1[1];
            }
            return answer;
        }
    }
}
