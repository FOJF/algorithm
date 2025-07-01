package src.A02DFS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A02DFSSearchAllCases {
    static List<List<Integer>> adjList;
    static final int NODE_CNT = 10;

    public static void main(String[] args) {
        // 1부터 10까지의 노드가 존재

        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};

        adjList = new ArrayList<>();

        for (int i = 0; i < NODE_CNT + 1; i++) {
            adjList.add(new ArrayList<>());
        }

//        여기서는 1번이 루트노드라고 정해졌기 때문에, visited제외하고 단방향 노드로 설계
        for (int[] edge : arr) {
            adjList.get(edge[0]).add(edge[1]);
        }

//        정점번호가 작은 것부터 방문하기 위한 정렬
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }
//        System.out.println(adjList);

        dfs(1);

        System.out.println(answer);
    }

    static List<Integer> tmp = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();
    public static void dfs(int start) {
        tmp.add(start);

        for (int next : adjList.get(start)) {
            dfs(next);
        }

        if (adjList.get(start).isEmpty()) {
            // 더 이상 갈 곳이 없으면 tmp를 출력하고 리턴
            answer.add(new ArrayList<>(tmp));
        }

        tmp.remove(tmp.size()-1);
    }
}
