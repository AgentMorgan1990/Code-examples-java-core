package ru.examples.generics;


import java.io.Closeable;
import java.util.List;

/**
 * Обобщения(Дженерики) – это параметризованные типы, которые позволяют объявлять обобщенные классы, интерфейсы и методы, где тип
 * данных, которыми они оперируют, указан в виде параметра. Обобщения добавляют в Java безопасность типов и делают
 * управление проще. Исключается необходимость применять явные приведения типов, так как благодаря обобщениям все
 * приведения выполняются неявно, в автоматическом режиме.
 *
 * Обобщения работают только с ссылочными типами данных. Для работы с примитивами необходимо использовать классы-обертки.
 *
 * Дженерики помогают выявлять ошибки на этапе компиляции, а не на этапе выполнения программы
 *
 * Класс, который использует обобщения, называется обобщённым классом.
 *
 * Колличество обобщений в классе не ограничено, указываем разные буквы, если могут быть разные типы данных.
 *
 * N extends Number - пример ограничения "сверху" класс может быть либо  Number, либо наследником Number. В данном
 * случае у нас появляется возможность пользоваться всем методами класса Number.
 * В роли ограничителя "сверху" может выступать не только класс, но и один или несколько интерфейсов. Для указания
 * нескольких элементов используется оператор & <T extends Number & Closeable>.
 *
 * Ограничение "снизу" <N super Number> - может быть только этим классом или любым из его родителей
 *
 * Пример ограничения "сверху" и "снизу" - ограничени для копирования одного листа в другой, например если мы захотим
 * скопировать животных в котов, такой метод copy() есть у коллекций copy(List<? super T> dst, List<? extends T> src)
 *
 * ? - wildcard - сюда можно отдавать любой тип, но wildcard так жк можно ограничить <? extends Number>
 *
 * Нельзя создавать обзекты и массивы обобщённого типа, а так же статические переменные. Обобщенный класс не может
 * расширять класс Throwable. Значит, создать обобщенные классы исключений невозможно.
 *
 * При компиляции, если нет ограничений JVM преобразует все обобщения в Object , если ограничения есть, то к наивысшему
 * классу, по нашему примеру <N extends Number> к Number
 *
 * Интерфейсы тоже могут быть обобщёнными и в него сразу можно отдать тип даннх, когда мы его имплементим
 * public class SimpleBox implements Comparable<SimpleBox>
 * <p>
 * Доблы и флоты надо сравнивать с учётом ошибки округления Math.abs(this.sum() - anotherBox.sum()) < 0.0001,
 * потому что при работе с дробными числами могут накапливаться ошибки округления
 */

public class GenericExample {

    public static void main(String[] args) {


        /**
         * Пример ошибки округления в double и float и пример правильного сравнения
         * */
        float a = 0.7f;
        float b = 0.0f;
        for (int i = 0; i < 70; i++) {
            b += 0.01f;
        }
        System.out.println(a == b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(Math.abs(a - b) < 0.00001);

    }


    public class GenBox<T extends Number & Closeable> {

    }

    public class DoubleGenBox<T, K> {
        /**
         * Пример что может быть несколько полей с одинаковым типом данных
         */
        private T obj1;
        private T obj2;
        private K obj3;

    }

    public class BoxWithNumbers<N extends Number> {
        private List<N> numbers;

        public BoxWithNumbers(N... items) {

        }

        public double sum() {
            double res = 0.0;
            for (N number : numbers) {
                res += number.doubleValue();
            }
            return res;
        }

        public boolean compareBySum(BoxWithNumbers<?> anotherBox) {
            return Math.abs(this.sum() - anotherBox.sum()) < 0.0001;
        }

    }

    /**
     * Пример использования wildcard для ограничения подачи в метод определенных типов данных
     */
    public static double avg(List<? extends Number> list) {
        double result = 0.0;
        for (Number number : list) {
            result += number.doubleValue();
        }
        return result / list.size();
    }

    /**
     * Пример использования обощённого типа <T> T getFirstElement в этом выражении <T> это объявлени того, что наш
     * метод обобщённый и использует элемент типа T, и можно сразу добавить ограничение на подаваемые данные
     */
    public static <T> T getFirstElement(List<T> list) {
        return list.get(0);
    }

    public static <T extends Number> T getSecondElement(List<T> list) {
        return list.get(1);
    }

    public class SimpleBox implements Comparable<SimpleBox> {

        @Override
        public int compareTo(SimpleBox o) {
            return 0;
        }
    }

}
