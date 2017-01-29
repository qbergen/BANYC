package com.example.queenabergen.banyc;

/**
 * Created by queenabergen on 1/29/17.
 */

public class UserEntryExpectation {
    public static boolean checkEmail(String emailInput) {
        if (!emailInput.contains("@") && !emailInput.contains(".com")) {
            return false;
        } else {

        }
        return true;
    }
}
