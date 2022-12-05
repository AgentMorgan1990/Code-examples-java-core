package ru.examples.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Операции в стримах делятся на два типа - промежуточные и
 * терминальные (может и должна быть только одна, для завершения операции над стримом)
 *
 *
 * Терминальные операции (всего две - collect() и forEach()) :
 * collect()
 *
 * stream.collect(Collectors.toList())
 * stream.collect(Collectors.counting()) - подсчёт кол-ва элементов в стриме
 * stream(array).collect(Collectors.averagingInt(s -> s.length()) - считаем среднее значение
 * stream(array).filter(str -> str.startsWith("A")).collect(Collectors.joining(" и ", "Перечисленные слова [", "] начинаются на букву A")) - вывести все слова на букву A
 * joining() принимает в качестве аргумента разделитель, префикс и суффикс
 * collect(Collectors.groupingBy()) - сборка в мапу
 *
 * forEach()
 *
 * count() возвращает количество элементов в стриме
 * reduce() выполняет роль сумматора по всем элементам стрима
 * stream.reduce((i1, i2) -> i1 > i2 ? i1 : i2).ifPresent(System.out::println)
 *
 *
 * Промежуточные операции:
 *
 * filter()
 * sort()
 * map()
 * limit()
 * distinct()
 * allMatch()
 * anyMatch()
 * noneMatch()
 * findAny()
 * findFirst()
 * reduce()
 *
 */

//todo вынести описание каждой промежуточной операции в отдельный пример 1:07
//todo добавить gitignore

public class App {
    public static void main(String[] args) {
//                firstEx();
//                filterEx();
//        flatMapEx();
        System.out.println(readFileToString());
    }

    /**
     * Пример применения filter()
     * filter() отдаёт объект, реализующий обобщённый функциональный интерфейс Predicate,
     * в котором прописан метод test(Integer integer).
     * Каждый объект стрима будет передан этому методу, и если метод возвращает true, то объект проходит
     * фильтр, в противном случае — отсеивается
     *
     * forEach реализует функциональный интерфейс Consumer (что-то потребляет)
     *
     *
     */
    private static void filterEx() {

        //Создание стрима без использования лямбды
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //Создание стрима с использованием лямбды
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));
    }



    /**
     * Пример применения map() и limit()
     * map() реализует функциональный интерфейс Function (преобразование одного объекта в другой с помощью метода apply)
     * limit() взять из потока n - первых элементов
     */
    private static void secondEx() {
        // Создаем список целых чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> out1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer * integer;
                    }
                })
                .limit(2)
                .collect(Collectors.toList());


        List<Integer> out2 = numbers.stream()                       // преобразуем список целых чисел в поток данных и начинаем обработку
                .filter(n -> n % 2 == 0)                            // фильтруем поток, оставляем в нем только четные числа
                .map(integer -> integer * integer)                  // преобразуем каждый элемент потока int -> int, умножая на 2
                .limit(2)                                   // оставляем в потоке только 2 первых элемента
                .collect(Collectors.toList());                      // собираем элементы потока в лист
        System.out.println(numbers);
        System.out.println(out1);
        System.out.println(out2);

    }


    /**
     * Пример использования distinct()
     * distinct() - убирает дублирующиеся значения в из потока
     *
     * System.out::println - передать каждый элемент в потоке в качестве аргумента в статический метод println
     *
     * String::length - вызвать у каждого объекта его метод length
     */
    private static void thirdEx() {
        // получаем поток данных из набора целых чисел, находим среди них только уникальные, и каждое
        // найденное значение выводим в консоль
        System.out.println("Первый вариант: ");
        Arrays.asList(1, 2, 3, 4, 4, 3, 2, 3, 2, 1).stream().distinct().forEach(n -> System.out.println(n));
        // делаем то же самое, что и в первом случае, только используем более короткую запись System.out::println
        System.out.println("Второй вариант: ");
        Arrays.asList(1, 2, 3, 4, 4, 3, 2, 3, 2, 1).stream().distinct().forEach(System.out::println);
        Stream.of("A","Aaa","AAaa").map(String::length);
    }

    /**
     * Пример использования allMatch(), anyMatch() и noneMatch()
     * allMatch(), anyMatch(), noneMatch()  реализуют функциональный интерфейс Predicate - все объекты в стриме должны удовлетворять этому условию
     *
     * allMatch() - все объекты в стриме должны удовлетворять этому условию
     * anyMatch() - хоть один элемент должен удовлетворять условию
     * noneMatch() - не один элемент не должен удовлетворять условию
     *
     */
    private static void matchEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list.stream().allMatch(n -> n < 10));
        System.out.println(list.stream().anyMatch(n -> n == 4));
        System.out.println(list.stream().noneMatch(n -> n == 2));
    }

    /**
     * Пример использования Collectors.groupingBy() и Collectors.counting()
     * Collectors.groupingBy() - преобразование стрима в мапу
     * Collectors.counting() - подсчёт кол-ва элементов в стриме
     */
    public static void countExample() {
        Map<Integer, Long> map = Stream.of("A", "BB", "AA", "B", "C", "EE", "NNN", "X", "QQ")
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }

    /**
     * Пример использования map() c передачей своих переопределённых методов в интерфейсах
     */
    private static void mappingEx() {
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s -> s.length();
        Predicate<Integer> evenNumberFilter = n -> n % 2 == 0;
        Function<Integer, Integer> cube = n -> n * n * n;

        Stream.of(1, 2, 3).map(n -> Math.pow(n, 3));
        Stream.of(1, 2, 3).map(cube);

        List<String> list = Arrays.asList("A", "BB", "C", "DDD", "EE", "FFFF");
//        List<Integer> wordsLength = list.stream().map(str -> str.length()).collect(Collectors.toList());
        List<Integer> wordsLength = list.stream().map(String::length).collect(Collectors.toList());
//        List<Integer> wordsLength = list.stream().map(strToLen).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(wordsLength);

        list.stream().map(strToLen).forEach(n -> System.out.println(n));
        list.stream().map(strToLen).forEach(System.out::println);
    }

    /**
     * Пример использования findAny() - получаем любой элемент из стрима, возвращает Optional
     * ifPresent() реализует функциональный интерфейс Consumer (что-то потребляет)
     */
    private static void findAnyEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println);
        Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
    }


    /**
     * Пример использования reduce()
     * reduce() - сокращение кол-ва элементов в стриме, реализует функциональный интерфейс BinaryOperator наследник BiFunction
     * identity - с чего начинаем суммировать
     * описываем правила, как из двух элементов получить один, например (a, b) -> a + b
     */
    private static void reduceEx() {
        //пример без стрима
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer o : list) {
            sum += o;
        }
        //пример со стримом
        int streamSum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum + " " + streamSum);
    }

    /**
     * Пример использования IntStream и его методы
     * mapToInt() приведение стрима к стриму интов
     * у IntStream есть много дополнительных методов работы именно с числами, например
     * sum() - возвращает сумму элементов в стриме
     * average() - возвращает среднее значение элеметов в стриме
     * max() - возвращает максимальное значение в стриме и т.д.
     *
     */
    private static void intStreamsEx() {
        IntStream myIntStream = IntStream.of(10, 20, 30, 40, 50);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().mapToInt(v -> v).sum();

        IntStream.rangeClosed(2, 10).filter(n -> n % 2 == 0).forEach(System.out::println);
    }


    /**
     * Примеры создания стримов
    * */

    private static void streamCreationEx() {
        Arrays.asList("A", "B", "C").stream().forEach(System.out::println);
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        Arrays.stream(new int[]{4, 3, 2, 1}).forEach(System.out::println);
    }



    /**
     * Пример решения задачи подсчёта кол-ва уникальных слов в строке
     * Разбиваем сплитом слова по пробелу, выбираем только уникальные слова и подсчитываем их
     */
    private static void simpleStringEx() {
        System.out.println(Arrays.stream("A B CC B C AA A A B CC C".split("\\s")).distinct().count());
    }


    /**
     * Пример использования flatMap()
     * flatMap() - преобразование стрима стримов в один стрим
     * Задача - необходимо найти в файле все уникальные слова и их отпечатать,
     * два первых решения неверные, третье верное с использованием flatMap()
     *
     */
    private static void flatMapEx() {
        try {
            //находим только уникальные массивы
            Files.lines(Paths.get("src/main/java/ru/examples/stream_api/text.txt"))
                    .map(line -> line.split("\\s"))
                    .distinct()
                    .forEach(arr -> System.out.println(Arrays.toString(arr)));
            System.out.println("----------------------");

            //находим только уникальные стримы
            Files.lines(Paths.get("src/main/java/ru/examples/stream_api/text.txt"))
                    .map(line -> line.split("\\s")) // arr[0] arr[1] arr[2] arr[3]
                    .map(Arrays::stream)
                    .distinct()
                    .forEach(System.out::println);
            System.out.println("----------------------");

            //находим уникальные слова
            System.out.println(Files.lines(Paths.get("src/main/java/ru/examples/stream_api/text.txt"))
                    .map(line -> line.split("\\s")) // arr[0] arr[1] arr[2] arr[3]
                    .flatMap(Arrays::stream)
                    .distinct()
                    .collect(Collectors.joining(", ", "Уникальные слова: ", ".")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Пример использования Collectors.joining() - объединяем в одну строку по правилам
     */
    public static String readFileToString() {
        String str = "";
        try {
            str = Files.lines(Paths.get("src/main/java/ru/examples/stream_api/text.txt"))
                    .collect(Collectors.joining("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


    private static void firstEx() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, Person.Position.MANAGER),
                new Person("Bob2", 44, Person.Position.DIRECTOR),
                new Person("Bob3", 25, Person.Position.ENGINEER),
                new Person("Bob4", 42, Person.Position.ENGINEER),
                new Person("Bob5", 55, Person.Position.MANAGER),
                new Person("Bob6", 19, Person.Position.MANAGER),
                new Person("Bob7", 33, Person.Position.ENGINEER),
                new Person("Bob8", 37, Person.Position.MANAGER)
        ));

        //пример решения задачи без стрима
        List<Person> engineers = new ArrayList<>();
        for (Person o : persons) {
            if (o.getPosition() == Person.Position.ENGINEER) {
                engineers.add(o);
            }
        }
        engineers.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        List<String> engineersNames = new ArrayList<>();
        for (Person o : engineers) {
            engineersNames.add(o.getName());
        }
        System.out.println(engineersNames);

        //Пример решения задачи стримом
        List<String> engineersNamesShortPath = persons.stream()
                .filter(p -> p.getPosition() == Person.Position.ENGINEER)
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .map(person -> person.getName())
                .collect(Collectors.toList());
        System.out.println(engineersNamesShortPath);
    }
}

