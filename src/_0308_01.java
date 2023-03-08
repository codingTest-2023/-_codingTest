//프로그래머스 바탕화면 정리
public class _0308_01 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = {};
            int min_x = 100, max_x =0, min_y = 100, max_y = 0;
            for (int i = 0; i < wallpaper.length; i++){
                for (int j = 0; j < wallpaper[i].length(); j++){
                    char temp = wallpaper[i].charAt(j);
                    if ('#' == temp){
                        max_y = Math.max(max_y, j);
                        min_y = Math.min(min_y, j);
                        min_x = Math.min(max_x,i);
                        max_x = Math.max(max_x,i);
                    }
                }
            }
            answer = new int[] {min_x,min_y,max_x,max_y};
            return answer;
        }
    }
}
