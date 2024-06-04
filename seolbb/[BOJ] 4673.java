
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 숫자를 자릿수마다 쪼개서 더한다.
        // 10으로 계속 나누면 몫과 나머지로 각 자리수를 구할수있겠다..
        // 생성자들만 먼저 구한다
        // 생성자들을 제외한 숫자들이 셀프넘버

        // 생성자
        ArrayList<Integer> cons = new ArrayList<>();
        // 셀프넘버
        ArrayList<Integer> selfNum = new ArrayList<>();

        int x = 0;
        // 생성자 구하기
        for(int i = 1; i <= 10000; i++){
            cons.add(sumNum(i));

            // 생성자가 아닌 숫자들이 셀프넘버
            if(!cons.contains(i)){
                selfNum.add(i);
            }
        }

        for(int n : selfNum){
            System.out.println(n);
        }
    }

    public static int sumNum(int n){
        int sum = n;    // 자기 자신에다가 각 자릿수를 더해야하니까 n으로 둠.
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
