package ru.examples.reflection_and_annotations.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * Аннотации
 * Для создания аннотации создаем интерфейс и ставим символ @ перед ключевым словом interface.
 * Необходимо указать две аннотации:
 *
 * @Retention – сообщает, где будет использоваться аннотация:
 * RetentionPolicy.SOURCE – используется на этапе компиляции и должна
 * отбрасываться компилятором;
 * RetentionPolicy.CLASS – будет записана в .class-файл, но не будет доступна во время
 * выполнения;
 * RetentionPolicy.RUNTIME – будет записана в .class-файл и доступна во время
 * выполнения через Reflection.
 * @Target – к какому типу данных можно подключить эту аннотацию:
 * ElementType.METHOD – метод;
 * ElementType.FIELD – поле;
 * ElementType.CONSTRUCTOR – конструктор;
 * ElementType.PACKAGE – пакет;
 * ElementType.PARAMETER – параметр;
 * ElementType.TYPE – тип;
 * ElementType.LOCAL_VARIABLE – локальная переменная и т.д.
 * <p>
 * Пример автоненерации таблиц по расзмеченным классам
 */
public class AnnotationExample {
    public static void main(String[] args) {
        System.out.println(prepareCreateTableSQL(Cat.class));
    }

    public static String prepareCreateTableSQL(Class cl) {

        if (!cl.isAnnotationPresent(AppTable.class)) {
            throw new IllegalArgumentException("Класс " + cl.getName() + " не предназначен для автогенерации таблиц");
        }

        Map<Class, String> typeManager = new HashMap<>();
        typeManager.put(String.class, "TEXT");
        typeManager.put(int.class, "INTEGER");

        StringBuilder builder = new StringBuilder("CREATE TABLE ");
        builder.append(((AppTable) cl.getAnnotation(AppTable.class)).title());
        builder.append(" (");
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(AppField.class)) {
                builder.append(f.getName()).append(" ").append(typeManager.get(f.getType())).append(", ");
            }
        }
        builder.setLength(builder.length() - 2);
        builder.append(");");
        return builder.toString();
    }
}
