package src.A01Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A01HeapSort {
    public static void main(String[] args) {
//        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
//                     0, 1, 2, 3, 4, 5, 6, 7, 8
        int[] arr = {1, 9, 5, 1, 3, 4, 86, 51, 4, 8, 6, 13, 5, 4, 7, 3, 1, 5, 6, 4, 4, 1, 5, 9, 51, 3};

//        길이를 /2 연산해 준 인덱스까지가 자식이 있는 노드, 이후는 리프 노드

//        최초 힙 구성 : N*logN
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

//        루트 노드와 최하위노드를 자리change해가면서 재heapify
        for (int i = arr.length - 1; i >= 0; i--) {
//            0번째 idx와 마지막 idx의 자리 변경
            swap(arr, 0, i);
//            재힙화
            heapify(arr, 0, i);
        }

//        잘 돌아갔나 출력
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    힙화 할 배열
     * @param parent 시작할 부모노드
     * @param length 힙화 할 길이
     */
    static void heapify(int[] arr, int parent, int length) {
//        자식 노드와 비교 : 자식노드는 왼쪽(parent * 2 + 1), 오른쪽(parent * 2 + 2)
        int leftChildIdx = parent * 2 + 1;
        int rightChildIdx = leftChildIdx + 1;
//        자식이 하나도 없으면 리턴
        if (leftChildIdx >= length) return;

//        자식이 하나 있으면 비교 해서 변경하고 리턴
        if (leftChildIdx == length - 1) {
            if (arr[parent] > arr[leftChildIdx]) swap(arr, parent, leftChildIdx);

            return;
        }

//        자식이 더 작으면 자리 변경
//        만약 자리 변경이 발생하면 재귀적 호출

//        자식 중에 더 작은 놈을 골라서
        int minIdx = arr[leftChildIdx] < arr[rightChildIdx] ? leftChildIdx : rightChildIdx;
//        부모와 비교
        if (arr[parent] > arr[minIdx]) {
            swap(arr, parent, minIdx);
            heapify(arr, minIdx, length);
        }

//        pq를 통한 정렬방법

//        최초 힙구성 : N log N
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(1, 9, 5, 1, 3, 4, 86, 51, 4, 8, 6, 13, 5, 4, 7, 3, 1, 5, 6, 4, 4, 1, 5, 9, 51, 3));

        pq.poll();
    }

    static void swap(int[] arr, int idxA, int idxB) {
        int temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }
}


