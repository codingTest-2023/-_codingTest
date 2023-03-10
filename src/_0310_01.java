import java.io.*;
import java.util.*;
//프로그래머스 이모티콘 할인
public class _0310_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{40,10000},{25, 10000}}, new int[]{7000, 9000}));
    }
    static class Solution {
        List<Integer> disCount =  Arrays.asList(10,20,30,40);
        int users_length, emoticons_length;
        List<List<Integer>> answer = new ArrayList<>();
        List<List<Integer>> users = new ArrayList<>();
        List<Integer> emoticons;
        public List<Integer> solution(int[][] users, int[] emoticons) {
            users_length = users.length;
            emoticons_length = emoticons.length;
            this.emoticons = List.of(Arrays.stream(emoticons).boxed().toArray(Integer[]::new));
            for (int i = 0; i < users_length; i++){
                this.users.add(List.of(Arrays.stream(users[i]).boxed().toArray(Integer[]::new)));
            }
            System.out.println(this.users);
            System.out.println(this.emoticons);
            answer.add(new ArrayList<>(Arrays.asList(0,0)));
            dfs(Arrays.asList(new Integer[emoticons_length]),0);
            answer.sort((o1, o2) -> o2.get(0) - o1.get(0) == 0 ? o2.get(1) - o1.get(1) : o2.get(0) - o1.get(0));
            System.out.println(answer);
            return answer.get(0);
        }
        public void dfs(List<Integer> disCountInfo, int level){
            if (level == emoticons_length){
                int buyCount = 0, buySum = 0;
                for (int i = 0; i < users_length; i++){
                    int sum = 0;
                    for (int j = 0; j < emoticons_length; j++){
                        if (disCountInfo.get(j) >= users.get(i).get(0)){
                            sum += emoticons.get(j) * (100 - disCountInfo.get(j))  / 100;
                        }
                    }
                    if (sum >= users.get(i).get(1)){
                        buyCount++;
                        continue;
                    }
                    if (sum < users.get(i).get(1)){
                        buySum += sum;
                    }
                }
                answer.add(Arrays.asList(buyCount, buySum));
                return;
            }
            for (int i = 0; i < 4; i++){
                disCountInfo.set(level, disCount.get(i));
                dfs(disCountInfo,level+1);
            }
        }
    }
}
