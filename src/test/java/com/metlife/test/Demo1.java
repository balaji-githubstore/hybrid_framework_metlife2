package com.metlife.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo1 {

    @DataProvider
    public Object[][] validData() {
        Object[][] main = new Object[3][2];
        //i -> number of test case
        //j -> number of arguments
        main[0][0] = "king";
        main[0][1] = "king123";

        main[1][0] = "jack";
        main[1][1] = "jack123";

        main[2][0] = "mark";
        main[2][1] = "mark123";

        return main;
    }

    @Test(dataProvider = "validData")
    public void validTest(String username, String password) {
        System.out.println("Validate " + username + password);
    }
}
