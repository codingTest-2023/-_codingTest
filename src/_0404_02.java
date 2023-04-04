//https://school.programmers.co.kr/learn/courses/30/lessons/49994
//프로그래머스 lv2 방문 길이
public class _0404_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("ULURRDLLU"));
    }
    static class Solution{
        public int solution(String dirs) {
            int answer = 0;
            int x = 0;
            int y = 0;
            boolean[][][][] visited = new boolean[11][11][11][11];
            for (char c : dirs.toCharArray()){
                int nx = x;
                int ny = y;
                if (c == 'U') nx += 1;
                else if (c == 'D') nx -= 1;
                else if (c == 'R') ny += 1;
                else if (c == 'L') ny -= 1;
                if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
                if (!visited[x + 5][y + 5][nx + 5][ny + 5]){
                    visited[x + 5][y + 5][nx + 5][ny + 5] = true;
                    visited[nx + 5][ny + 5][x + 5][y + 5] = true;
                    answer += 1;
                }
                x = nx;
                y = ny;
            }
            return answer;
        }
    }

}
