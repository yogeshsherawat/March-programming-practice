package March;

import java.util.*;

public class amazon_interview {
    
    public static void sol(int a, int b, int c, int d, int[] arra, int[] arrb, int[] arrc, int[] arrd, int budget) {

        // ques
        // give 4 arrays of cost of different items
        // a = { 1, 2 ,3}

        // intial dp

        int dp[] = new int[budget + 1];
        for (int i = 0; i <= budget; i++)
            dp[i] = 0;
        dp[0] = 1;
        // a start
        int dpa[] = new int[budget + 1];
        for (int i = 0; i <= budget; i++)
            dpa[i] = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= budget; j++) {
                if (dp[j] > 0 && j + arra[i] <= budget)
                    dpa[j + arra[i]] += dp[j];
            }
        }
        for (int i = 0; i <= budget; i++)
            System.out.print(dpa[i] + " ");
        System.out.println();
        // b start
        int dpb[] = new int[budget + 1];
        for (int i = 0; i <= budget; i++)
            dpb[i] = 0;
        for (int i = 0; i <= budget; i++) {
            if (dpa[i] > 0) {
                for (int j = 0; j < b; j++) {
                    if (i + arrb[j] <= budget)
                        dpb[i + arrb[j]] += dpa[i];
                }
            }
        }
        for (int i = 0; i <= budget; i++)
            System.out.print(dpb[i] + " ");
        System.out.println();

        // c start
        int dpc[] = new int[budget + 1];
        for (int i = 0; i <= budget; i++)
            dpc[i] = 0;
        for (int i = 0; i <= budget; i++) {
            if (dpb[i] > 0) {
                for (int j = 0; j < c; j++) {
                    if (i + arrc[j] <= budget)
                        dpc[i + arrc[j]] += dpb[i];
                }
            }
        }

        for (int i = 0; i <= budget; i++)
            System.out.print(dpc[i] + " ");
        System.out.println();

        // d start
        int dpd[] = new int[budget + 1];
        for (int i = 0; i <= budget; i++)
            dpd[i] = 0;
        for (int i = 0; i <= budget; i++) {
            if (dpc[i] > 0) {
                for (int j = 0; j < d; j++) {
                    if (i + arrd[j] <= budget) {
                        dpd[i + arrd[j]] += dpc[i];
                    }
                }
            }
        }

        for (int i = 0; i <= budget; i++)
            System.out.print(dpd[i] + " ");
        System.out.println();
        int sum = 0;
        for (int i : dpd)
            sum += i;
        System.out.println(sum);

    }

    

    public static void main(String args[]) {
        // setup start
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int arra[] = new int[a];
        int arrb[] = new int[b];
        int arrc[] = new int[c];
        int arrd[] = new int[d];
        for (int i = 0; i < a; i++)
            arra[i] = sc.nextInt();
        for (int i = 0; i < b; i++)
            arrb[i] = sc.nextInt();
        for (int i = 0; i < c; i++)
            arrc[i] = sc.nextInt();
        for (int i = 0; i < d; i++)
            arrd[i] = sc.nextInt();
        int budget = sc.nextInt();
        // setup end-------------------

        // solution dp call
        sol(a, b, c, d, arra, arrb, arrc, arrd, budget);
        // merge and binary call
        sc.close();

    }
    
}
