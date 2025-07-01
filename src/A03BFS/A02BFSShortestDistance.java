package src.A03BFS;

import java.util.*;

public class A02BFSShortestDistance {
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

        System.out.println(getshortestDistance(0, 4));
    }

    public static int getshortestDistance(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
//        Queue 안에 Integer가 아니라 int[]을 담아서 0: 노드 번호, 1: 출발지에서 노드까지의 거리를 설계가능
        int[] dist = new int[NODE_CNT];

        q.add(from);
        dist[from] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == to) return dist[now] - 1;

            for (int next : adjList.get(now)) {
                if (dist[next] != 0) continue;
                q.add(next);
                dist[next] = dist[now] + 1;
            }
        }
        return -1;
    }
}
