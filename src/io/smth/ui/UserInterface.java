package io.smth.ui;

import io.smth.models.Person;
import io.smth.repo.PersonStorageManager;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    PersonStorageManager personStorageManager;

    public UserInterface(PersonStorageManager psm) {
        personStorageManager = psm;
    }

    public void communication() {
        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("""
                    Press 1 to add new contact
                    Press 2 to print contacts
                    Press 3 to exit""");
            int inputValue;
            try {
                inputValue = scan.nextInt();
            } catch(InputMismatchException e){
                System.out.println("Incorrect input");
                scan.next();
                continue;
            }
            switch (inputValue) {
                case 1 -> addNewPerson();
                case 2 -> printPersonList();
                case 3 -> {
                    scan.close();
                    System.exit(0);
                }
                default -> System.out.println("Incorrect input");
            }
        }

    }

    private void addNewPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Input the name of Person");
        String inputName = sc.next();
        System.out.println("Input the surname of Person");
        String inputSurname = sc.next();
        System.out.println("Input email of Person");
        String inputEmail = sc.next();
        System.out.println("Input phone number of Person");
        String inputNumber = sc.next();
        Person any = new Person(inputName, inputSurname, inputEmail, inputNumber);
        personStorageManager.saveData(any);
        System.out.println(any + " was added to list");

    }

    private void printPersonList() {
        List<Person> people = personStorageManager.loadData();
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
