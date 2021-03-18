package March;

public class minimum_number_of_insertions_to_make_string_palindrom {

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    // Returns the length of the longest
    // palindromic subsequence in seq
    static int lps(String seq) {
        int n = seq.length();
        int i, j, cl;
        // Create a table to store results of subproblems
        int L[][] = new int[n][n];

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower
        // diagonal values of table are
        // useless and not filled in the process.
        // The values are filled in a manner similar
        // to Matrix Chain Multiplication DP solution (See
        // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).
        // cl is length of substring
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = max(L[i][j - 1], L[i + 1][j]);
            }
        }

        return L[0][n - 1];
    }

    static int fun(char arr[], int i, int j) {
        if (i > j)
            return Integer.MAX_VALUE;
        if (i == j)
            return 0;
        if (i + 1 == j && arr[i] == arr[j])
            return 0;
        if (i + 1 == j && arr[i] != arr[j])
            return 1;
        if (arr[i] == arr[j])
            return fun(arr, i + 1, j - 1);
        else
            return Math.min(fun(arr, i + 1, j), fun(arr, i, j - 1)) + 1;
    }

    static int dpfun(char arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int gap = 1; gap < arr.length; gap++) {
            for (int i = 0, j = gap; j < arr.length; i++, j++) {
                if (arr[i] == arr[j])
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
            }
        }

        return dp[0][arr.length - 1];

    }

    static int dpsubstr(char arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int gap = 1; gap <= n; gap++) {
            for (int i = 0, j = gap - 1; j < n; i++, j++) {
                if (i == j)
                    dp[i][j] = gap;
                else if (i + 1 == j && arr[i] == arr[j])
                    dp[i][j] = gap;
                else {
                    if (arr[i] == arr[j] && dp[i + 1][j - 1] != 0)
                        dp[i][j] = gap;
                    else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }

                }
            }
        }
        return dp[0][n - 1];

    }

    public static void main(String args[]) {
        String s = "adkjf;lajd;ljfalsdjlf";
        char input[] = s.toCharArray();
        int k = fun(input, 0, input.length - 1);
        int k2 = dpfun(input);
        int k4 = s.length() - lps(s);
        int k3 = dpsubstr(input);
        System.out.println(k);
        System.out.println(k2);
        System.out.println(k4);
    }
    
}
