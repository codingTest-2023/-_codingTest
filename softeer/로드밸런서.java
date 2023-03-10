import java.util.*;
import java.io.*;

public class 로드밸런서 {
    static int N;
    static long K;
    static List<List<Integer>> dag = new ArrayList<>(List.of(new ArrayList<>(List.of(0))));
    static List<Integer> degree = new ArrayList<>();
    static List<Integer> ordering = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();
            while (st.hasMoreTokens()){
                temp.add(Integer.parseInt(st.nextToken()));
            }
            dag.add(temp);
        }
        tSort();
        List<Long> traffic = new ArrayList<>();
        for (int i = 0; i < N + 1; i++){
            traffic.add(0L);
        }
        traffic.set(1,K);
        for (int i = 0; i < N; i++){
            int  node = ordering.get(i);
            long request = traffic.get(node);
            if (dag.get(node).get(0) == 0) continue;
            long quotient = request/dag.get(node).get(0);
            long remainder = request % dag.get(node).get(0);
            for (int j = 1; j < dag.get(node).get(0) + 1; j++){
                int child = dag.get(node).get(j);
                traffic.set(child, traffic.get(child) + quotient);
            }
            for (int j = 1; j < remainder + 1; j++){
                int child = dag.get(node).get(j);
                traffic.set(child, traffic.get(child) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N +1; i++){
            sb.append(traffic.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    public static void degreeCalculator(){
        for (int i = 0; i < N +1; i++){
            degree.add(0);
        }
        for (int i = 1; i < N +1; i++){
            for(int j = 1; j < dag.get(i).get(0) + 1; j++){
                int index = dag.get(i).get(j);
                degree.set(index, degree.get(index) + 1);
            }
        }
    }
    public static void tSort(){
        degreeCalculator();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++){
            if (degree.get(i) == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int node = queue.poll();
            ordering.add(node);
            for (int i = 1; i < dag.get(node).get(0) + 1; i++){
                int child = dag.get(node).get(i);
                degree.set(child, degree.get(child) -1);
                if (degree.get(child) == 0) queue.add(child);
            }
        }
    }
}
