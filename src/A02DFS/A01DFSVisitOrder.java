package src.A02DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A01DFSVisitOrder {
    static boolean[] visited;
    static List<List<Integer>> adjList;
    static final int NODE_CNT = 5;

    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러개인 경우, 정점번호가 작은 것을 먼저 방문
        // 0부터 시작하면 1->3->2->4 순서로 방문
        int[][] edges = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};

        adjList = new ArrayList<>();
        visited = new boolean[NODE_CNT];

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

        dfs(0);
    }

    public static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;

        System.out.print(start + " ");

        for (int next : adjList.get(start)) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}

// DFS BFS(1260) : 백준
// 연결요소의 개수(11724) : 백준
class Main_11724 {
    static List<List<Integer>> vertices;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split(" ");

        int vertexCnt = Integer.parseInt(ve[0]);
        int edgeCnt = Integer.parseInt(ve[1]);

        isVisited = new boolean[vertexCnt + 1];

        vertices = new ArrayList<>();
        for (int i = 0; i < vertexCnt + 1; i++) {
            vertices.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] vertex = br.readLine().split(" ");
            int a = Integer.parseInt(vertex[0]);
            int b = Integer.parseInt(vertex[1]);
            vertices.get(a).add(b);
            vertices.get(b).add(a);
        }

        br.close();

        System.out.println(countConnectedComponent());

    }

    public static int countConnectedComponent() {
        int count = 0;
        for (int i = 1; i < isVisited.length; i++) {
            if (isVisited[i]) continue;
            bfs(i);
            count++;
        }
        return count;
    }

    public static void bfs(int startVertex) {
        Queue<Integer> q = new LinkedList<>();

        q.add(startVertex);
        isVisited[startVertex] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            List<Integer> linkedVertices = vertices.get(vertex);

            for (Integer linkedVertex : linkedVertices) {
                if (isVisited[linkedVertex]) continue;

                q.add(linkedVertex);
                isVisited[linkedVertex] = true;
            }
        }
    }
}