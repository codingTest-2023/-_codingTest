
//프로그래머스 문자열 나누기 lv1
public class _0313_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("banana"
        ));
    }
    static class Solution {
        public int solution(String s) {
            int answer = 0;
            boolean flag = false;
            int cnt = 1;
            char temp = s.charAt(0);
            for (int i = 1; i < s.length(); i++){
                if (flag){
                    temp = s.charAt(i);
                    cnt = 1;
                    flag = false;
                    continue;
                }
                if (temp == s.charAt(i)){
                    cnt += 1;
                    continue;
                }
                cnt -= 1;
                if (cnt == 0){
                    answer += 1;
                    flag = true;
                }
            }
            answer = cnt > 0 ? answer + 1 : answer;
            return answer;
        }
    }
}
