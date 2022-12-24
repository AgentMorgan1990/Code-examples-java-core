package ru.examples.jdbc;

import java.sql.*;

public class JdbcMainApp {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;


    /**
     * CRUD - операции (Create, Read, Update, Delete)
     *
     * Для Create, Update, Update используем executeUpdate, возвращает int - кол-во строк изменений
     * <p>
     * Для Read используем executeQuery - возвращает ResultSet, курсор указывает на предыдущую строку
     *
     * Для того, чтобы проводить операции в одной транзакции выставляем сначала
     * connection.setAutoCommit(false); потом или connection.commit(); или connection.setAutoCommit(true);
     *
     * Можем отправлять запросы батчами, чтобы снизить нагрузку на соединение stmt.executeBatch();
     * возвращает массив int - каждый показывает сколько изменений в каждом запросе
     *
     * PreparedStatement - позволяет создать подготовленный запрос, это снижает проблемы с безопасность (невозможно провести SQL инжекцию)
     */
    public static void main(String[] args) {
        try {
            connect();

            dropAndCreateTable();
//            fillTable();
//            insertExample();
//            readExample();
//            updateExample();
//            deleteOneExample();
//            batchExample();
            prepareStatements();
            preparedStatementExample();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void insertExample() throws SQLException {
        stmt.executeUpdate("insert into students (name, score) values ('Max', 90);");
    }

    private static void readExample() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("select * from students where id > 2;")) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt("score"));
            }
        }
    }

    private static void updateExample() throws SQLException {
        stmt.executeUpdate("update students set score = 100 where id > 0;");
    }


    private static void deleteOneExample() throws SQLException {
        stmt.executeUpdate("delete from students where id = 5;");
    }

    private static void dropAndCreateTable() throws SQLException {
        stmt.executeUpdate("drop table if exists students;");
        stmt.executeUpdate("""
                CREATE TABLE if not exists students (
                    id    INTEGER PRIMARY KEY AUTOINCREMENT,
                    name  TEXT,
                    score INTEGER
                );;""");
    }

    private static void fillTable() throws SQLException {
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 50; i++) {
            stmt.executeUpdate(String.format("insert into students (name, score) values ('%s', %d);", "BOB #" + i, 100));
        }
        connection.commit();
        System.out.println("TIME: " + (System.currentTimeMillis() - time));
    }

    private static void batchExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i <= 50; i++) {
            stmt.addBatch(String.format("insert into students (name, score) values ('%s', %d);", "BOB #" + i, 100));
        }
        stmt.executeBatch();
        connection.commit();
    }

    private static void preparedStatementExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i <= 50; i++) {
            // insert into students (name, score) values (?, ?);
            psInsert.setString(1, "BOB" + i);
            psInsert.setInt(2, 100);
            psInsert.executeUpdate();
        }
        connection.commit();
    }

    private static void prepareStatements() throws SQLException {
        psInsert = connection.prepareStatement("insert into students (name, score) values (?, ?);");
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mdb.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Невозможно подключиться к БД");
        }
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (psInsert != null) {
                psInsert.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
