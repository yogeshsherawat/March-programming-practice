package com.company;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        int arr[]={2,3,5};
        int n =50;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(pq);
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int k = pq.poll();
            list.add(k);
            for(int j=0;j<arr.length;j++)
            {
                int kk = k*arr[j];

                if(!set.contains(kk)){
                    set.add(kk);
                    pq.add(kk);
                }
            }
        }
        System.out.println(list);


    }

}
