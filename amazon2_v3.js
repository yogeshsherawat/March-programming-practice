package com.company;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.*;

class Paer{
    char a;
    int b;
    public  Paer(char a,int b){
        this.a = a;
        this.b = b;
    }
}
class PaerSort implements Comparator<Paer>{
    @Override
    public int compare(Paer o1, Paer o2) {
        return o1.b-o2.b;
    }


}

public class Main {

    public static void main(String args[]) {
        String s= "abcabd";
        HashMap<Character,Integer> map =new HashMap<>();
        int[] frq = new int[27];
        for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
                int size = map.size();
                if(!map.containsKey(c))
                    size++;
                frq[1]++;
                for(int k=1;k<=26;k++)
                    System.out.print(frq[k]+" ");
                System.out.println();
                ArrayList<Paer> list = new ArrayList<>();
                for(char key:map.keySet()){
                    int value= map.get(key);
                    list.add(new Paer(key,value));
                }
                Collections.sort(list,new PaerSort());
                for(int j=0;j<list.size();j++){
                    Paer p = list.get(j);
                    System.out.println(p.a+" "+p.b);
                }
                System.out.println("--------------");

                int prev = 0;
                for(int j=0;j<list.size();j++){
                    Paer p = list.get(j);
                    int index = p.b;
                    int xtr = index-prev+1;
                    System.out.println(xtr);
                    frq[size]+=xtr;
                    size--;
                    if( p.a == c)
                    size++;
                    prev = index+1;
                    for(int k=1;k<=26;k++)
                        System.out.print(frq[k]+" ");
                    System.out.println();

                }


                map.put(c,i);


        }

        System.out.println("ans-------------------");
        for(int i=1;i<=26;i++)
            System.out.print(frq[i]+" ");
        System.out.println();
        for(int i=25;i>=1;i--)
            frq[i]+=frq[i+1];
        for(int i=1;i<=26;i++)
            System.out.print(frq[i]+" ");
    }




}


