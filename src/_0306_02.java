import java.util.List;

//마법의 엘리베이터
public class _0306_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(545));
    }
    static class Solution {
        public int solution(int storey) {
            int answer = 0;
            while (storey > 0){
                int num1 = storey % 10;
                int num10 = (storey % 100) / 10;
                if (num1 <= 4){
                    answer += num1;
                }
                else if(num1 == 5){
                    if(num10 <= 4){
                        answer += num1;
                    }
                    else {
                        answer += (10 - num1);
                        storey += 10;
                    }
                }
                else {
                    answer += (10 - num1);
                    storey += 10;
                }
                storey /= 10;
            }
            return answer;
        }
    }
}
