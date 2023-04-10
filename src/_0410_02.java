import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42839
//프로그래머스 lv2 소수 찾기
public class _0410_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("011"));
    }
    static class Solution {
        boolean[] decimal;
        Set<Integer> hashSet = new HashSet<>();
        public int solution(String numbers) {
            int answer;
            decimal = new boolean[(int) Math.pow(10, numbers.length()) + 1];
            getDecimal();
            permutation("", numbers);
            System.out.println(hashSet);
            answer = hashSet.size();
            return answer;
        }
        public void permutation(String prefix, String str) {
            int n = str.length();
            if (!prefix.equals("")) {
                int num = Integer.parseInt(prefix);
                if (!decimal[num] && num > 1) {
                    hashSet.add(num);
                }
            }
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
        public void  getDecimal(){
            for (int i = 2; i < Math.sqrt(decimal.length); i++) {
                if (!decimal[i]){
                    for (int j = i + i; j < decimal.length; j += i) {
                        decimal[j] = true;
                    }
                }
            }
        }
    }

}
