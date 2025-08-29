import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // int[] answer = {};
        
        // count - 해당 스테이지에 사람들이 몇 명이나 멈춰있는지, 1부터 N+1까지의 스테이지를 담음
        int[] count = new int [N + 2];
        for (int s : stages) {
            //s는 1과 N+1 사이
            count[s]++;
        }
        
        double total = stages.length;
        HashMap<Integer, Double> fails = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            if (count[i] ==0) {
                fails.put(i,0.);
            } else {
                fails.put(i, count[i]/total); //실패율
                total -= count[i]; //분모 빼주기
            }
            
        }
        
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}