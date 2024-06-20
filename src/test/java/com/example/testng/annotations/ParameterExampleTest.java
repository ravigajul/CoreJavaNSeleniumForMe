package com.example.testng.annotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExampleTest {

    @Test
    @Parameters({ "username", "password" })
    public void testWithParameters(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Test logic using username and password
    }

}
