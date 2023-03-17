//프로그래머스 혼자 놀기의 달인 lv2
public class _0317_01 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int solution(int[] cards){
            int n = cards.length;
            boolean[] isVisited = new boolean[n];
            int[] groupSizes = new int[n];
            int numGroups = 0;

            for (int i = 0; i < n; i++) {
                int currentCard = i;
                int groupSize = 0;

                while (!isVisited[currentCard]) {
                    isVisited[currentCard] = true;
                    groupSize++;
                    currentCard = cards[currentCard] - 1;
                }

                if (groupSize > 0) {
                    groupSizes[numGroups++] = groupSize;
                }
            }

            int maxGroupSize = 0;
            int secondMaxGroupSize = 0;

            for (int i = 0; i < numGroups; i++) {
                int groupSize = groupSizes[i];
                if (groupSize > maxGroupSize) {
                    secondMaxGroupSize = maxGroupSize;
                    maxGroupSize = groupSize;
                } else if (groupSize > secondMaxGroupSize) {
                    secondMaxGroupSize = groupSize;
                }
            }

            return (numGroups > 1) ? maxGroupSize * secondMaxGroupSize : 0;
        }
    }
}
