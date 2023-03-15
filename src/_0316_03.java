//프로그래머스 푸드 파이트 대회 lv 1
public class _0316_03 {
    public static void main(String[] args) {

    }
    static class Solution {
        public String solution(int[] food) {
            String answer = "0";

            for (int i = food.length - 1; i > 0; i--) {
                for (int j = 0; j < food[i] / 2; j++) {
                    answer = i + answer + i;
                }
            }

            return answer;
        }
    }
}
