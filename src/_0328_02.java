import java.util.*;

//프로그래머스 lv2 이진 변환 반복하기
public class _0328_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        public List<Integer> solution(String s) {
            int zero_cnt = 0;
            int cnt = 0;
            while (!s.equals("1")) {
                String temp = s.replace("0", "");
                zero_cnt += s.length() - temp.length();
                cnt += 1;
                s = Integer.toBinaryString(temp.length());
            }
            return new ArrayList<>(Arrays.asList(cnt, zero_cnt));
        }
    }
}
