package com.java.parser;

import java.util.*;

public class SimpleJsonParser {
    public static Map<String, Object> parseJson(String json) {
        Map<String, Object> map = new HashMap<>();

        // Remove the curly braces and split the string by commas
        json = json.trim().substring(1, json.length() - 1).trim();
        String[] keyValuePairs = json.split(",");

        for (String pair : keyValuePairs) {
            // Split the key and value by the colon
            String[] entry = pair.split(":");
            if (entry.length == 2) {
                String key = entry[0].trim().replace("\"", "");  // Remove quotes from keys
                String value = entry[1].trim().replace("\"", "");  // Remove quotes from values

                // If value can be parsed as an integer, parse it
                if (value.matches("-?\\d+")) {
                    map.put(key, Integer.parseInt(value));
                } else {
                    map.put(key, value);
                }
            }
        }
        return map;
    }
}

