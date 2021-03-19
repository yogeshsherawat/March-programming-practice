package March;

public class max_gcd_in_an_array {
    
    public static void main(String args[]) {

        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        int count[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i] / 2; j++) {
                if (arr[i] % j == 0)
                    count[j]++;
            }
        }

        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        int ans = 0;

        for (int i = 1; i <= max; i++)
            System.out.print(count[i] + " ");
        System.out.println();
        for (int i = 1; i <= max; i++) {
            if (count[i] > 1)
                ans = i;
        }
        System.out.println(ans);

    }
    
}
