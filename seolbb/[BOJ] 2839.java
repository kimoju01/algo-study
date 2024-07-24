import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        // 더 적은 봉지를 사용하려면 5키로 봉지를 많이 사용해야 함.
        // 3키로 봉지를 사용하다가 5키로 봉지를 사용할 수 있으면 사용하기로!
        while(n > 0){
            if(n % 5 == 0){ // n이 5의 배수일때
                result = n / 5;
                System.out.println(result);
                break;
            } else {
                n -= 3; // 3키로 봉지에 담음
                result++;   // 봉지 갯수 추가
                if(n % 5 == 0){ // 5키로 봉지에 담을 수 있는 경우
                    result += n / 5;
                    System.out.println(result);
                    break;
                } else if (n == 1){
                    result = -1;
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
