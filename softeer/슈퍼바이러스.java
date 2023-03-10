import java.util.*;
import java.io.*;


public class 슈퍼바이러스 {
    static final long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken()) * 10L;
        long ans = (calculate(p,n) * k) % mod;
        System.out.println(ans);
    }
    public static long calculate(long x, long y){
       if(y == 1) return x;

       long res = calculate(x,y/2);
       res = (res * res) % mod;
       if(y%2 == 1) res = (res * x) % mod;
       return res;
    }
}