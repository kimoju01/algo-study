package BOJ_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String command =  br.readLine();
            if(command.startsWith("push")){
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }else if(command.equals("pop")){
                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(stack.pop());
                }
            }else if(command.equals("top")){
                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(stack.peek());
                }
            }else if(command.equals("empty")){
                if(stack.isEmpty()){
                    list.add(1);
                }else{
                    list.add(0);
                }
            }else if(command.equals("size")){
                list.add(stack.size());
            }
        }
        br.close();
        for(int pick : list){
            System.out.println(pick);
        }
    }
}