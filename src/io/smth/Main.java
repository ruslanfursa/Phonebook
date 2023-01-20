package io.smth;

import io.smth.models.Person;
import io.smth.repo.impl.PersonFileManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person first = new Person("John", "Smith", "JS@1986.com", "+3756784567");
//        Person second = new Person("Jimmy", "Piston", "Piston@12.gmail.com", "+375254678695");
//        Person third = new Person ("Bolt", "Ivan", "Bolt34@mail.ru", "+375334567790");
//        Person fourth = new Person("Gaykin", "Petr", "Gaykin123@mail.ru", "+375442345677");
//        List<Person> people = new ArrayList<>();
//        people.add(first);
//        people.add(second);
//        people.add(third);
//        people.add(fourth);
//        PersonStorageManager pfm = new PersonFileManager();
//        for(Person r: people){
//            pfm.saveData(r);
//        }
        PersonFileManager pfm1 = new PersonFileManager();
        List<Person> peopleList = pfm1.loadData();
        for(Person q: peopleList){
            System.out.println(q);
        }

    }
}