package src.A02DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A04DFSBruteForce {
}

// 백준 : 2210
class Main_2210 {
    static Set<Integer> set;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new HashSet<>();
        board = new char[5][5];

        for (int i = 0; i < board.length; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < charArr.length; j += 2) {
                board[i][j / 2] = charArr[j];
            }
        }

        br.close();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, 0);
            }
        }

        System.out.println(set.size());
    }

    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void dfs(int x, int y, int depth, int tmp) {
        if (depth > 5) {
            set.add(tmp);
            return;
        }

        tmp = tmp * 10 + board[x][y] - '0';

        for (int[] dir : delta) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if ((0 <= nx && nx < 5) && (0 <= ny && ny < 5)) {
                dfs(nx, ny, depth + 1, tmp);
            }
        }
    }
}

// 프로그래머스 : 피로도