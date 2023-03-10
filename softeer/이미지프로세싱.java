import java.util.*;
import java.io.*;


public class 이미지프로세싱
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int H,W,Q;
    static List<List<Integer>> images = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        for (int i = 0; i < H + 2; i++){
            images.add(new ArrayList<>());
            for (int j = 0; j < W + 2; j++){
                images.get(i).add(0);
            }
        }
        for (int i = 1; i < H + 1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < W + 1; j++){
                images.get(i).set(j,Integer.parseInt(st.nextToken()));
            }
        }
        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            if (images.get(x).get(y) != c)
                solve(x,y,c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < H +1; i++){
            for (int j = 1; j < W +1; j++){
                sb.append(images.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int x, int y, int c) {
        if (images.get(x).get(y) == 0) return;
        int oldImage = images.get(x).get(y);
        images.get(x).set(y,c);
        if (images.get(x - 1).get(y) == oldImage) solve(x - 1, y, c);
        if (images.get(x + 1).get(y) == oldImage) solve(x + 1, y, c);
        if (images.get(x).get(y - 1) == oldImage) solve(x, y - 1, c);
        if (images.get(x).get(y + 1) == oldImage) solve(x, y + 1, c);
    }

}