package src.A01Sort;

import java.util.*;

public class A02HeapSortProblemSolve {
}

//    명예의 전당 : 프로그래머스
class Solution1 {
    public List<Integer> solution(int k, int[] score) {
        Queue<Integer> pq = new PriorityQueue<>();

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);

            if (i >= k)
                pq.poll();

            answer.add(pq.peek());

        }

        return answer;
    }
}

//    야근지수 : 프로그래머스
class Solution2 {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        for (int i = 0; i < n; i++) {
            pq.add(Math.max(0, pq.poll()-1));
        }

        long answer = 0;
        for (int i : pq) {
            answer += i*i;
        }

        return answer;
    }
}