import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=0; i<N; i++) {
            if (isGroupWord(br.readLine())) {
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }

    static boolean isGroupWord(String str) {
        boolean alpha[] = new boolean[26];  // 입력받은 값이 영어이므로 영어 개수만큼 배열 생성
        int prev = -1;  // 이전 문자의 인덱스값을 저장하는 변수

        for (int i=0; i<str.length(); i++) {
            int current = str.charAt(i);    // 현재 문자의 아스키 코드값 저장
            if (prev != current) {          // 이전 문자와 i번째 문자가 같지 않다면
                if (alpha[current - 'a'] == false) {    // false라는 것은 문자가 처음 나온 문자라는 것
                    alpha[current - 'a'] = true;    // 처음 나왔음을 확인했으니까 다음에 나오면 두번째로 나온 문자이므로 true로 바꿔준다
                    prev = current; // 이전 문자와 비교해야하므로 다음 반복문때는 지금 문자가 이전문자가 됨
                } else {    // 아니라는 것은 이미 나온 적이 있는 경우 -> 그룹 문자 X
                    return false;   // 더 이상 반복문 돌 필요 없으므로 return
                }
            } else {    // 만약 이전 문자와 지금 문자가 같다면 연속된 문자 => 계속 반복문 진행
                continue;
            }
        }
        return true;    // 여기까지 걸리지 않았다는 것은 그룹 문자라는 것!
    }

}
