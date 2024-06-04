package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/3085
가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다.
사탕의 색이 다른 인접한 두 칸을 고른 다음 칸에 들어있는 사탕을 서로 교환한다.
모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
 */

public class CandyGame {

    static char[][] board;  // 보드판
    static int N;           // 보드의 크기 N x N
    static int max = 1;     // 최대 사탕 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        // 보드에 사탕 채우기
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<N; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        br.close();

        // 오른쪽 사탕이랑 교환해서 최대값 찾아보고 제자리로 돌리기
        for (int i=0; i<N; i++) {
            for (int j=0; j<N-1; j++) {
                swap(i, j, i, j+1); // x1, y1, x2, y2 순서! 오른쪽 사탕이랑 교환하기
                findMax();              // 최대값 찾기
                swap(i, j+1, i, j); // 교환한 사탕 제자리로 다시 되돌리기
            }
        }

        // 아래 사탕이랑 교환해서 최대값 찾아보고 제자리로 돌리기
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<N; j++) {
                swap(i, j, i+1, j);     // 아래 사탕이랑 교환하기
                findMax();
                swap(i+1, j, i, j);     // 교환한 사탕 제자리로 다시 되돌리기
            }
        }

        System.out.println(max);

    }

//    public static void swapRight(int x, int y) {
//        char temp = board[x][y];
//        board[x][y] = board[x][y+1];
//        board[x][y+1] = temp;
//    }
//
//    public static void swapLeft(int x, int y) {
//        char temp = board[x][y+1];
//        board[x][y+1] = board[x][y];
//        board[x][y] = temp;
//    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static void findMax() {

        // 가로로 개수 세기
        for (int i=0; i<N; i++) {
            int count = 1;      // 다음 줄 넘어가면 연속된게 아니니 연속 개수 초기화
            for (int j=0; j<N-1; j++) {
                if (board[i][j] == board[i][j+1]) {     // 오른쪽 문자랑 같으면
                    count++;    // 연속된 개수로 카운트하기
                } else {        // 오른쪽 문자랑 다르면
                    if (count > max) {  // 만약 카운트한 연속된 개수가 지금까지 카운트한 최대 사탕 개수보다 많으면
                        max = count;    // 연속된 개수 초기화 전 최대 사탕 개수 경신
                    }
                    count = 1;      // 문자가 달라졌으니 연속된 개수는 무조건 초기화
                }
            }
            if (count > max) max = count;   // 연속된 문자가 끝까지 달라지지않고 같을 때 최대 사탕 개수 경신 (한줄이 다 똑같을때)
        }

        // 세로로 개수 세기
        for (int i=0; i<N; i++) {
            int count = 1;
            for (int j=0; j<N-1; j++) {
                if (board[j][i] == board[j+1][i]) {     // 아래 문자랑 같으면
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 1;
                }
            }
            if (count > max) max = count;
        }
    }
}
