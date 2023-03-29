import java.util.*;
//프로그래머스 lv2 튜플
//https://school.programmers.co.kr/learn/courses/30/lessons/64065
public class _0329_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }
    static class Solution {
        public List<Integer> solution(String s) {
            List<Integer> res = new ArrayList<>();
            TreeSet<List<Integer>> tupleList = new TreeSet<>(Comparator.comparingInt(List::size));
            String[] tuples = s.split("},");
            for (String t : tuples){
                List<Integer> tuple = new ArrayList<>();
                t = t.replace("{", "");
                t = t.replace("}", "");
                for (String num : t.split(",")){
                    tuple.add(Integer.parseInt(num));
                }
                tupleList.add(tuple);
            }
            System.out.println(tupleList);
            for (List<Integer> tuple : tupleList){
                for (int num : tuple){
                    if (!res.contains(num)){
                        res.add(num);
                    }
                }
            }
            return res;
        }
    }
}
