//프로그래머스 콜라 문제 lv 1;
public class _0316_03 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            while(n/a>0) {
                answer+=(n/a)*b;
                n=(n/a)*b+n%a;
            }

            return answer;
        }
    }
}
