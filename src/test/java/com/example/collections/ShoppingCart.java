package com.example.collections;

import java.util.ArrayList;
import java.util.Collection;

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

public class ShoppingCart {
    private Collection<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public int getTotalItems() {
        return items.size();
    }

    public void clearCart() {
        items.clear();
    }

    public void displayCart() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
