import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42746
//프로그래머스 lv2 가장 큰 수
public class _0411_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{6, 10, 2}));
    }
    static class Solution {
        public String solution(int[] numbers) {
            StringBuilder answer = new StringBuilder();
            String[] str = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                str[i] = String.valueOf(numbers[i]);
            }
            Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
            System.out.println(Arrays.toString(str));
            if (str[0].equals("0")) return "0";
            for (String s : str) {
                answer.append(s);
            }
            return answer.toString();
        }
    }
}
