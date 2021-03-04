package March;

import java.util.Arrays;

public class box_stacking {


    static class Box implements Comparable<Box> {

        int h, w, d, area;
    public Box(int h, int w, int d) {
        this.h = h;
        this.w = w;
        this.d = d;
    }

    
    @Override
    public int compareTo(Box o) {
        
        return o.area - this.area;
    }

}

    


    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }
    
    public static int solve(Box arr[], int n) {
        int N = 3 * n;
        Box[] narr = new Box[N];
        for (int i = 0; i < n; i++) {
            int k1 = 3 * i;
            int k2 = 3 * i + 1;
            int k3 = 3 * i + 2;
            Box b = arr[i];
            int x = b.h;
            int y = b.w;
            int z = b.d;
            narr[k1] = new Box(x, min(y, z), max(y, z));
            narr[k2] = new Box(y, min(x, z), max(x, z));
            narr[k3] = new Box(z, min(x, y), max(x, y));
        }
        for (int i = 0; i < N; i++) {
            Box b = narr[i];
            b.area = b.d * b.w;
        }
        Arrays.sort(narr);
        for (int i = 0; i < N; i++) {
            Box b = narr[i];
            System.out.println(b.h + " " + b.w + " " + b.d);
        }
        int dp[] = new int[N];
        dp[0] = narr[0].h;
        for (int i = 0; i < N; i++) {
            Box b1 = narr[i];
            for (int j = i - 1; j >= 0; j--) {
                Box b2 = narr[j];
                if (b1.w < b2.w && b1.d < b2.d) {
                    int hh = dp[j] + b1.h;
                    dp[i] = max(hh, dp[i]);
                }
            }
        }



        return dp[N-1];
    }
    
    public static void main(String args[]) {
        System.out.println("trying to resolve error");
        
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);
        int k = solve(arr, 4);
        System.out.println(k);
        

    }
    
}
