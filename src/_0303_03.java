import java.util.*;
// 프로그래머스 시소 짝궁
public class _0303_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {100,180,360,100,270}));

    }
    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            Arrays.sort(weights);
            HashMap<Double, Integer> hashMap = new HashMap<>();
            for (int wI : weights){
                double w = (double) wI;
                if (hashMap.containsKey(w)){
                    answer += hashMap.get(w);
                }
                hashMap.put(w, hashMap.getOrDefault(w,0) + 1);
                hashMap.put(w * 4/3, hashMap.getOrDefault(w * 4/3,0) + 1);
                hashMap.put(w * 3/2, hashMap.getOrDefault(w * 3/2,0) + 1);
                hashMap.put(w * 2,  hashMap.getOrDefault(w * 2,0) + 1);
            }
            return answer;
        }
    }
}
