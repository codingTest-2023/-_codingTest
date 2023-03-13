import java.util.*;
//프로그래머스 테이블 해시 함수
public class _0310_03 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{new int[]{2, 2, 6},new int[]{1, 5, 10}, new int[]{4, 2, 9}}, 2,2,3));
    }
    static class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;
            List<List<Integer>> data_new = new ArrayList<>();
            for (int[] d : data){
                data_new.add(List.of(Arrays.stream(d).boxed().toArray(Integer[]::new)));
            }
            data_new.sort((o1, o2) -> o1.get(col - 1) - o2.get(col - 1) == 0 ? o2.get(0) - o1.get(0) : o1.get(col - 1) - o2.get(col - 1));
            System.out.println(data_new);
            for (int i = row_begin - 1; i < row_end; i++){
                int sum = 0;
                int finalI = i + 1;
                sum += data_new.get(i).stream().mapToInt(j -> j % finalI).sum();
                answer ^= sum;
            }
            return answer;
        }
    }
}
