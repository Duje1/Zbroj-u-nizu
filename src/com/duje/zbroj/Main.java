package com.duje.zbroj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] niz;
    static String[] strs;
    static int b;
    static Scanner sc;
    static ArrayList<Integer> arrayList;
    public static void main(String[] args) {

        arrayList = new ArrayList<>();

        niz = new int[50];
        sc = new Scanner(System.in);


        System.out.print("Unesite niz: ");
        unos();
        System.out.print("Zadajte broj: ");
        b = sc.nextInt();
        int rezultat = pronadjiRezultat(niz,strs.length,b);
        if(rezultat == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(rezultat);

    }

    private static int pronadjiRezultat(int niz[], int len, int b){
        if (b == 0)
            return arrayList.size();

        if(len == 0 || b < 0)
            return Integer.MAX_VALUE;

        int x = pronadjiRezultat(niz,len - 1,b);
        arrayList.add(niz[len - 1]);

        int y = pronadjiRezultat(niz, len, b - niz[len - 1]);

        arrayList.remove(arrayList.size() - 1);

        return Math.min(x,y);
    }

    private static void unos() {
        Scanner sc = new Scanner(System.in);
        String lines = sc.nextLine();

        strs = lines.trim().split("\\s+");

        for (int i = 0; i < strs.length; i++) {
            niz[i] = Integer.parseInt(strs[i]);
        }
    }
}
