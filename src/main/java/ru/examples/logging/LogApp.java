package ru.examples.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * log4j2
 *
 * Logger содержит в себе методы, которые позволяют выводит сообщения о работе нашего
 * приложения.Каждый уровень логирования имеет свой приоритет:
 * Trace < Debug < Info < Warn < Error < Fatal
 *
 * Создаём Logger в каждом классе, который хотим логгировать
 *
 * Log4j2 настраивается через properties или xml файл.
 * В log4j2.xml конфигуррируем Appender-ы, котороые могут выводить логи в разные источники, например в консоль, писать в файл, БД и т.п.
 * К каждому Appender-у подключается Layout , с описанием как выводить сообщение (форматтер)
 * Далее создаём Logger-ы и подвязываем к ним Appender-ы, указываем уровень вывода
 * конфигурируем отдельные  Logger-ы, чтобы можно было получать разные уровни сообщений из различных пакетов, если это необходимо
 * К настройкам можно добавлять фильтры
 * Настройки лайоутов и аппендеров можно посмотреть в документации :)
 *
 * Appender
 * Appender осуществляет запись сообщения в “пункт назначения”: консоль, файл, базу данных, и т.д.
 * Appender это интерфейс Log4j2, а его реализациями являются: ConsoleAppender, FileAppender,
 * JDBCAppender, SocketAppender, SyslogAppender, и еще очень много других классов. Appender’ы
 * подключаются к логгерам, к каждому логгеру может быть подключено любое количество Appender’ов
 * (в разумных пределах).
 *
 * Layout
 * Layout отвечает за форматирование выводимых сообщений, и в Log4j представлены: PatternLayout,
 * HtmlLayout, YAMLLayout, XmlLayout, JSONLayout.
 *
 * Преимущество Log4j2 перед System.out.println()
 * Любой фреймворк для логирования позволяет указывать уровень сообщения, который может быть
 * использован для фильтрации сообщений. Фреймворк для логирования предоставляет улучшенные
 * средства вывода сообщений и метаданных, что позволяет ускорить и упростить процесс отладки.
 *
 * */
public class LogApp {

    private static final Logger LOGGER = LogManager.getLogger(LogApp.class);


    public static void main(String[] args) {
        System.out.println(LOGGER.getName());

        LOGGER.trace("Trace");
        LOGGER.debug("Debug");
        LOGGER.info("Info");
        LOGGER.warn("Warn");
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");

    }
}
