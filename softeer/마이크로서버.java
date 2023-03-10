import java.util.*;
import java.io.*;


public class 마이크로서버
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            List<Integer> task = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                task.add(Integer.parseInt(st.nextToken()));
            }
            task.sort(Comparator.naturalOrder());
            int num300 = 0;
            for (int memory : task
            ) {
                if (memory <= 300) num300 += 1;
            }
            int start = num300, servers = 0, end = n - 1;
            while (start <= end){
                servers += 1;
                if (task.get(end) > 600) ;
                else if (start != end && task.get(start) + task.get(end) <= 900) {
                    start += 1;
                } else if (num300 > 0) {
                    num300 -= 1;
                }
                end -= 1;
            }
            servers += (num300+2)/3;
            System.out.println(servers);
        }
    }
}