import java.io.*;
import java.util.*;

public class 성적평균 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> scores = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a,b;
        double ans;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            scores.add(Integer.parseInt(st.nextToken()));
        }
        while (k-- > 0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = 0;
            for (int start = a - 1; start < b; start++){
                ans += scores.get(start);
            }
            sb.append(String.format("%.2f",(ans/(b - a + 1)))).append("\n");
        }
        System.out.println(sb);

    }
}
