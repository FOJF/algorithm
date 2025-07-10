package src.A06TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) {

//        아래 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내어라.
//        [1,9]와 [9,1]은 같은 것으로 취급
//        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int target = 10;

        List<int[]> myList = new ArrayList<>();

//        복잡도가 n^2
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (i == j) continue;
//
//                if (nums[i] + nums[j] == target) myList.add(new int[]{nums[i], nums[j]});
//            }
//        }
//
//        for (int[] arr : myList) {
//            System.out.println(Arrays.toString(arr));
//        }

        // 정렬이 필요한 경우가 있고, (두 수의 합)
        // 필요없는 경우가 있음 (구간의 합)
//        Arrays.sort(nums);

//        복잡도 N
//        int start = 0;
//        int end = nums.length - 1;
//        // end가 0부터 출발하는 경우, end가 length-1부터 시작하는 경우.
//
//        while (start < end) { // <= 또는 < 인 경우
//            int sum = nums[start] + nums[end];
//            if (sum > target) {
//                end--;
//            } else if (sum == target) {
//                myList.add(new int[]{nums[start], nums[end]});
//                start++;
//                end--;
////                둘이 동시에 해도 되는 경우
////                하나만 움직여야 하는 경우가 있음
//            } else {
//                start++;
//            }
//        }

//        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6, 6};
//        Arrays.sort(nums);
        int[] nums = {1, 2, 3, 4, 5};
        target = 9;
        int start = 0;
        int end = 1;

        while (start < end && end < nums.length) { // <= 또는 < 인 경우

            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum == target) {
                myList.add(new int[]{nums[start], nums[end]});
                start++;
//                end--;
//                둘이 동시에 해도 되는 경우
//                하나만 움직여야 하는 경우가 있음
            } else {
                if (end == nums.length-1)
                    start++;
                else end++;
            }
        }

        for (int[] arr : myList) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
