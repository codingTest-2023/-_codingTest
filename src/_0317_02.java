
//프로그래머스 할인 행사 lv2
public class _0317_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        static public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            for(int i=0;i<discount.length-9;i++) {
                int j;
                for(j=0;j<want.length;j++) {
                    int check=0;
                    for(int k=i;k<i+10;k++) {
                        if(discount[k].equals(want[j])) check++;
                    }
                    if(check<number[j]) {
                        break;
                    }
                }
                if(j==want.length) answer ++;
            }
            return answer;
        }
    }
}
