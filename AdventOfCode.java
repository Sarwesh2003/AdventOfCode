import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.*;

class AdventOfCode{
    public static void main(String[] args) {
        String filePath = "input.txt"; // Specify the path to your file here
        Scanner sc = new Scanner(System.in);
        // StringBuilder str = new StringBuilder(sc.next());
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                if(!line.strip().isEmpty()){
                    String[] ip = line.split("  ");
                    left.add(Integer.parseInt(ip[0].strip()));
                    right.add(Integer.parseInt(ip[1].strip()));
                    // System.out.println(ip[0] + " " +ip[1]);
                }
                
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        
        
        problem1_pt2(left, right);
    }

    public static void problem1_pt2(List<Integer> left, List<Integer> right){
        Collections.sort(left);
        Collections.sort(right);
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = left.size() > right.size() ? left.size() : right.size();
        
        for(int i = 0; i < n; ++i) {
            map.put(right.get(i), map.getOrDefault(right.get(i), 0) + 1);
        }
        
        int diff = 0;
        for(int i = 0; i < n; ++i){
            if(i < left.size()){
                diff += map.getOrDefault(left.get(i), 0) * left.get(i);
            }
        }
        System.out.println(diff);
    }

    public static void problem1(List<Integer> left, List<Integer> right){
        Collections.sort(left);
        Collections.sort(right);
        int n = left.size() > right.size() ? left.size() : right.size();
        int diff = 0;
        for(int i = 0; i < n; ++i){
            if(i < left.size() && i < right.size()){
                diff += (Math.abs(left.get(i) - right.get(i)));
            }else{
                diff += i <left.size() ? left.get(i) : right.get(i);
            }
        }
        System.out.println(diff);
    }
    public static void dryRun(String str){
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);

            if(!s.isEmpty() && Character.toLowerCase(s.peek())  == Character.toLowerCase(ch)){
                if(Character.isUpperCase(s.peek()) && Character.isLowerCase(ch)){
                    s.pop();
                }else if(Character.isLowerCase(s.peek()) && Character.isUpperCase(ch)){
                    s.pop();
                }
            }else {
                s.push(ch);
            }
        }
        System.out.println("Stack:" + s.size());
    }
}