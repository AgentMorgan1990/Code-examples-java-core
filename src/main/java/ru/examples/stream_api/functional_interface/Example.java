package ru.examples.stream_api.functional_interface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Example {

    /**
     *  Consumer<T>                                     - void      accept          (T t);
     *  BiConsumer<T, U>                                - void      accept          (T t, U u);
     *  DoubleConsumer                                  - void      accept          (double value);
     *  IntConsumer                                     - void      accept          (int value);
     *  LongConsumer                                    - void      accept          (long value);
     *  ObjDoubleConsumer<T>                            - void      accept          (T t, double value);
     *  ObjIntConsumer<T>                               - void      accept          (T t, int value);
     *  ObjLongConsumer<T>                              - void      accept          (T t, long value);
     *
     *  Predicate<T>                                    - boolean   test            (T t);
     *  BiPredicate<T, U>                               - boolean   test            (T t, U u);
     *  DoublePredicate                                 - boolean   test            (double value);
     *  IntPredicate                                    - boolean   test            (int value);
     *  LongPredicate                                   - boolean   test            (long value);
     *
     *  Supplier<T>                                      - T        get             ();
     *  BooleanSupplier                                  - boolean  getAsBoolean    ();
     *  DoubleSupplier                                   - double   getAsDouble     ();
     *  IntSupplier                                      - int      getAsInt        ();
     *  LongSupplier                                     - long     getAsLong       ();
     *
     *  Function<T, R>                                  - R         apply           (T t);
     *  DoubleFunction<R>                               - R         apply           (double value);
     *  IntFunction<R>                                  - R         apply           (int value);
     *  LongFunction<R>                                 - R         apply           (long value);
     *  ToDoubleFunction<T>                             - double    applyAsDouble   (T value);
     *  ToIntFunction<T>                                - int       applyAsInt      (T value);
     *  ToLongFunction<T>                               - long      applyAsLong     (T value);
     *  DoubleToIntFunction                             - int       applyAsInt      (double value);
     *  DoubleToLongFunction                            - long      applyAsLong     (double value);
     *  IntToDoubleFunction                             - double    applyAsDouble   (int value);
     *  IntToLongFunction                               - long      applyAsLong     (int value);
     *  LongToDoubleFunction                            - double    applyAsDouble   (long value);
     *  LongToIntFunction                               - int       applyAsInt      (long value);
     *
     *  BiFunction<T, U, R>                             - R         apply           (T t, U u);
     *  ToDoubleBiFunction<T, U>                        - double    applyAsDouble   (T t, U u);
     *  ToIntBiFunction<T, U>                           - int       applyAsInt      (T t, U u);
     *  ToLongBiFunction<T, U>                          - long      applyAsLong     (T t, U u);
     *
     *  BinaryOperator<T> extends BiFunction<T,T,T>     - R         apply           (T t, U u);
     *  DoubleBinaryOperator                            - double    applyAsDouble   (double left, double right);
     *  IntBinaryOperator                               - int       applyAsInt      (int left, int right);
     *  LongBinaryOperator                              - long      applyAsLong     (long left, long right);
     *
     *  UnaryOperator<T> extends Function<T, T>         - R         apply           (T t);
     *  DoubleUnaryOperator                             - double    applyAsDouble   (double operand);
     *  IntUnaryOperator                                - int       applyAsInt      (int operand);
     *  LongUnaryOperator                               - long      applyAsLong     (long operand);
     *
     * */


    /**
     * Функциональный интерефейс Consumer<T> void accept (T t); Что-то потребляет и ничего не возвращает.
     *
     * Представляет операцию, которая принимает один входной аргумент и не возвращает результата. В отличие от
     * большинства других функциональных интерфейсов, ожидается, что потребитель будет работать с помощью побочных эффектов.
     *
     * */

    /**
     * Функциональный интерефейс Predicate<T>  boolean test (T t); принимает значение и возвращает boolean в методе тест
     * может быть использован в фильтрации
     * */

    /**
     * Функциональный интерефейс Supplier<T> T get (); Представляет поставщика результатов.
     * */

    /**
     * Функциональный интерефейс Function<T, R> R apply (T t); Представляет функцию, которая принимает один аргумент
     * и выдает результат.
     * */

    /**
     * Функциональный интерефейс BiFunction<T, U, R> R apply (T t, U u); Представляет функцию, которая принимает два
     * аргумента и выдает результат. Это двухуровневая специализация функции.
     * */

    /**
     * Функциональный интерефейс BinaryOperator<T> extends BiFunction<T,T,T>  R apply (T t, U u); Представляет операцию
     * над двумя операндами одного и того же типа, производящую результат того же типа, что и операнды. Это специализация
     * бифункции для случая, когда все операнды и результат имеют один и тот же тип.
     * */

    /**
     * Функциональный интерефейс UnaryOperator<T> extends Function<T, T> R apply (T t); Представляет операцию над одним
     * операндом, которая выдает результат того же типа, что и его операнд. Это специализация функции для случая, когда
     * операнд и результат имеют один и тот же тип.
     * */



    class PredicateTest implements Predicate {
        @Override
        public boolean test(Object o) {
            return false;
        }
    }

    class ConsumerTest implements Consumer {
        @Override
        public void accept(Object o) {
        }
    }


    class BinaryOperatorTest implements BinaryOperator{

        @Override
        public Object apply(Object o, Object o2) {
            return null;
        }
    }



}
