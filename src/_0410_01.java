import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42842
//프로그래머스 lv2 카펫
public class _0410_01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(10, 2)));
    }
    static class Solution {
        public int[] solution(int brown, int yellow){
            int[] answer = new int[2];
            int area = brown + yellow;
            int w, h;
            for (int i = 1; i <= area; i++) {
                if (area % i == 0) {
                    w = area / i;
                    h = i;
                    if ((w >= h) && ((w - 2) * (h - 2) == yellow)) {
                        answer[0] = w;
                        answer[1] = h;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
