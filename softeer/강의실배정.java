import java.util.*;
import java.io.*;


public class 강의실배정
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> classesList = new ArrayList<>();
        int end = 0, ans = 0;
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] classList = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            classesList.add(classList);
        }
        classesList.sort(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < n; i++){
            if (classesList.get(i)[0] >= end){
                ans += 1;
                end = classesList.get(i)[1];
            }
        }

        System.out.println(ans);
    }
}