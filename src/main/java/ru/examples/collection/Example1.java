package ru.examples.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Example1 {


    public static void main(String[] args) {
        String[] words = new String[]{
                "Java", "Strategy", "On-bord", "System"
        };

        HashMap<Character, HashSet<String>> dictionary = new HashMap<>();


        for (String word : words) {
            if (!dictionary.containsKey(word.charAt(0))) {
                dictionary.put(word.charAt(0), new HashSet<>());
                dictionary.get(word.charAt(0)).add(word);
            } else {
                dictionary.get(word.charAt(0)).add(word);
            }
        }

        System.out.println(dictionary);
    }
}
