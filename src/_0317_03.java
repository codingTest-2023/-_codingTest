// 프로그래머스 숫자 짝꿍 lv 1
public class _0317_03 {
    public static void main(String[] args) {

    }
    static class Solution {
        public String solution(String X, String Y) {
            StringBuilder answer = new StringBuilder();
            int[] x = {0,0,0,0,0,0,0,0,0,0};
            int[] y = {0,0,0,0,0,0,0,0,0,0};
            for(int i=0; i<X.length();i++){
                x[X.charAt(i)-48] += 1;
            }
            for(int i=0; i<Y.length();i++){
                y[Y.charAt(i)-48] += 1;
            }

            for(int i=9; i >= 0; i--){
                for(int j=0; j<Math.min(x[i],y[i]); j++){
                    answer.append(i);
                }
            }
            if("".equals(answer.toString())){
                return "-1";
            }else if(answer.toString().charAt(0)==48){
                return "0";
            }else {
                return answer.toString();
            }
        }
    }
}
