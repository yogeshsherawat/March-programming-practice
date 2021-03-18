package March;

public class partition_set_into_two_sets_such_that_sum_of_sqrs_of_sum_of_two_subsets_is_max {
    static int fun(int arr[], int n) {
        int sum = 0;
        int sumA = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i < n / 2 - 1)
                sumA += arr[i];
        }
        int rest = sum - sumA;
        return sumA * sumA + rest * rest;

    }

    static int fun2(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[j] == 1 && j + arr[i] <= sum)
                    dp[j + arr[i]] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i <= sum; i++) {
            if (dp[i] == 1) {
                int rest = sum - i;
                max = Math.max(max, i * i + rest * rest);
            }
        }
        return max;
    }

    public static void main(String args[]) {

        int arr[] = { 6, 7, 2, 1, 8, 9 };
        int ans = fun(arr, arr.length);
        int ans2 = fun(arr, arr.length);
        System.out.println(ans);
        System.out.println(ans2);

    }
    
}
