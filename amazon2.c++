package com.company;

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

public class Main{

    public static void main(String args[]) {
        String s = "abcd";
        HashMap<Character, Integer> map = new HashMap<>();
        int[] frq = new int[27];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c,i);

            ArrayList<Paer> list = new ArrayList<>();
            for (char key : map.keySet()) {
                int value = map.get(key);
                list.add(new Paer(key, value));
            }
            Collections.sort(list, new PaerSort());


            int size = map.size();


            int prevIndex = 0;
            for (int j = 0; j < list.size(); j++) {
                Paer p = list.get(j);
                int currIndex = p.b;
                int count = currIndex - prevIndex + 1;
                frq[size] += count;
                size--;
                if (p.a == c)
                    size++;
                prevIndex = currIndex + 1;

            }


        }

        for (int i = 25; i >= 1; i--)
            frq[i] += frq[i + 1];
        for(int i=1;i<=26;i++)
            System.out.print(frq[i]+" ");

    }

}