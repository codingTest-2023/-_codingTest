import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/67257
//프로그래머스 lv2 수식 최대화
public class _0331_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("100-200*300-500+20"));
    }
    static class Solution {
        HashSet<Character> op = new HashSet<>();
        List<String> op_list = new ArrayList<>();
        List<String> expression_list = new ArrayList<>();
        public long solution(String expression) {
            long answer = 0;
            int idx = 0;
            for (int i = 0; i < expression.length(); i++){
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                    op.add(expression.charAt(i));
                    expression_list.add(expression.substring(idx, i));
                    expression_list.add(expression.charAt(i) + "");
                    idx = i + 1;
                    continue;
                }
                if (i == expression.length() -1){
                    expression_list.add(expression.substring(idx, i + 1));
                }
            }
            System.out.println(op);
            dfs("");
            System.out.println(op_list);
            System.out.println(expression_list);
            for (String op_str : op_list){
                List<String> temp = new ArrayList<>(expression_list);
                for (int i = 0; i < op_str.length(); i++){
                    for (int j = 0; j < temp.size(); j++){
                        if (temp.get(j).equals(op_str.charAt(i) + "")){
                            long a = Long.parseLong(temp.get(j - 1));
                            long b = Long.parseLong(temp.get(j + 1));
                            long c = 0;
                            if (op_str.charAt(i) == '+'){
                                c = a + b;
                            }else if (op_str.charAt(i) == '-'){
                                c = a - b;
                            }else if (op_str.charAt(i) == '*'){
                                c = a * b;
                            }
                            temp.set(j - 1, c + "");
                            temp.remove(j);
                            temp.remove(j);
                            j -= 1;
                        }
                    }
                }
                answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
            }
            return answer;
        }
        public void dfs(String op_str){
            if (op_str.length() >= op.size()){
                if (!op_list.contains(op_str)){
                    op_list.add(op_str);
                }
                return;
            }
            for (char c : op){
                if (!op_str.contains(c + "")){
                    dfs(op_str + c);
                }
            }
        }
    }
}
