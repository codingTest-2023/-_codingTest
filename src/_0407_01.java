import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/72412
//프로그래머스 lv2 순위 검색
public class _0407_01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));

    }
    static class Solution {
        static HashMap<String, List<Integer>> map;

        public static int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            map = new HashMap<>();

            for (String s : info) {
                String[] p = s.split(" ");
                makeSentence(p, "", 0);
            }

            for (String key : map.keySet())
                Collections.sort(map.get(key));

            for (int i = 0; i < query.length; i++) {
                query[i] = query[i].replaceAll(" and ", "");
                String[] q = query[i].split(" ");
                answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
            }

            return answer;
        }

        // 이분 탐색
        private static int binarySearch(String key, int score) {
            List<Integer> list = map.get(key);
            int start = 0, end = list.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < score)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            return list.size() - start;
        }

        // info가 포함될 수 있는 문장
        private static void makeSentence(String[] p, String str, int cnt) {
            if (cnt == 4) {
                if (!map.containsKey(str)) {
                    List<Integer> list = new ArrayList<>();
                    map.put(str, list);
                }
                map.get(str).add(Integer.parseInt(p[4]));
                return;
            }
            makeSentence(p, str + "-", cnt + 1);
            makeSentence(p, str + p[cnt], cnt + 1);
        }
    }
}
