import java.util.*;
//프로그래머스 불량 사용자 lv3
public class _0323_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
    }
    static class Solution {
        String[] banned_id,user_id;
        List<HashSet<String>> ans_list = new ArrayList<>();
        List<List<Boolean>> visited = new ArrayList<>();
        List<List<String>> sanction_id_list;
        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;
            this.user_id = user_id;
            this.banned_id = banned_id;
            sanction_id_list = calculator();
            for (List<String> id_list : sanction_id_list){
                visited.add(new ArrayList<>(Collections.nCopies(id_list.size(), false)));
            }
            dfs(new TreeSet<>(),0);
            System.out.println(sanction_id_list);
            answer = ans_list.size();
            return answer;
        }
        public List<List<String>> calculator(){
            List<List<String>> sanction_id_list = new ArrayList<>();
            List<String > id_list;
            for (String banned : banned_id){
                id_list = new ArrayList<>();
                for (String user : user_id){
                    if (check(user, banned)) {
                        id_list.add(user);
                    }
                }
                sanction_id_list.add(id_list);
            }
            return sanction_id_list;
        }
        public boolean check(String user, String banned){
            if (user.length() != banned.length()) return false;
            for (int i = 0; i < banned.length(); i++){
                if (banned.charAt(i) == '*') continue;
                if (banned.charAt(i) != user.charAt(i)) return false;
            }
            return true;
        }
        public void dfs(TreeSet<String> id_set, int v){
            if (v == sanction_id_list.size()) {
                for (HashSet<String> ans : ans_list){
                    if (ans.containsAll(id_set)) return;
                }
                ans_list.add(new HashSet<>(id_set));
                return;
            }
            for (int j = 0; j < sanction_id_list.get(v).size(); j++){
                if (!visited.get(v).get(j) && !id_set.contains(sanction_id_list.get(v).get(j))){
                    visited.get(v).set(j,true);
                    id_set.add(sanction_id_list.get(v).get(j));

                    dfs(id_set,v + 1);

                    visited.get(v).set(j,false);
                    id_set.remove(sanction_id_list.get(v).get(j));
                }
            }

        }
    }
}
