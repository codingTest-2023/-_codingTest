import java.util.*;
import java.io.*;


public class 좌석관리
{
    static int N,M,Q;
    static List<ID> ID_LIST = new ArrayList<>();
    static List<List<Integer>> TABLE = new ArrayList<>();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++){
            ID_LIST.add(new ID());
        }
        for (int i = 0; i < N + 2; i++){
            TABLE.add(new ArrayList<>());
            for (int j = 0; j < M + 2 ; j++){
                TABLE.get(i).add(0);
            }
        }

        for (int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            String inOut = (st.nextToken());
            int pid = Integer.parseInt(st.nextToken());
            int idNum = ID_LIST.get(pid).num;

            if("In".equals(inOut)) {
                if (idNum == 0){
                    if (assign(pid)){
                        int x  = ID_LIST.get(pid).dist.get(0), y = ID_LIST.get(pid).dist.get(1);
                        sb.append(pid).append(" gets the seat (").append(x).append(", ").append(y).append(")\n");
                    }

                    else
                        sb.append("There are no more seats.\n");
                }
                else if (idNum == 1) {
                    sb.append(pid).append(" already ate lunch.\n");
                }
                else
                    sb.append(pid).append(" already seated.\n");
            }
            else
            if (idNum == 0){
                sb.append(pid).append(" didn't eat lunch.\n");
            } else if (idNum == 1) {
                sb.append(pid).append(" already left seat.\n");
            }
            else{
                sb.append(pid).append(" leaves from the seat (").append(ID_LIST.get(pid).dist.get(0)).append(", ").append(ID_LIST.get(pid).dist.get(1)).append(")\n");
                TABLE.get(ID_LIST.get(pid).dist.get(0)).set(ID_LIST.get(pid).dist.get(1), 0);
                ID_LIST.get(pid).num = 1;
            }
        }
        System.out.println(sb);
    }
    private static boolean assign(int pid) {
        int maxD = 0;
        int x = ID_LIST.get(pid).dist.get(0), y = ID_LIST.get(pid).dist.get(1);
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < M + 1; j++){
                if (TABLE.get(i).get(j) == 0 && TABLE.get(i - 1).get(j) ==0 && TABLE.get(i + 1).get(j - 1) == 0 && TABLE.get(i).get(j + 1) == 0){
                    int d = nearest(i,j);
                    if (d > maxD){
                        maxD = d;
                        ID_LIST.get(pid).dist.set(0, i);
                        ID_LIST.get(pid).dist.set(1, j);
                    }
                }
            }
        }
        if (maxD == 0) return false;
        TABLE.get(x).set(y, 1);
        return true;
    }
    private static int nearest(int x, int y) {
        int minD = 1000;
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < M + 1; j++){
                if (TABLE.get(i).get(j) == 1){
                    int d = (x-i)*(x-i) + (y-j)*(y-j);
                    minD = Math.min(minD, d);
                }
            }
        }
        return minD;
    }
    static class ID{
        int num;
        List<Integer> dist;
        public ID(){
            this.num = 0;
            this.dist = new ArrayList<>(Arrays.asList(0,0));
        }
    }
}