import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            if (input.equals("0")) {
                sum -= stack.pop();
            } else {
                int num = Integer.parseInt(input);
                sum += stack.push(num);
            }
        }

        System.out.println(sum);

        br.close();
    }
}
