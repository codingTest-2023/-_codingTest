//프로그래머스 lv2 2개 이하로 다른 비트
public class _0324_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new long[]{2L, 7L}));
    }
    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0){
                    answer[i] = numbers[i] + 1;
                    continue;
                }
                long bit = 1;
                // 가장 오른쪽부터 차례로 n 개의 연속된 1 로 이루어진 비트구하기
                while (true) {
                    if ((numbers[i] & bit) == 0) break;
                    bit *= 2; // 곱하기 2 를 하면 다음 비트로
                }
                bit = bit / 2;
                answer[i] = numbers[i] + bit;
            }
            return answer;
        }

    }

}
