import java.util.*;
import java.io.*;


public class 회의실예약
{
    static int N,M;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Map<String,List<Integer>> room = new TreeMap<>();

        for (int i = 0; i < N; i++){
            String name = br.readLine();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 18; j++){
                temp.add(0);
            }
            room.put(name,temp);
        }

        for (int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int start = Integer.parseInt(input[1]), end = Integer.parseInt(input[2]);
            for (int j = start; j < end; j++){
                room.get(name).set(j,1);
            }
        }
        List<String> keySet = new ArrayList<>(room.keySet());
        for (String name : room.keySet()){
            int current = 1;
            List<List<Integer>> temp = new ArrayList<>();
            int sTime = 0, fTime;
            for (int i = 9; i < 18; i++){
                if (current == 1 && room.get(name).get(i) == 0){
                    sTime = i;
                    current = 0;
                } else if (current == 0 && room.get(name).get(i) == 1) {
                    fTime = i;
                    current = 1;
                    temp.add(new ArrayList<>(Arrays.asList(sTime,fTime)));
                }
            }
            if (current == 0){
                temp.add(Arrays.asList(sTime,18));
            }
            sb.append("Room ").append(name).append(":\n");
            if (temp.size() == 0) sb.append("Not available\n");
            else {
                sb.append(temp.size()).append(" available:\n");
                for (List<Integer> time : temp){
                    sb.append(String.format("%02d", time.get(0))).append("-").append(time.get(1)).append("\n");
                }
            }
            if (!name.equals(keySet.get(keySet.size() - 1)))  sb.append("-----\n");
        }
        System.out.println(sb);
    }
}