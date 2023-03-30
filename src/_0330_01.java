import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/76502
//프로그래머스 lv2 괄호 회전하기
public class _0330_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("[](){}"));
    }
    static class Solution {
        public int solution(String s) {
            HashMap<Character, Character> bracket = new HashMap<>();
            bracket.put('(', ')');
            bracket.put('{', '}');
            bracket.put('[', ']');
            int answer = 0;
            for (int i = 0; i < s.length(); i++){
                Stack<Character> stack = new Stack<>();
                String temp = s.substring(i) + s.substring(0, i);
                System.out.println(temp);
                for (int j = 0; j < s.length(); j++){
                    if (bracket.containsKey(temp.charAt(j))){
                        stack.push(temp.charAt(j));
                    }else{
                        if (stack.isEmpty()){
                            answer -= 1;
                            break;
                        }
                        if (bracket.get(stack.peek()) == temp.charAt(j)){
                            stack.pop();
                        }else{
                            break;
                        }
                    }
                }
                if (stack.isEmpty()){
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
