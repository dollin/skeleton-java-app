package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        } else if (query.toLowerCase().contains("banana")) {
            return "Yellow";
        } else if (query.toLowerCase().contains("Eiffel tower")) {
            return "Paris";
        }
        if (query.toLowerCase().contains("largest")) {
            String[] numbers = query.substring(query.indexOf("largest:") + 8).replaceAll("%20", "").split(",");
            return "" + Arrays.stream(numbers).map(String::trim).mapToLong(Long::parseLong).max().getAsLong();
        }
        if (query.toLowerCase().contains("plus")) {
            String[] numbers = query.substring(query.indexOf(":%20what%20is") + 15).replaceAll("%20", "").split("plus");
            return "" + Arrays.stream(numbers).map(String::trim).mapToLong(Long::parseLong).sum();
        } else if (query.toLowerCase().contains("multiplied")) {
            String[] numbers = query.substring(query.indexOf(":%20what%20is") + 15).replaceAll("%20", "").split("multipliedby");
            return "" + Long.valueOf(numbers[0].trim()) * Long.valueOf(numbers[1].trim());
        } else if (query.toLowerCase().contains("primes:")) {
            String[] numbers = query.substring(query.indexOf("primes:") + 7).replaceAll("%20", "").split(",");
            String primes = "";
            for (int i = 0; i < numbers.length; i++) {
                if (isPrime(Integer.valueOf(numbers[i]))) {
                    primes += numbers[i] + ", ";
                }
            }
            return primes.substring(0, primes.length() - 2);
        }

        return "";
    }

    private boolean isPrime(Integer number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}