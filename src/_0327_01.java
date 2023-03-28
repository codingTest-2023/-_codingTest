import java.util.*;
//프로그래머스 lv2 교점에 별 만들기
public class _0327_01 {
    public static void main(String[] args) {
        int[][] ints = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(new Solution().solution(ints));
    }
    static  class Solution {
        Set<List<Long>> intersection = new HashSet<>();
        Long xMin = Long.MAX_VALUE, xMax = Long.MIN_VALUE;
        Long yMin = Long.MAX_VALUE, yMax = Long.MIN_VALUE;
        public List<String> solution(int[][] line){
            for (int i = 0; i < line.length - 1; i++){
                for (int j = i + 1; j < line.length; j++){
                    getIntersection(line[i], line[j] );
                }
            }
            String[][] map = new String[(int) (yMax - yMin) + 1][(int)(xMax - xMin + 1)];
            for (String[] m : map){
                Arrays.fill(m, ".");
            }
            for (List<Long> star : intersection) {
                int x = (int) (star.get(0) - xMin), y = (int) (yMax - star.get(1));
                map[y][x] = "*";
            }
            List<String> answer = new ArrayList<>();
            for (String[] sArr : map){
                answer.add(String.join("",List.of(sArr)));
            }
            return answer;
        }
        public void getIntersection(int[] line1, int[] line2){
            double a = line1[0], b = line1[1], e = line1[2];
            double c = line2[0], d = line2[1], f = line2[2];
            double denominator = a * d - b * c;
            if (denominator == 0) return;
            double x = (b * f - e * d) / denominator,
            y = (e * c - a * f) / denominator;
            long lx  = (long) x, ly = (long) y;
            if (lx == x && ly == y){
                intersection.add(Arrays.asList(lx,ly));
                xMin = Math.min(xMin, lx); xMax = Math.max(xMax, lx);
                yMin = Math.min(yMin, ly); yMax = Math.max(yMax, ly);
            }
        }
    }
}
