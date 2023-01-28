package io.smth.repo.impl;

import io.smth.models.Person;
import io.smth.repo.PersonStorageManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDBManager implements PersonStorageManager {
    private Connection con = null;
    private final static String URL = "jdbc:sqlite:./test.db";

    public PersonDBManager() {
        connect();
    }

    @Override
    public List<Person> loadData(){
        ArrayList<Person> people = new ArrayList<>();
        try {
            if (con == null) {
                System.out.println("There is no connection to DB");
                return people;
            }
            String sql = "SELECT * FROM persons";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String number = rs.getString("number");
                Person p = new Person(name, surname, email, number);
                people.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("sql error");
            for (StackTraceElement s : e.getStackTrace()) {
                System.out.println(s);
            }
        }
        return people;
    }
    @Override
    public void saveData(Person person) {
        try {
            if(con == null){
                System.out.println("There is no connection to DB");
                return;
            }
            String sql = String.format("""
                            INSERT INTO persons (name, surname, email, number)
                            VALUES('%s','%s','%s','%s')
                            """, person.getName(), person.getSurname(),
                    person.getEmail(), person.getNumber());
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("sql error");
            for (StackTraceElement s : e.getStackTrace()) {
                System.out.println(s);
            }
        }

    }

    @Override
    public void close() {
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("sql error");
                for (StackTraceElement s : e.getStackTrace()) {
                    System.out.println(s);
                }
            }
        }
    }

    private void connect() {
        try {
            con = DriverManager.getConnection(URL);
            String sql = """
                    CREATE TABLE IF NOT EXISTS persons (
                      id integer PRIMARY KEY AUTOINCREMENT,
                      name text NOT NULL,
                      surname text NOT NULL,
                      email text NOT NULL,
                      number text NOT NULL
                    );""";
            Statement st = con.createStatement();
            st.execute(sql);
            System.out.println("table created");
        } catch (SQLException e) {
            System.out.println("sql error");
            for (StackTraceElement s : e.getStackTrace()) {
                System.out.println(s);
            }
        }
    }
}
