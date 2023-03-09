import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
//프로그래머스 개인정보 수집 유효기간
public class _0309_02 {
    public static void main(String[] args) {

    }
    static class Solution {
        public List<Integer> solution(String today, String[] terms, String[] privacies) {
            List<Integer>  answer = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate date = LocalDate.parse(today,formatter);
            Map<String, Integer> termsMap = new HashMap<>();

            for (String s : terms) {
                String[] term = s.split(" ");
                termsMap.put(term[0], Integer.valueOf(term[1]));
            }
            for(int i=0; i<privacies.length; i++) {
                String[] privacy = privacies[i].split(" ");
                LocalDate privacyDate = LocalDate.parse(privacy[0], formatter).plusMonths(termsMap.get(privacy[1])).minusDays(1);

                if (privacyDate.isBefore(date)) {
                    answer.add(i+1);
                }
            }
            return answer;
        }
    }

}
