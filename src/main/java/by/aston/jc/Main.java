package by.aston.jc;

import by.aston.jc.task01.MyList;
import by.aston.jc.task01.MyArrayList;

public class Main {
    public static void main(String[] args) {

        MyList<String> myList = new MyArrayList<>();
        myList.add("car");
        myList.add("bicycle");
        myList.add("scooter");
        myList.add("motorcycle");
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println("--------after sort------");
        myList.quickSort(String::compareTo);
        System.out.println(myList);
        System.out.println(myList.get(2));
        myList.delete(2);
        System.out.println(myList);
        myList.update(1, "track");
        System.out.println(myList);
        System.out.println(myList.size());
        myList.clear();
        System.out.println(myList);
    }
}