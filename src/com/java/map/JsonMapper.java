package com.java.map;

import java.lang.reflect.Field;
import java.util.Map;

import com.java.parser.SimpleJsonParser;

public class JsonMapper {
    public static <T> T mapJsonToObject(String json, Class<T> clazz) throws Exception {
        // Step 1: Parse the JSON string into a Map
        Map<String, Object> jsonMap = SimpleJsonParser.parseJson(json);

        // Step 2: Create a new instance of the target class
        T instance = clazz.getDeclaredConstructor().newInstance();

        // Step 3: Iterate over the fields of the class and set values using reflection
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            if (jsonMap.containsKey(fieldName)) {
                field.setAccessible(true);  // Make the field accessible

                // Get the value from the map and set it to the field
                Object value = jsonMap.get(fieldName);

                // Handle type conversion and set the value
                if (field.getType() == String.class) {
                    field.set(instance, value.toString());
                } else if (field.getType() == int.class) {
                    field.set(instance, Integer.parseInt(value.toString()));
                }
                // Add more type checks as needed for other types (like boolean, double, etc.)
            }
        }

        return instance;
    }
}

