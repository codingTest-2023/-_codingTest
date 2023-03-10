import java.util.*;
import java.io.*;


public class 전광판
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String args[]) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Hashtable<Character,String> light = new Hashtable<>();
        light.put('0',"1110111");
        light.put('1',"0010010");
        light.put('2',"1011101");
        light.put('3',"1011011");
        light.put('4',"0111010");
        light.put('5',"1101011");
        light.put('6',"1101111");
        light.put('7',"1110010");
        light.put('8',"1111111");
        light.put('9',"1111011");
        light.put(' ',"00000000");
        for (int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            a = " ".repeat((5 - a.length())) + a;
            b = " ".repeat((5 - b.length())) + b;
            int total = 0;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 7; j++){
                    if (light.get(a.charAt(i)).charAt(j) != light.get(b.charAt(i)).charAt(j)){
                        total += 1;
                    }
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}