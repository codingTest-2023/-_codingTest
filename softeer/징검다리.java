import java.util.*;
import java.io.*;

public class 징검다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> rocks = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            rocks.add(Integer.parseInt(st.nextToken()));
            dp.add(1);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (rocks.get(i) > rocks.get(j)){
                    dp.set(i,Math.max(dp.get(i),dp.get(j)+1));
                }
            }
        }

        System.out.println(Collections.max(dp));    }
}
