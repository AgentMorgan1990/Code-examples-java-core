package ru.examples.stream_api.stream;

import ru.examples.stream_api.stream.supporting_code.*;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;


/**
 *
 * StreamApi - это методы работы с коллекциями.
 * Хорошим тоном будет не возвращать и не получать стримы в методах, а возвращать именно коллекции, т.к. любое изменение
 * в стриме, может изменить остальную логику выполнения программы.
 *
 * Операции в стримах делятся на два типа - промежуточные и терминальные
 */


public class ExamplesOfUsingStreamAPI {


    public static void main(String[] args) throws IOException {

        List<Employee> emps = List.of(
                new Employee("Michael", "Smith", 243, 43, Position.CHEF),
                new Employee("Jane", "Smith", 523, 40, Position.MANAGER),
                new Employee("Jury", "Gagarin", 6423, 26, Position.MANAGER),
                new Employee("Jack", "London", 5543, 53, Position.WORKER),
                new Employee("Eric", "Jackson", 2534, 22, Position.WORKER),
                new Employee("Andrew", "Bosh", 3456, 44, Position.WORKER),
                new Employee("Joe", "Smith", 723, 30, Position.MANAGER),
                new Employee("Jack", "Gagarin", 7423, 35, Position.MANAGER),
                new Employee("Jane", "London", 7543, 42, Position.WORKER),
                new Employee("Mike", "Jackson", 7534, 31, Position.WORKER),
                new Employee("Jack", "Bosh", 7456, 54, Position.WORKER),
                new Employee("Mark", "Smith", 123, 41, Position.MANAGER),
                new Employee("Jane", "Gagarin", 1423, 28, Position.MANAGER),
                new Employee("Sam", "London", 1543, 52, Position.WORKER),
                new Employee("Jack", "Jackson", 1534, 27, Position.WORKER),
                new Employee("Eric", "Bosh", 1456, 32, Position.WORKER)
        );

        List<Department> deps = List.of(
                new Department(1, 0, "Head"),
                new Department(2, 1, "West"),
                new Department(3, 1, "East"),
                new Department(4, 2, "Germany"),
                new Department(5, 2, "France"),
                new Department(6, 3, "China"),
                new Department(7, 3, "Japan")
        );


        /**
         * Примеры создания стримов:
         *  Files.lines()                                       - создание стрима строк прямо из файла
         *  Files.list()                                        - создание стрима путей
         *  Files.walk()                                        - создание стрима путей с заходом внутри папок с указанной глубиной
         *  IntStream.of()                                      - создание стрима интов
         *  DoubleStream.of()                                   - создание стрима даблов
         *  IntStream.range()                                   - создание стрима интов от и до (невключительно)
         *  IntStream.rangeClosed()                             - создание стрима интов (включительно)
         *  Arrays.stream()                                     - создание стрима из массива примитивов
         *  Stream.of()                                         - создание стрима
         *  Stream<? extends Serializable> stream = Stream.of() - создание стрима с приведением/кастом данных
         *  Stream.<String>builder()                            - создание стрима строк через билдер
         *  emps.stream()                                       - стрим из коллекции
         *  emps.parallelStream()                               - создание стрима для обработки в несколько потоков,
         *  есть смысл использовать только на больших коллекциях, т.к. на маленьких только потеряем производительность
         *  на распараллеливание и обратное объединение
         *
         *  Stream.generate()                                   - создание стримов из функций, беспонечная
         *  последовательность, объекты изначально не содержаться, а генерируются при обращении к этому стриму
         *
         *  Stream.iterate()                                    - получение условно бесконечного стрима, который будет создаваться с шагом
         *  Stream.concat()                                     - объединение двух стримов
         */


        Stream<String> lines = Files.lines(Paths.get("1.txt"), Charset.defaultCharset());
        Stream<Path> list = Files.list(Paths.get("./"));
        Stream<Path> walk = Files.walk(Paths.get("./"), 3);

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.45, 5.67, 7);
        IntStream range = IntStream.range(10, 100); //10...99
        IntStream intStream1 = IntStream.rangeClosed(10, 100); //10...100

