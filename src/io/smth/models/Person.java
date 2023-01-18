package io.smth.models;

public class Person {
    private final String name;
    private final String surname;
    private final String email;
    private final String number;

    public Person(String name, String surname, String email, String number){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail(){
        return email;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return String.format("name: %s, surname: %s, email: %s, number: %s", name, surname, email, number);
    }
}
