//프로그래머스 점찍기
public class _0307_01 {
    public static void main(String[] args) {

    }
    static class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            for (int i = 0; i < d; i+= k){
                long xx = (long) i*i;
                long dd = (long) d*d;
                int distMax = (int) Math.sqrt(dd-xx);
                answer += distMax/k;
            }
            return answer;
        }
    }
}
