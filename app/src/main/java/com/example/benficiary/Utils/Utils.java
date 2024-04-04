package com.example.benficiary.Utils;

public class Utils {
    /**
     * Converts a date string from "MMddyyyy" format to "MM/dd/yyyy".
     *
     * @param dob The date of birth string in "MMddyyyy" format.
     * @return The formatted date of birth string in "MM/dd/yyyy" format.
     */
    public static String convertDateFormat(String dob) {
        if (dob == null || dob.length() != 8) {
            return "";
        }
        String month = dob.substring(0, 2);
        String day = dob.substring(2, 4);
        String year = dob.substring(4, 8);

        return month + "/" + day + "/" + year;
    }
}
