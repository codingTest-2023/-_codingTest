import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
    static final long m = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        long ans = (calculator(p,n) * k) % m;
        System.out.println(ans);

    }
    public static long calculator(long p, long n){
        if (n == 1) return p;
        long res = calculator(p,n/2);
        res = (res * res) % m;
        if (n % 2 == 1) return (res * p) % m;
        return res;
    }
}