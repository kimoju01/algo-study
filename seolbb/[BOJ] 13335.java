import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 한줄에서 공백 단위로 읽기 위함. 4 2 10
        int n = Integer.parseInt(st.nextToken());   // 트럭의 수
        int w = Integer.parseInt(st.nextToken());   // 다리의 길이
        int l = Integer.parseInt(st.nextToken());   // 다리의 최대하중

        st = new StringTokenizer(br.readLine());    // 7 4 5 6
        Queue<Integer> truck = new LinkedList<>();
        for(int i = 0; i < n; i++){ // Queue에 하나씩 넣기
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int sum = 0;    // 다리 위에 있는 트럭의 무게 합
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < w; i++){ // 첫번째 트럭이 올라가기전까지 다리 길이 만큼 큐에 0 을 넣어줌
            bridge.offer(0);
        }

        while (!bridge.isEmpty()){
            time++;
            sum-=bridge.poll(); // 다리 밖으로
            if(!truck.isEmpty()){
                if(truck.peek() + sum <= l){
                    sum += truck.peek();
                    bridge.offer(truck.poll());
                } else {    // 최대하중보다 크면 트럭이 건널 수 없음.
                    bridge.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}
