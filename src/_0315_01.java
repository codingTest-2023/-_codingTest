import java.util.*;
//프로그래머스 기사단원의 무기 lv 1
public class _0315_01 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            for (int i = 1; i <= number; i++){
                int divisor = getDivisor(i);
                if (divisor > limit) divisor = power;
                answer += divisor;
            }
            return answer;
        }
        public int getDivisor(int n){
            int cnt = 0;
            for (int i = 1; i * i < n; i++){
                if(n == i * i) {
                    cnt += 1;
                    continue;
                }
                if (n % i == 0) cnt += 2;
            }
            return cnt;
        }
    }

}
