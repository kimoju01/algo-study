import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/2108
1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numlist = new int[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            numlist[i] = Integer.parseInt(input);
        }

        System.out.println(caculateAvg(numlist));
        System.out.println(caculateMid(numlist));
        System.out.println(caculateMany(numlist));
        System.out.println(caculateRange(numlist));

    }

    private static int caculateAvg(int[] numlist) {
        int sum = 0;
        for (int i=0; i<numlist.length; i++) {
            sum += numlist[i];
        }

        double avg = (double) sum / numlist.length;
        return (int) Math.round(avg);
    }

    private static int caculateMid(int[] numlist) {
        Arrays.sort(numlist);
        return numlist[numlist.length/2];
    }

    private static int caculateMany(int[] numlist) {
        Map<Integer, Integer> numCount = new HashMap<>();

        // Map에 Key=숫자, Value=숫자가 나타난 빈도
        for (int i=0; i<numlist.length; i++) {
            if (numCount.containsKey(numlist[i])) {
                int currentValue = numCount.get(numlist[i]);
                numCount.put(numlist[i], currentValue + 1);
            } else {
                numCount.put(numlist[i], 1);
            }
        }

        // Value가 가장 높은 Key 찾기
        int maxValue = 0;
        List<Integer> maxValueKeyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxValueKeyList.clear();
                maxValueKeyList.add(entry.getKey());
            } else if (entry.getValue() == maxValue) {
                maxValueKeyList.add(entry.getKey());
            }
        }

        // maxValue가 동일하지 않으면 maxValueList 개수가 1개 뿐일테니 바로 반환
        if (maxValueKeyList.size() == 1) {
            return maxValueKeyList.get(0);
        } else {
            // maxValue가 동일하면 2번째로 작은 Key 반환
            Collections.sort(maxValueKeyList);
            return maxValueKeyList.get(1);
        }
    }

    private static int caculateRange(int[] numlist) {
        Arrays.sort(numlist);
        return numlist[numlist.length - 1] - numlist[0];
    }

}
