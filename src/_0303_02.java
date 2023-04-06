// 프로그래머스 혼자서 하는 틱택토
public class _0303_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(String[] board) {
            int o = 0, x = 0;
            boolean o_check, x_check;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board[i].charAt(j) ==  'O') o += 1;
                    if (board[i].charAt(j) ==  'X') x += 1;
                }
            }
            o_check = check(board,"OOO");
            x_check = check(board,"XXX");
            if (o_check || x_check){
                if (o_check && x_check) return 0;
                if (o_check && o != x + 1) return 0;
                if (x_check && x != o) return 0;
            }
            else {
                if (o - x > 1 || o >= x) return 0;
            }

            return 1;
        }
        public boolean check(String[] board, String key){
            if (key.equals(board[0])) return true;
            if (key.equals(board[1])) return true;
            if (key.equals(board[2])) return true;

            for (int i = 0; i < 3; i++){
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < 3; j++){
                   temp.append(board[j].charAt(i));
                }
                if (key.equals(temp.toString())) return true;
            }
            StringBuilder temp1 = new StringBuilder();
            StringBuilder temp2 = new StringBuilder();
            for (int i = 0; i < 3; i++){
                temp1.append(board[i].charAt(i));
                temp2.append(board[2 - i].charAt(i));
            }
            if (key.equals(temp1.toString())) return true;
            return key.equals(temp2.toString());
        }
    }

}
