package com.example.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. Dynamic Array
 * 2. Unordered (no indices)
 * 3. Retrieval is slow need to iterate through elements
 * 4. Duplicates not allowed
 * 
 */

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> userNames = new HashSet<>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");
        userNames.add("user5");
        userNames.add("user3"); //Duplicate element, will not be added. Returns false as it doesn't add the existing user name. 


        //retrieving all elements
        for(String userName : userNames){
            System.out.println(userName);
        }

        //retrieve particular user5
        for(String userName: userNames)
        {
            if(userName.contains("user5")){
                System.out.println("User Name found : " + userName);
                break;
            }
        }
    }
}
