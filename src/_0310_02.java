import java.io.*;
import java.util.*;
//프로그래머스 유사 칸토어 비트열
public class _0310_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 4, 17));
    }
    static class Solution {
        public int solution(int n, long l, long r) {
            long answer = r - l + 1;
            for (long i = l - 1; i <= r - 1; i++){
                for (int j = 0; j < n; j++){
                    if ((i/(int)Math.pow(5,j)) % 5 == 2){
                        answer--;
                        break;
                    }
                }
            }
            return (int) answer;
        }
    }
}
