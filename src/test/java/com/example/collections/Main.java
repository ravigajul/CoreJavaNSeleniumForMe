package com.example.collections;

public class Main {
    public static void main(String[] args) {
        Item windowsPc = new Item("Windows", 1000.0);
        Item macPc =    new Item("Apple Mac", 2000.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(macPc);
        cart.addItem(windowsPc);

        cart.displayCart();
        cart.removeItem(macPc);
        cart.displayCart();

        cart.getTotalItems();

        
    }
}
