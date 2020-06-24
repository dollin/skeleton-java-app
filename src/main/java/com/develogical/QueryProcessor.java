package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        if (query.toLowerCase().contains("largest")) {
            String[] numbers = query.substring(query.indexOf("largest:") + 10).replaceAll("%20", "").split(",");
            return "" + Arrays.stream(numbers).mapToLong(Long::parseLong).max().getAsLong();
        }
        return "";
    }
}
