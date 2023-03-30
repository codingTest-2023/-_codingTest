import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/77485
//프로그래머스 lv2 행렬 테두리 회전하기
public class _0330_02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }
    static class Solution {
        static int[][] map;
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            map=new int[rows+1][columns+1];
            int idx=1;
            for(int i=1; i<=rows; i++){
                for(int j=1; j<=columns; j++){
                    map[i][j]=idx++;
                }
            }
            for(int i=0; i<queries.length; i++){

                answer[i]=rotate(queries[i][0],queries[i][1],queries[i][2],queries[i][3]);

            }

            return answer;


        }static int rotate(int x1,int y1,int x2,int y2){
            int x=x1;
            int y=y1;
            int[]dx={0,-1,0,1};
            int[]dy={1,0,-1,0};
            int dir=3;
            int temp=map[x][y];
            int min=temp;
            while(true){
                if(x==x2&&y==y1){
                    dir=0;
                }
                if(x==x2&&y==y2)dir=1;
                if(x==x1&&y==y2)dir=2;
                map[x][y]=map[x+dx[dir]][y+dy[dir]];
                x+=dx[dir];
                y+=dy[dir];
                min=Math.min(map[x][y],min);
                if(x==x1&&y==y1){
                    map[x1][y1+1]=temp;
                    break;
                }
            }

            return min;
        }
    }
}
