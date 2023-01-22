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
                case 1 -> addNewPerson(scan);
                case 2 -> printPersonList();
                case 3 -> {
                    scan.close();
                    System.exit(0);
                }
                default -> System.out.println("Incorrect input");
            }
        }

    }
    private String inputName(Scanner sc){
        System.out.println("Input name of Person");
        return sc.next();
    }
    private String inputSurname(Scanner sc){
        System.out.println("Input surName of Person");
        return sc.next();
    }
    private String inputEmail(Scanner sc){
        System.out.println("Input email of Person");
        return sc.next();
    }
    private String inputNumber(Scanner sc, Validation val){
        System.out.println("Input phone number of Person");
        String number = sc.next();
        if(!val.numberValidation(number)){
            inputNumber(sc, val);
        }
        return number;
    }

    private void addNewPerson(Scanner scan) {
        String name = inputName(scan);
        String surname = inputSurname(scan);
        String email = inputEmail(scan);
        Validation val = new Validation();
        String number = inputNumber(scan, val);
        Person any = new Person(name, surname, email, number);
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
