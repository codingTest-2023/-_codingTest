import java.util.*;
//프로그래머스 대충만든 자판
public class _0308_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"}));
    }
    static class Solution {
        public List<Integer> solution(String[] keymap, String[] targets) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < targets.length; i++){
                answer.add(0);
            }
            for (String key : keymap){
                for (int i = 0; i < key.length(); i++){
                    char alpha = key.charAt(i);
                    hashMap.put(alpha, Math.min(hashMap.getOrDefault(alpha, i + 1),i + 1));
                }
            }
            for (int i = 0; i < targets.length; i++){
                for (int j = 0; j < targets[i].length(); j++){
                    char alpha = targets[i].charAt(j);
                    if (hashMap.containsKey(alpha)) answer.set(i,answer.get(i) + hashMap.get(alpha));
                    else {
                        answer.set(i, -1);
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
