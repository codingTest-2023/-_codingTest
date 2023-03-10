import java.util.*;
import java.io.*;


public class 트럭
{
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<List<Integer>> offer = new ArrayList<>();
        for (int n = 0; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();
            while (st.hasMoreTokens()){
                temp.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < temp.get(0); i++){
                offer.add(Arrays.asList(temp.get(2*i+1), temp.get(2*i+2), n + 1));
            }
        }
        int numScenario = Integer.parseInt(br.readLine());
        List<Integer> temp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> scenario = new ArrayList<>();
        while (st.hasMoreTokens()){
            temp.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < numScenario; i++){
            scenario.add(Arrays.asList(temp.get(i),i + 1,0));
        }
        offer.sort((o1,o2) -> (o1.get(0) - o2.get(0)));
        scenario.sort((o1,o2) -> (o1.get(0) - o2.get(0)));
        int revenue = 0, sIndex = 0;
        List<Integer> buyPayment = new ArrayList<>();
        for (int i = 0; i < N +1; i++){
            buyPayment.add(0);
        }
        for(List<Integer> list : offer){
            int size = list.get(0), payment = list.get(1), buyID = list.get(2);
            if (payment > buyPayment.get(buyID)) {
                revenue +=  payment - buyPayment.get(buyID);
                buyPayment.set(buyID, Math.max(payment, buyPayment.get(buyID)));
            }
            while (sIndex < numScenario && scenario.get(sIndex).get(0) <= revenue){
                scenario.get(sIndex).set(2,size);
                sIndex += 1;
            }
        }
        while (sIndex < numScenario){
            scenario.get(sIndex).set(2,-1);
            sIndex += 1;
        }
        scenario.sort((o1, o2) -> o1.get(1)-o2.get(1));
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : scenario){
            sb.append(list.get(2)).append(" ");
        }
        System.out.println(sb);
    }
}