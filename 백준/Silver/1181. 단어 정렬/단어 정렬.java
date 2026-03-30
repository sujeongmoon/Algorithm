import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        List<String> sortedList = set.stream()
            .sorted(Comparator.comparingInt(String::length)
                   .thenComparing(Comparator.naturalOrder()))
            .collect(Collectors.toList());
        
        for (String s : sortedList) {
            bw.write(s);
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
    
}