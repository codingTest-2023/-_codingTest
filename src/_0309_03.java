import java.util.*;
import java.io.*;
//크기가 작은 부분문자열
public class _0309_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("500220839878", "7"));

    }
    static class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            for (int i = 0; i < t.length() - p.length() + 1; i++){
                for (int j = 0; j < p.length(); j++){
                    int t_int = t.charAt(i + j) - '0', p_int = p.charAt(j) - '0';
                    if (p_int > t_int){
                        answer++;
                    }
                    if (p_int == t_int) {
                        if (j == p.length() -1) answer++;
                        continue;
                    }
                    break;
                }
            }
            return answer;
        }
    }
}
