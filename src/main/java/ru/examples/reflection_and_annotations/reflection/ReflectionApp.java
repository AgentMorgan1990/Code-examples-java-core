package ru.examples.reflection_and_annotations.reflection;


import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Java Reflection API позволяет исследовать классы, интерфейсы, поля и методы во время выполнения
 * программы, ничего не зная о них на этапе компиляции. Также с ее помощью можно создавать новые
 * объекты, вызывать у них методы и работать с полями.
 * <p>
 * При запуске программы не все классы сразу подгружаются в метаспейс(область памяти)и далее попадают в драйвер менеджер, это
 * обычно происходит по мере необходимости в программе
 * <p>
 * К загрузке классов в метаспейс приводит:
 * 1) создание нового объекта
 * 2) если в классе есть статика при обращении к статическому полю или методу, класс будет подгружен
 * 3) вызов метода Class.forName("ru.examples.reflection_and_annotations.reflection.ReflectionApp")
 * 4) при создании наследников этого класса или интерефейсов, которые реализует созданный класс
 * статический блок инициализации срабатывает единвжды, при загрузке класса в память static {},
 * в основном используется для инициализации переменных
 * <p>
 * Поскольку мы собираемся получать информацию о классах в процессе выполнения программы, то
 * необходимо научиться получать класс в виде Java объекта (объекта типа Class). Для этого есть три
 * возможных варианта.
 * <p>
 * 1) У любого Java объекта можно вызвать метод getClass(), который вернет объект типа Class.
 * Class stringClass = "Java".getClass();
 * <p>
 * 2) Запросить объект типа Class напрямую у класса.
 * Class integerClass = Integer.class;
 * Class stringClass = String.class;
 * Class intClass = int.class;
 * Class voidClass = void.class;
 * Class charArrayClass = char[].class;
 * <p>
 * 3) Вызвать статический метод Class.forName(), и передать ему полное имя класса в качестве
 * аргумента.
 * Class jdbcClass = Class.forName("org.sqlite.jdbc");
 */
public class ReflectionApp {

    public static void main(String[] args) throws NoSuchFieldException {

        /**
         * Получение имени класса
         * getName()
         * getSimpleName()
         * */

        Class s = String.class;
        System.out.println("Полное имя класса: " + s.getName());
        System.out.println("Простое имя класса: " + s.getSimpleName());

        /**
         * Модификаторы класса. Метод getModifiers() возвращает значение типа int, из которого, с помощью
         * статических методов класса Modifier, можно определить какие именно модификаторы были
         * применены к классу.
         * */

        Class strClass = String.class;
        int modifiers = strClass.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - final");
        }

        /**
         *  По такому же принципу можно получить модификаторы полей и методов. Для проверки
         * модификаторов используются методы isPublic(), isPrivate(), isAbstract(), isFinal(), isNative(), isInterface(),
         * isSynchronized(), isVolatile(), isStrict(), isTransient(), isProtected(), isStatic().
         *
         * Суперкласс. Метод getSuperclass() позволяет получить объект типа Class, представляющий
         * суперкласс рефлексированного класса. Для получения всей цепочки родительских классов
         * достаточно рекурсивно вызывать метод getSuperclass() до получения null. Его вернет
         * Object.class.getSuperclass(), так как у него нет родительского класса.
         *
         * Интерфейсы, реализуемые классом. Метод getInterfaces() возвращает массив объектов типа Class.
         * Каждый из них представляет один интерфейс, реализованный в заданном классе.
         *
         * Поля класса. Метод getFields() возвращает массив объектов типа Field, соответствующих всем
         * открытым (public) полям класса. Класс Field содержит информацию о полях класса.
         * */

        Class catClass = Cat.class;
        Field[] publicFields = catClass.getFields();
        for (Field o : publicFields) {
            System.out.println("Тип_поля Имя_поля : " + o.getType().getName() + " " + o.getName());
        }

        /**
         * Чтобы получить все поля класса (public, private и protected), применяют метод getDeclaredFields(). Зная
         * имя поля, можно получить ссылку на него через метод getField() или getDeclaredField().
         * */

