//https://school.programmers.co.kr/learn/courses/30/lessons/49993
//프로그래머스 lv2 스킬트리
public class _0331_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            char[] skillArr = skill.toCharArray();
            for (String skillTree : skill_trees){
                int idx = 0;
                for (char c : skillTree.toCharArray()){
                    if (idx < skillArr.length && c == skillArr[idx]){
                        idx += 1;
                    }else if (skill.indexOf(c) != -1){
                        answer -= 1;
                        break;
                    }
                }
                answer += 1;
            }
            return answer;
        }
    }
}
