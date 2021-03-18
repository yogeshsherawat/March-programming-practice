package March;

public class minimum_number_of_coins_that_make_given_value {
    
    static int fun(int arr[], int n, int Val) {
        int dp[] = new int[Val + 1];
        for (int i = 0; i <= Val; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= Val; j++) {
                int k = j + arr[i];
                if (k <= Val && dp[j] < Integer.MAX_VALUE)
                    dp[k] = Math.min(dp[k], dp[j] + 1);
            }
        }
        for (int i = 0; i <= Val; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
        return dp[Val];

    }

    public static void main(String args[]) {
        int arr[] = { 25, 10, 5 };
        int Val = 30;
        int ans = fun(arr, arr.length, Val);
        System.out.println(ans);

    } 
    
}
