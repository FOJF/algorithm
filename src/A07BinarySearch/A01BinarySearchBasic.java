package src.A07BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01BinarySearchBasic {
    public static void main(String[] args) {

        // 이분탐색은 사전에 데이터가 오름차순 정렬 되어있어야 함
//        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
//        int target = 17;
//
//        System.out.println("Arrays.binarySearch's targetIdx = " + Arrays.binarySearch(arr, target));
//
//        int start = 0;
//        int end = arr.length - 1;
//
//        int targetIdx = -1;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//
//            if (arr[mid] == target) {
//                targetIdx = mid;
//                break;
//            } else if (arr[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//
//        System.out.println("my targetIdx = " + targetIdx);

//
//        target이 arr에 있다면 index값을 리턴하고, arr에 없다면 있어야할 자리 index를 return.
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 20;
        int answer = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == arr[mid]) {
                answer = mid;
//                조건에 맞는 값을 찾더라도 최소값, 최대값을 위해 이분탐색을 계속 진행할 수 있음.
                break;
            } else if (target > arr[mid]) {
                start = mid + 1;
//                경우에 따라 target이 없는 경우 어딘가에 answer = mid;가 어딘가에 존재해야할 수도 있음
//                answer = mid;
            } else {
                end = mid - 1;
//                경우에 따라 target이 없는 경우 어딘가에 answer = mid;가 어딘가에 존재해야할 수도 있음
//                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
