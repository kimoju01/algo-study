import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 소비
        int cnt = N;

        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();

            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) == word.charAt(j + 1)) {
                    continue;
                } else if (word.substring(j + 1).indexOf(word.charAt(j)) != -1) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
        scanner.close();
    }
}