import java.util.*;
import java.io.*;


public class 조립라인
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> _finish = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
        ArrayList<ArrayList<Integer>> _switch = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
        ArrayList<ArrayList<Integer>> _work = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));

        for (int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            _work.get(0).add(Integer.parseInt(st.nextToken()));
            _work.get(1).add(Integer.parseInt(st.nextToken()));
            _switch.get(0).add(Integer.parseInt(st.nextToken()));
            _switch.get(1).add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        _work.get(0).add(Integer.parseInt(st.nextToken()));
        _work.get(1).add(Integer.parseInt(st.nextToken()));

        _finish.get(0).add(_work.get(0).get(0));
        _finish.get(1).add(_work.get(1).get(0));

        for (int i = 0; i < n - 1; i++){
            _finish.get(0).add(Math.min(_finish.get(0).get(i), _finish.get(1).get(i) + _switch.get(1).get(i)) + _work.get(0).get(i + 1));
            _finish.get(1).add(Math.min(_finish.get(1).get(i), _finish.get(0).get(i) + _switch.get(0).get(i)) + _work.get(1).get(i + 1));
        }

        int ans = Math.min(_finish.get(0).get(n - 1), _finish.get(1).get(n -1));

        System.out.println(ans);
    }
}