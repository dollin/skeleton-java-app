package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }

        if (query.toLowerCase().contains("largest")) {
            String[] numbers = query.substring(query.indexOf("largest:") + 8).replaceAll("%20", "").split(",");
            return "" + Arrays.stream(numbers).map(String::trim).mapToLong(Long::parseLong).max().getAsLong();
        }
        if (query.toLowerCase().contains("plus")) {
            String[] numbers = query.substring(query.indexOf(":%20what%20is") + 15).replaceAll("%20", "").split("plus");
            return "" + Arrays.stream(numbers).map(String::trim).mapToLong(Long::parseLong).sum();
        }
        if (query.toLowerCase().contains("multiplied")) {
            String[] numbers = query.substring(query.indexOf(":%20what%20is") + 15).replaceAll("%20", "").split("multipliedby");
            return "" + Long.valueOf(numbers[0].trim()) * Long.valueOf(numbers[1].trim());
        }
        return "";
    }
}
