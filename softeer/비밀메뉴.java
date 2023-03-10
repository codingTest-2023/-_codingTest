import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀메뉴 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String ans = br.readLine().replace(" ", "");
        String cmd = br.readLine().replace(" ", "");
        if (cmd.contains(ans)) System.out.println("secret");
        if (!cmd.contains(ans)) System.out.println("normal");
    }
}
