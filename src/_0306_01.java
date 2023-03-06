import java.io.*;
import java.util.*;


//프로그래머스 택배 배달과 수거하기
public class _0306_01 {

    public static void main(String[] args) {

    }
    static class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int i = n - 1, j = n - 1;
            while (i >= 0 && deliveries[i] <= 0){
                i--;
            }
            while (j >= 0 && pickups[j] <= 0){
                j--;
            }
            while (i >= 0 || j >= 0){
                answer += (Math.max(i, j) + 1) * 2L;
                int cur = cap;
                while (cur > 0 && i >= 0){
                    if (deliveries[i] <= cur){
                        cur -= deliveries[i];
                        deliveries[i] = 0;
                        while (i >= 0 && deliveries[i] == 0) {
                            i--;
                        }
                    }
                    else {
                        deliveries[i] -= cur;
                        cur = 0;
                    }
                }
                cur = cap;
                while (cur > 0 && j >= 0) {
                    if (pickups[j] <= cur) {
                        cur -= pickups[j];
                        pickups[j] = 0;
                        while (j >= 0 && pickups[j] == 0) {
                            j--;
                        }

                    } else {
                        pickups[j] -= cur;
                        cur = 0;
                    }
                }
            }
            return answer;
        }
    }

}
