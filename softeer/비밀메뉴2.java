import java.util.*;
import java.io.*;


public class 비밀메뉴2
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        String[] ans = br.readLine().split(" ");
        String[] cmd = br.readLine().split(" ");
        int[][] res = new int[M][N];
        int max = 0;
        for (int i = 0; i < M; i++){
            Arrays.fill(res[i],0);
        }
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (ans[i].equals(cmd[j])) {
                    if (i == 0 || j == 0) res[i][j] = 1;
                    else res[i][j] = res[i-1][j-1] + 1;
                    max = Math.max(max, res[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}