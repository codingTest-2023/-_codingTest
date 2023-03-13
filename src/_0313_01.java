import java.util.ArrayList;
import java.util.List;

//프로그래머스 가강 까가운 글자 lv 1
public class _0313_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("banana"));
    }
    static class Solution {
        public List<Integer> solution(String s) {
            List<Integer> answer = new ArrayList<>();
            int[] alpha = new int[26];
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (alpha[c - 'a'] == 0){
                    answer.add(-1);
                    alpha[c - 'a'] = i + 1;
                    continue;
                }
                answer.add(i - alpha[c - 'a'] + 1);
                alpha[c - 'a'] =  i + 1;
            }
            return answer;
        }
    }
}
