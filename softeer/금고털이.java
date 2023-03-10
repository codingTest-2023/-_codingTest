import java.util.*;
import java.io.*;


public class 금고털이
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[] mpArr = new int[10001];
        Arrays.fill(mpArr,0);

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            mpArr[Integer.parseInt(st.nextToken())] += m;
        }

        for (int i = 10000; i > 0; i--){
            if (mpArr[i] > w) {
                ans += w * i;
                break;
            }
            ans += mpArr[i] * i;
            w -= mpArr[i];
        }
        System.out.println(ans);


    }
}