        int[] ints = {1, 2, 3, 4};
        IntStream intStream2 = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("1", "2", "3", "4");
        Stream<? extends Serializable> stream = Stream.of(1, "2", "3");
        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("John")
                .build();
        Stream<Employee> stream1 = emps.stream();
        Stream<Employee> employeeStream = emps.parallelStream();
        Stream<Event> generate = Stream.generate(() -> new Event(UUID.randomUUID(), LocalDateTime.now(), ""));
        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);
        Stream<String> concat = Stream.concat(stringStream,build);

//        concat.forEach(e-> System.out.println(e));
//        generate.forEach(e-> System.out.println(e));
//        iterate.forEach(e-> System.out.println(e));
//        walk.forEach(e -> System.out.println(e));
//        list.forEach(e -> System.out.println(e));
//        lines.forEach(e -> System.out.println(e));

        /**
         * Терминальные операции - завершающая операция, после нихнельзя ещё раз вызвать стрим, eager операции
         *
         * .count()                     - посчитать кол-во объектов в стриме
         * .forEach()                   - обойти все элементы стрима/коллекции
         * .forEachOrdered()            - спользуем при parallelStream() - гарантируется обход всех стримов
         * .toArray()                   - преобразование в массив
         * .reduce()                    - сокращение кол-ва элементов - например сложение всех интов
         * .average()                   - получить среднее
         * .max()                       - макс
         * .min()                       - мин
         * .summaryStatistics()         - возвращает объект IntSummaryStatistics с макс. мин, средним и суммой и количеством
         * .findAny()                   - для однопоточного стрима отработает одинаково - возьмёт первый элемент, для параллельных любой
         * .findFirst()                 - гарантировано возьмёт первый, даже из паралельных стримов
         * .noneMatch()                 - возвращает булен, не один не соответствует условию
         * .anyMatch()                  - возвращает булеан, хотябы один сооветствует условию
         * .allMatch()                  - возвращает булеан, все соответствуют условию
         *
         * .collect()                   - преобразование в коллекцию
         *  Collectors.toList()
         *  Collectors.toSet()
         *  Collectors.toMap()
         *  Collectors.counting()       - подсчёт кол-ва элементов в стриме
         *  Collectors.averagingInt()   - считаем среднее значение
         *  Collectors.joining()        - объединение в одну строку
         *  Collectors.groupingBy()     - сборка в мапу
         * */
        emps.stream().count();
        emps.stream().forEach(employee -> System.out.println(employee.getAge()));
        emps.stream().forEachOrdered(employee -> System.out.println(employee.getAge()));
        emps.stream().collect(Collectors.toList());
        Object[] emp1 = emps.stream().toArray();
        emps.stream().collect(Collectors.toMap(
                emp -> emp.getId(),
                emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())
        ));
        emps.stream().collect(Collectors.toMap(
                emp -> emp.getId(),
                Function.identity()
        ));

        IntStream intStream3 = IntStream.of(100, 200, 300);
        Integer integer = intStream3.reduce(((left, right) -> left + right)).orElse(0);
        IntStream.of(100, 200, 300).average();
        IntStream.of(100, 200, 300).max();
        IntStream.of(100, 200, 300).min();
        IntStream.of(100, 200, 300).summaryStatistics();
        IntSummaryStatistics intSummaryStatistics = emps.stream().mapToInt(e -> e.getAge()).summaryStatistics();
        System.out.println(intSummaryStatistics);

        emps.stream().max(((o1, o2) -> o1.getAge() - o2.getAge()));
        emps.stream().max((Comparator.comparingInt(Employee::getAge)));

        emps.stream().findAny();
        emps.stream().findFirst();

        emps.stream().noneMatch(employee -> employee.getAge() > 60);                    //true
        emps.stream().anyMatch(employee -> employee.getPosition() == Position.CHEF);    //true
        emps.stream().allMatch(employee -> employee.getAge() > 18);                     //true

