package src.A03BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A03ShortestDistanceAdjList {
}

// 프로그래머스 : 가장 먼 노드
class Solution {
    public int solution(int n, int[][] edges) {
        int[] distance = new int[n + 1];

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


        Queue<Integer> q = new LinkedList<>();
        int max = 0;

        q.add(1);
        distance[1] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adjList.get(now)) {
                if (distance[next] != 0) continue;

                q.add(next);
                distance[next] = distance[now] + 1;
                max = Math.max(max, distance[next]);
            }
        }

        int answer = 0;

        for (int dist : distance) {
            if (dist == max) answer++;
        }

        return answer;
    }
}
