import java.util.*;

public class _0307_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(int[] topping) {
            int answer = -1;
            Map<Integer, Integer> map = new Hashtable<>();
            Set<Integer> set = new HashSet<>();
            for (int t : topping){
                map.put(t,map.getOrDefault(t,0) + 1);
            }
            for (int t : topping){
                set.add(t);
                map.put(t, map.get(t) - 1);
                if (map.get(t) <= 0) map.remove(t);
                if (set.size() == map.size()) answer++;
            }
            return answer;
        }
    }
}
