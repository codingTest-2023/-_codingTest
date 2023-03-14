import java.util.*;

//프로그래머스 연속 부분 수열 합의 개수 lv 2
public class _0314_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{7, 9, 1, 1, 4}));
    }
    static class Solution {
        public int solution(int[] elements) {
            Set<Integer> answer = new HashSet<>();
            for (int i = 0; i < elements.length; i++){
                for (int j = 0; j < elements.length * 2; j++){
                    int sum = 0;
                    for (int k = j; k < (j + i + 1); k++){
                        sum += elements[k % elements.length];
                    }
                    answer.add(sum);
                }
            }
            return answer.size();
        }
    }
}
