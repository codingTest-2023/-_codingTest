import java.util.*;

//프로그래머스 lv2 모음사전
public class _0328_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("AAAAE"));
    }
    static class Solution {
        HashMap<String, Integer> alphas = new HashMap<>();
        int count = 0;
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        public int solution(String word) {
            dfs("");
            int answer;
            answer = alphas.get(word);
            return answer;
        }
        public void dfs(String word){
            if (!alphas.containsKey(word)) {
                alphas.put(word, count);
                count += 1;
            }
            if (word.length() == 5){
                return;
            }
            for (int i = 0; i < 5; i++){
                word += alpha[i];
                dfs(word);
                word = word.substring(0,word.length() - 1);
            }
        }
    }
}
