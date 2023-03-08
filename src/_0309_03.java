import java.io.*;
import java.util.*;
//프로그래머스 카드 뭉치
public class _0309_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"a", "b", "c"}, new String[]{"d", "e"}, new String[]{"b", "c", "d", "e"}));
    }
    static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";
            int c1_index = 0;
            int c2_index = 0;
            for (String g : goal){
                if (g.equals(cards1[c1_index])){
                    c1_index = (c1_index + 1 < cards1.length) ? c1_index + 1 : c1_index;
                }
                else if (g.equals(cards2[c2_index])){
                    c2_index = (c2_index + 1 < cards2.length) ? c2_index + 1 : c2_index;
                }
                else {
                    answer = "No";
                    break;
                }
            }
            return answer;
        }
    }
}
