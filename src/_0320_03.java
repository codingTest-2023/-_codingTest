//프로그래머스 k 진수에서 소수 개수 구하기 lv2
public class _0320_03 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            String[] n_string = Integer.toString(n, k).split("0");
            for (String s : n_string) {
                if (check(s)) answer ++;
            }
            return answer;
        }
        public boolean check(String s){
            if ("".equals(s)) return false;
            if ("1".equals(s)) return false;
            long num = Long.parseLong(s);
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
