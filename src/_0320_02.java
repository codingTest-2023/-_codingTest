import java.time.LocalTime;
import java.util.*;
//프로그래머스 주차 요금 계산 lv2
public class _0320_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }
    static class Solution {
        public List<Integer> solution(int[] fees, String[] records) {
            List<Integer> answer = new ArrayList<>();
            TreeMap<String,Double> total_fee = new TreeMap<>(Comparator.naturalOrder());
            HashMap<String,LocalTime> parkingLot = new HashMap<>();
            LocalTime parkingTime;
            LocalTime time;
            int basic_time = fees[0], basic_fee = fees[1], unit_time = fees[2], unit_fee = fees[3];
            for (String s : records){
                String[] record = s.split(" ");
                time = LocalTime.parse(record[0]);

                if ("IN".equals(record[2])){
                    parkingLot.put(record[1],time);
                    total_fee.put(record[1], total_fee.getOrDefault(record[1], 0D));
                    continue;
                }
                if ("OUT".equals(record[2])){
                    parkingTime = parkingLot.get(record[1]);
                    time = time.minusHours(parkingTime.getHour());
                    time = time.minusMinutes(parkingTime.getMinute());

                    total_fee.put(record[1], total_fee.get(record[1]) + (time.getHour() * 60) + time.getMinute());
                    parkingLot.remove(record[1]);
                }
            }
            for (String s : parkingLot.keySet()) {
                time = LocalTime.parse("23:59");
                parkingTime = parkingLot.get(s);
                time = time.minusHours(parkingTime.getHour()).minusMinutes(parkingTime.getMinute());
                total_fee.put(s, total_fee.get(s) + (time.getHour() * 60) + time.getMinute());
            }
            for (String s : total_fee.keySet()) {
                double minute = total_fee.get(s);
                if (minute <= basic_time){
                    answer.add(basic_fee);
                    continue;
                }
                answer.add((int) (basic_fee + Math.ceil((minute - basic_time) / unit_time) * unit_fee));
            }
            System.out.println(total_fee);
            return answer;
        }
    }
}
