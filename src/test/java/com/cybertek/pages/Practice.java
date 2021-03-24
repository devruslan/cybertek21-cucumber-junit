package com.cybertek.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>(Arrays.asList("Abc", "Def", "Def", "Def", "Ghi", "Jkl", "Mno", "Def", "Pqr", "Stu", "Jkl", "Vwx", "Yz"));
        List<String> list2 = new ArrayList<>();
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        for (int i = 0; i < list1.size(); i++) {
            if (!list2.contains(list1.get(i))) list2.add(list1.get(i));
        }
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);

    }
}