//        System.out.println(integer);
//        System.out.println(Arrays.toString(emp1));

        /**
         * Промежуточные операции - все методы lazy, операции не будут выполнены, пока не будет выполнена eager операция
         *
         * .mapToLong() - преобразование в другой тип данных
         * .mapToObj() - преобразование и создание объекта с помощью данных из стрима
         * .distinct() - убрать дубликаты
         * .filter() - фильтрование
         * .skip() - пропустить кол-во объектов с начала стрима
         * .limit() - отобразить только первые записи
         * .sorted() - сортировка
         * .map() - преобразование элементов
         * .peek() - провести действие с каждым элементом
         * .takeWhile() - оставляет элементы, до выполнени условия (когда выполняетс условия стрим дальше не отрабатывает)
         * .dropWhile() - оставляет элементы после выполнения условия (включительно) (отрабатывает начиная с выполнения условия)
         * .flatMap() - работа со стримами стримов, можно например увеличить кол-во элементов
         * */

        LongStream longStream = IntStream.of(1, 34, 56, 78).mapToLong(Long::valueOf);
        IntStream.of(100, 200, 300)
                .mapToObj(value -> new Event(UUID.randomUUID(),
                        LocalDateTime.of(value, 12, 1, 12, 0),
                        ""));

        IntStream.of(100, 200, 300, 100, 100).distinct();

        emps.stream().filter(employee -> employee.getPosition() != Position.CHEF);
        emps.stream().skip(3);
        emps.stream().limit(5);
        emps.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge());
        emps.stream().map(emp->String.format("%s %s", emp.getLastName(), emp.getFirstName()));
        emps.stream().peek(employee -> employee.setAge(18));
        emps.stream().takeWhile(employee -> employee.getAge() > 30).forEach(System.out::println);
        System.out.println();
        emps.stream().dropWhile(employee -> employee.getAge() > 30).forEach(System.out::println);
        IntStream.of(100, 200, 300)
                .flatMap(value -> IntStream.of(value-50,value))
                .forEach(System.out::println);

//        firstEx();
//        filterEx();
//        flatMapEx();
//        System.out.println(readFileToString());
    }

    /**
     * Пример применения filter() и forEach()
     * filter() отдаёт объект, реализующий обобщённый функциональный интерфейс Predicate
     * возвращает boolean, если true, то проходит фильтр
     * <p>
     * forEach реализует функциональный интерфейс Consumer (что-то потребляет)
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
     * <p>
     * limit() взять из потока n - первых элементов
     */
    private static void secondEx() {

        // Создаем список целых чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Реализация map() без использования лямбды
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

        // Реализация map() с использованием лямбды
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
     * Пример применения sorted() , filter(), map()
     * sorted() реализует функциональный интерфейс Comparator (сравнение одного элемента с другим)
     */
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

    /**
     * Пример использования distinct()
     * distinct() - убирает дублирующиеся значения в из потока
     * <p>
     * System.out::println - передать каждый элемент в потоке в качестве аргумента в статический метод println
     * <p>
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
        Stream.of("A", "Aaa", "AAaa").map(String::length);
    }

    /**
     * Пример использования allMatch(), anyMatch() и noneMatch()
     * allMatch(), anyMatch(), noneMatch()  реализуют функциональный интерфейс Predicate - все объекты в стриме должны удовлетворять этому условию
     * <p>
     * allMatch() - все объекты в стриме должны удовлетворять этому условию
     * anyMatch() - хоть один элемент должен удовлетворять условию
     * noneMatch() - не один элемент не должен удовлетворять условию
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
//        List<Integer> wordsLength = list.stream().map(String::length).collect(Collectors.toList());
        List<Integer> wordsLength = list.stream().map(strToLen).collect(Collectors.toList());

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
     */
    private static void intStreamsEx() {
        IntStream myIntStream = IntStream.of(10, 20, 30, 40, 50);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().mapToInt(v -> v).sum();

        IntStream.rangeClosed(2, 10).filter(n -> n % 2 == 0).forEach(System.out::println);
    }


    /**
     * Примеры создания стримов
     */
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

    /**
     * Задача посчитать кол-во повторяющихся слов в файле
     * <p>
     * Пример использования flatMap() - объединение стримов в один стрим
     * Collectors.groupingBy() - приводим к мапе
     * Collectors.counting() - подсчёт кол-ва элементов в стриме
     */
    public static Map<String, Long> countWordsInFile(Path path) {
        try {
            Map<String, Long> out = Files.lines(path)
                    .map(line -> line.split("\\s"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            return out;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file: " + path.getFileName().toString());
        }
    }
}