        Field f = catClass.getDeclaredField("name");

        /**
         * Получить значение поля можно с помощью метода get(), который принимает входным параметром
         * ссылку на объект класса. Для «чтения» примитивных типов применяют методы getInt(), getFloat(),
         * getByte() и другие. Метод set() предназначен для изменения значения поля.
         * */

        try {
            Cat cat = new Cat();
            Field fieldName = cat.getClass().getField("name");
            fieldName.set(cat, "Мурзик");
            Field fieldAge = cat.getClass().getField("age");
            System.out.println(fieldAge.get(cat));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        /**
         * Посредством рефлексии можно получать и изменять значения полей с модификатором доступа
         * private.
         * */

        try {
            ClassWithPrivateField obj = new ClassWithPrivateField(10);
            obj.info();
            Field privateField =
                    ClassWithPrivateField.class.getDeclaredField("field");
            privateField.setAccessible(true);
            System.out.println("get: " + privateField.get(obj));
            privateField.set(obj, 1000);
            obj.info();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        /**
         * Для этого получаем объект типа Field и открываем к нему доступ через setAccessible(true). Затем
         * получаем и изменяем его значение – по аналогии с предыдущим примером. Изменить final поле
         * нельзя даже при помощи рефлексии.
         * */

        /**
         * Методы getConstructors() и getDeclaredConstructors() возвращают массив объектов типа
         * Constructor. Они содержат в себе информацию о конструкторах класса: имя, модификаторы, типы
         * параметров, генерируемые исключения. Если известен набор параметров конструктора, можно
         * получить ссылку на него с помощью getConstructor() или getDeclaredConstructor().
         * */

        Constructor[] constructors = Cat.class.getConstructors();
        for (Constructor o : constructors) {
            System.out.println(o);
        }
        System.out.println("---");
        try {
            System.out.println(Cat.class.getConstructor(new Class[]{String.class, int.class}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * Методы getMethods() и getDeclaredMethods() возвращают массив объектов типа Method, в которых
         * содержится полная информация о методах класса. Если известно имя метода и набор входных
         * параметров, то можно получить ссылку на него с помощью getMethod() или getDeclaredMethod().
         * */

        Method[] methods = Cat.class.getDeclaredMethods();
        for (Method o : methods) {
            System.out.println(o.getReturnType() + " ||| " + o.getName() + " ||| "
                    + Arrays.toString(o.getParameterTypes()));
        }
        try {
            Method m1 = Cat.class.getMethod("jump", null);
            Method m2 = Cat.class.getMethod("meow", int.class);
            System.out.println(m1 + " | " + m2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * Java Reflection позволяет динамически вызвать метод, даже если во время компиляции его имя было
         * неизвестно.
         */

        Cat cat = new Cat("Barsik");
        try {
            Method mMeow = Cat.class.getDeclaredMethod("meow", int.class);
            mMeow.invoke(cat, 5);
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        /**
         * В этом примере сначала в классе Cat находим метод meow. Затем вызываем у него invoke(), который
         * у выбранного объекта вызывает этот метод и принимает два параметра. Первый – это объект класса
         * Cat, а второй – набор аргументов, передаваемых методу meow().
         * Если у метода модификатор доступа private, то получить к нему доступ можно по аналогии с нашим
         * примером о private-поле.
         */

        /**
         * Создание объектов
         *
         * Метод newInstance() позволяет создавать экземпляры класса через объект типа Class и возвращает
         * объект типа Object. Если этот метод вызван у объекта типа Class, то для создания нового объекта
         * используется конструктор по умолчанию. Если он отсутствует – будет брошено исключение. Если
         * вначале получаем объект типа Constructor с заданным набором параметров, то newInstance()
         * использует этот набор.
         *
         */

        try {
            Class someClass = Cat.class;
            Constructor catCounstructor = Cat.class.getConstructor(String.class,
                    String.class, int.class);
            Cat cat1 = (Cat) someClass.newInstance();
            Cat cat2 = (Cat) catCounstructor.newInstance("Murzik", "Black", 3);
        } catch (InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
