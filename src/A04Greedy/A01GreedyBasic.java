package src.A04Greedy;

// Greedy : 현재로서 최적의 해를 선택했을 때, 전체의 최적의 해를 보장하는 알고리즘.
public class A01GreedyBasic {
    public static void main(String[] args) {
//        1,5,10,20의 숫자가 있을 때, 조합하여 99를 만들 수 있는 조합 중 가장 짧은 조함의 길이
        int[] arr = {20, 10, 5, 1};

        int target = 99;
        int cnt = 0;

        for (int i : arr) {
            cnt += target / i;
            target %= i;
        }

        System.out.println(cnt);
    }
}
