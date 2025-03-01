package com.java.main;

import com.java.map.JsonMapper;

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\": \"John\", \"age\": 30}";

        try {
            Person person = JsonMapper.mapJsonToObject(json, Person.class);
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

