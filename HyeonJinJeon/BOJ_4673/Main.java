package BOJ_4673;

public class Main {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        for(int i = 1; i <= 10000; i++){
            int notSelfNum = d(i);
            if(notSelfNum <= 10000){
                arr[notSelfNum] = true;
            }
        }
        for(int i = 1; i <= 10000; i++){
            if(arr[i] == false){
                System.out.println(i);
            }
        }
    }
    public static int d(int n){
        int result = n;
        while (n > 0){
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}
