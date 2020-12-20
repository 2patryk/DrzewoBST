package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        BST myBST = new BST();

        System.out.println("Enter numbers of elements in tree");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        List<Integer> numbers = getRandomUniqueNumbers(num);
        numbers.forEach(myBST::insert);

        myBST.printByOrder(BSTOrder.IN);

        System.out.println("Enter numbers to find");
        int num2 = in.nextInt();

        System.out.println("Search results");
        System.out.println(myBST.findKey(num2));

        System.out.println("Min node");
        System.out.println(myBST.minNode().key);
        System.out.println("Max node");
        System.out.println(myBST.maxNode().key);

    }

    public static List<Integer> getRandomUniqueNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n * 5; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return list.stream().limit(n).collect(Collectors.toList());
    }
}
