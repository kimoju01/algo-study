package BOJ_1316;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        int result = solution(arr);
        System.out.println(result);
    }
    public static int solution(String[] arr){
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length(); j++){
                char nowChar = arr[i].charAt(j);
                //만약 키를 갖고 있지 않다면
                if(!map.containsKey(nowChar)){
                    map.put(nowChar, j);
                    continue;
                }
                if(map.get(nowChar) == (j-1)){
                    map.put(nowChar, j);
                }else{
                    result++;
                    break;
                }
            }
            map.clear();
        }
        return arr.length-result;
    }
}
