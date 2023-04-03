import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/72411
//프로그래머스 lv2 메뉴 리뉴얼
public class _0403_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}));
    }
    static class Solution {
        int max;
        public List<String> solution(String[] orders, int[] course) {
            TreeSet<String> answer = new TreeSet<>();
            for (int c : course) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                max = 0;
                for (String order : orders) {
                    dfs(hashMap, order, c, 0, new TreeSet<>());
                }
                for (String key : hashMap.keySet()){
                    if (hashMap.get(key) == max && max >= 2){
                        answer.add(key);
                    }
                }
                System.out.println(hashMap);
            }
            return new ArrayList<>(answer);
        }
        public void dfs(HashMap<String, Integer> hashMap, String order, int c, int idx, TreeSet<String> str){
            if (str.size() == c){
                String temp = String.join("", str);
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
                max = Math.max(max, hashMap.get(temp));
                return;
            }
            for (int i = idx; i < order.length(); i++){
                str.add(order.charAt(i) + "");
                dfs(hashMap, order, c, i + 1, str);
                str.remove(order.charAt(i) + "");
            }
        }
    }
}
