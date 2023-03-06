import java.util.*;

//귤 고르기
public class _0306_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6,new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }
    static class Solution {
        public int solution(int k, int[] tangerine) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int t : tangerine){
                hashMap.put(t, hashMap.getOrDefault(t,0)+1);
            }
            List<Integer> keySet = new ArrayList<>(hashMap.keySet());
            keySet.sort((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));
            System.out.println(keySet);
            int answer = 0;
            while (k > 0){
                Integer key = keySet.get(0);
                k -= hashMap.get(key);
                keySet.remove(key);
                answer += 1;
            }
            return answer;
        }
    }
}
