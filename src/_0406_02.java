import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42747
//프로그래머스 lv2 H-Index
public class _0406_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 0, 6, 1, 5}));
    }
    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);
            for (int i = citations.length - 1; i >= 0; i--){
                if (citations[i] >= citations.length - i){
                    answer = citations.length - i;
                }else{
                    break;
                }
            }
            return answer;
        }
    }
}
