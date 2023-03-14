import java.util.*;
import java.math.*;
//프로그래머스 숫자 카드 나누기 lv 2
public class _0314_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }
    static class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int aGcd = Arrays.stream(arrayA).reduce(this::gcd).getAsInt();
            int bGcd = Arrays.stream(arrayB).reduce(this::gcd).getAsInt();
            int answerA = getAnswer(aGcd, arrayB);
            int answerB = getAnswer(bGcd, arrayA);
            return Math.max(answerA,answerB);
        }
        public int gcd(int a, int b){
            BigInteger num1 = BigInteger.valueOf(a);
            BigInteger num2 = BigInteger.valueOf(b);
            int gcdNum = num1.gcd(num2).intValue();
            return gcdNum == 1 ? b : gcdNum;
        }
        public int getAnswer(int gcd, int[] arr){
            for (int num : arr){
                if (num % gcd == 0){
                    return 0;
                }
            }
            return gcd;
        }
    }
}
