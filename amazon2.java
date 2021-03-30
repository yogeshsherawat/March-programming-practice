package March;

import java.util.*;

class Paer {
    char a;
    int b;

    public Paer(char a, int b) {
        this.a = a;
        this.b = b;
    }
}

class PaerSort implements Comparator<Paer> {
    @Override
    public int compare(Paer o1, Paer o2) {
        return o1.b - o2.b;
    }

}

public class amazon2 {

    public static void main(String args[]) {
        String s = "abcabd";
        HashMap<Character, Integer> map = new HashMap<>();
        int[] frq = new int[27];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int size = map.size();
            if (!map.containsKey(c))
                size++;
            frq[1]++;
            System.out.println();
            ArrayList<Paer> list = new ArrayList<>();
            for (char key : map.keySet()) {
                int value = map.get(key);
                list.add(new Paer(key, value));
            }
            Collections.sort(list, new PaerSort());

            int prev = 0;
            for (int j = 0; j < list.size(); j++) {
                Paer p = list.get(j);
                int index = p.b;
                int xtr = index - prev + 1;
                frq[size] += xtr;
                size--;
                if (p.a == c)
                    size++;
                prev = index + 1;

            }

            map.put(c, i);

        }

        for (int i = 25; i >= 1; i--)
            frq[i] += frq[i + 1];
        int ans[] = new int[26];
        for(int i=0;i<26;i++)
            ans[i] = frq[i + 1];    

    }

}