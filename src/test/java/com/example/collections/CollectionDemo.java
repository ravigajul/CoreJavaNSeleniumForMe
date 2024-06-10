package com.example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * add()
 * AddAll(Collection<E> c)
 * remove
 * removeAll()
 * retainAll(Collection<E> c)
 * clear()
 * isEmpty()
 * contains(Object o)
 * containsAll(Collection<E> c)
 * equals(Object o)
 * size()
 * iterator()
 * toArray()
 */

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<String>();
        c1.add("A");
        c1.add("B");
        c1.add("C");
        c1.add("D");
        c1.add("E");

        Collection<String> c2 = new ArrayList<String>();
        c2.add("E");
        c2.add("F");
        c2.add("G");
        c2.add("H");

        System.out.println("Before Removing E : " + c1);
        System.out.println("Removed E ? : " + c1.remove("E"));
        System.out.println("After Removing E: " + c1);

        System.out.println("Added E: " + c1.add("E"));
        System.out.println("After Adding E : " + c1);

        System.out.println("Size of Collection c1: " + c1.size());

        System.out.println("Added All c2: " + c1.addAll(c2));
        System.out.println("After adding  All c2: " + c1);
        System.out.println("Removed all c2 : " + c1.removeAll(c2));
        System.out.println("After removing all c2 : " + c1);

        System.out.println("Adding E: " + c1.add("E"));
        System.out.println("After adding E" + c1);

        System.out.println(" Retaining all c2? : " + c1.retainAll(c2));
        System.out.println("After Retaining All c2" + c1);

        System.out.println("Add all c2 : " + c1.addAll(c2));
        System.out.println("After adding all c2: " + c1);

        Iterator<String> iterator = c1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
