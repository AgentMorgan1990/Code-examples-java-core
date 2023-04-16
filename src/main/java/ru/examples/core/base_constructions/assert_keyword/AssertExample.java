package ru.examples.core.base_constructions.assert_keyword;


/**
 * Оно используется на стадии разработки программ для созданиятак называемых утверждений - условий, которые должны быть
 * истинными во время выполнения программы. Например, в программе может быть метод, который всегда возвращает
 * положительное целое значение. Его можно проверить утверждением, что возвращаемое значение больше нуля, используя
 * оператор assert. Если во время выполнения программы условие оказывается истинным, то никаких действий больше не
 * выполняется. Но если условие окажется ложным, то генерируется исключение типа AssertionError. Утверждения часто
 * применяются с целью проверить, что некоторое ожидаемое условие действительно выполняется. В коде окончательной версии
 * программы утверждения, как правило, отсутствуют.
 * <p>
 * Ключевое слово assert имеет две формы. Первая его форма выглядит следующим образом:
 * assert условие;
 * assert условие: выражение;
 *
 * Чтобы разрешить проверку утверждений во время выполнения , следует указать параметр -еа в командной строке.
 * Например, для проверки утверждений в классе AssertDemo нужно ввести следующую команду:
 * java -еа AssertDemo  в Idea есть настройка в панели запуска для VM
 *
 *
 */
public class AssertExample {

    static int val = 3;

    // возвратить целочисленное значение
    static int getNum() {
        return val--;
    }

    public static void main(String args[]) {

        int n;
        for (int i = 0; i < 10; i++) {
            n = getNum();
            assert n > 0; // не nодтвердится, если n == О
            System.out.println(" n равно " + n);
        }
    }
}
