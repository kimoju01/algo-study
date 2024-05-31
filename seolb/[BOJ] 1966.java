import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0; // 테스트 케이스
        int n = 0; // 문서의 갯수
        int m = 0; // 궁금한 문서의 위치
        Queue<Integer> queue;  // n개 문서의 중요도
        Queue<Integer> indexQ; // n개 문서의 인덱스

        t = Integer.parseInt(br.readLine());    // 첫줄에 적힌 테스트케이스

        for(int i= 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());    // //한줄에서 공백 단위로 읽기 위함. n,m이 적혀있는 줄
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 큐 생성 (선언할때 생성하면 값이 달라진다..!)
            queue = new LinkedList<>();
            indexQ = new LinkedList<>();

            st = new StringTokenizer(br.readLine()); // 문서의 중요도가 적혀있는 줄
            for(int j = 0; j < n; j++){ // Queue에 값 담기
                queue.offer(Integer.parseInt(st.nextToken()));
                indexQ.offer(j);
            }

            int result = 1; // 답

            while(!queue.isEmpty()){
                int max = Collections.max(queue);   // 큐에서 최우선순위
                int poll = queue.poll();// 맨 앞의 값 반환 후 삭제
                int pollIdx = indexQ.poll();    // poll 한 숫자의 index

                if(poll == max){
                    if(m == pollIdx){   // 맨앞의 값이 최우선순위에다가 궁금한 문서의 위치일 경우
                        System.out.println(result);
                        break;
                    }
                    result++;
                } else {    // 맨앞의 값이 최우선순위가 아닐경우 맨뒤로 가야함
                    queue.offer(poll);
                    indexQ.offer(pollIdx);
                }
            }
        }
    }
}
