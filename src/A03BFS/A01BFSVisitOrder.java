package src.A03BFS;

import java.util.*;

public class A01BFSVisitOrder {
    static List<List<Integer>> adjList;
    static final int NODE_CNT = 5;

    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러개인 경우, 정점번호가 작은 것을 먼저 방문
        // 0부터 시작하면 1->2->3->4 순서로 방문
        int[][] edges = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};

        adjList = new ArrayList<>();

        for (int i = 0; i < NODE_CNT; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

//        정점번호가 작은 것부터 방문하기 위한 정렬
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }
        System.out.println(adjList);

        bfs(0);
    }

    public static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[NODE_CNT];

        q.add(root);
        visited[root] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for (int next : adjList.get(now)) {
                if (visited[next]) continue;
                q.add(next);
                visited[next] = true;
            }
        }
    }
}
