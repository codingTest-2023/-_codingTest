import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42885
//프로그래머스 lv2 구명보트
public class _0404_01 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{70, 50, 80, 50}, 100));
    }
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int left = 0;
            int right = people.length - 1;
            while (left <= right){
                if (people[left] + people[right] <= limit){
                    left += 1;
                }
                right -= 1;
                answer += 1;
            }
            return answer;
        }
    }
}
