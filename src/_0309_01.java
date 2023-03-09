//프로그래머스 둘만의암호
public class _0309_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("zzzzz", "abcde", 5));
    }
    static class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
            boolean[] arr = new boolean[26];
            int count = 0;
            for (int j = 0; j < skip.length(); j++){
                int skip_int = skip.charAt(j) - 'a';
                arr[skip_int] = true;
            }
            for (int i = 0; i < s.length(); i++){
                int s_int = (s.charAt(i) - 'a');
                for (int j = 0; j < index; j++){
                    if (arr[(s_int) % 26]){
                        while (arr[s_int % 26 + 1]) s_int = s_int % 26 + 1;
                    }
                    s_int = (s_int + 1) % 26;
                }
                char s_char =(char) ((s_int % 26) + 'a');
                answer.append(s_char);
            }
            return answer.toString();
        }
    }
}
