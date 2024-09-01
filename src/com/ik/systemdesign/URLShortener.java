package com.ik.systemdesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URLShortener {

    private int counter = 0;
    private String digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final Map<String, String> urlMap = new HashMap<>();
    private String encode(final String longURL, int X) {
        counter++;
        int currentVal = counter;
        String result = "";
        while (currentVal >= X) {
            int reminder = currentVal % X;
            result = result.concat(String.valueOf(digits.charAt(reminder)));
            currentVal = currentVal / X;
        }
        if (currentVal > 0) {
            result = result.concat(String.valueOf(digits.charAt(currentVal)));
        }
        final StringBuilder builder = new StringBuilder(result).reverse();
        final String shortURL = "".concat(builder.toString());
        urlMap.put(shortURL, longURL);
        return "http://bit.ly/".concat(shortURL);
    }
}
