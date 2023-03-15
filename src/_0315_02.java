import java.util.*;

//프로그래머스 과일 장수 lv1
public class _0315_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            for(int i = score.length; i >= m; i -= m){
                answer += score[i - m] * m;
            }

            return answer;
        }
    }
}
