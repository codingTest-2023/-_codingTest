import java.util.*;

//프로그래머스 우박수열 정적분 lv2
public class _0316_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        public double[] solution(int k, int[][] ranges) {
            double[] answer = {};
            List<Integer> collatz = new ArrayList<>();
            while (k > 1){
                collatz.add(k);
                if (k % 2 == 0){
                    k /= 2;
                    continue;
                }
                k = k * 3 + 1;
            }
            collatz.add(1);
            answer = new double[ranges.length];
            for (int i = 0; i < ranges.length; i++){
                double area = 0;
                int goalX = collatz.size() + ranges[i][1] - 1;
                if(ranges[i][0] > goalX) {
                    answer[i] = -1;
                    continue;
                }

                for(int x = ranges[i][0] ; x < goalX ; x++) {
                    area += (collatz.get(x)+collatz.get(x+1))/2.0D;
                }
                answer[i] = area;
            }
            return answer;
        }
    }
}
