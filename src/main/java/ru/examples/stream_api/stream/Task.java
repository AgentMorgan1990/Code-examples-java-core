package ru.examples.stream_api.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task {

    /**
     * Задача отсоритировать строку ао длине слов и оставить в таком -же формате, первая буква больная, точка в конце
     */

    public static void main(String[] args) {
        String str = "Привет пока java три шетьдесят.";
        System.out.println(sortString(str));
    }


    public static String sortString(String str) {

        str = str.substring(0, str.length() - 1);

        String string = Arrays.stream(str.split("\\s"))
//                .map(String::toLowerCase)
                .sorted((a1, a2) -> a1.length() - a2.length())
                .collect(Collectors.joining(" ", "", "."));

        string = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
        return string;
    }
}
