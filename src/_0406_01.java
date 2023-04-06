import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42890
//프로그래머스 lv2 후보키
public class _0406_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));

    }
    static class Solution {
        public int solution(String[][] relation) {
            int answer= 0;
            int row = relation.length;
            int col = relation[0].length;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < col * col; i++) {
                if (isCorrect(relation, i, row, col)){
                    list.add(i);
                }
            }
            list.sort(Comparator.comparing(Integer::bitCount));
            for (int i = 0; i < list.size(); i++) {
                int now = list.get(i);
                if (now == 0) continue;
                for (int j = i + 1; j < list.size(); j++){
                    if ((now & list.get(j)) == now){
                        list.set(j, 0);
                    }
                }
            }
            for (int i : list) {
                if (i != 0) {
                    answer += 1;
                }
            }
            return answer;
        }
        public boolean isCorrect(String[][] relation, int bit, int row, int col){
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < col; j++) {
                    if ((bit & (1 << j)) != 0) {
                        sb.append(relation[i][j]);
                    }
                }
                set.add(sb.toString());
            }
            return set.size() == row;
        }
    }
}
