package io.smth.ui;

import io.smth.models.Person;
import io.smth.repo.PersonStorageManager;
import io.smth.validation.MailValidator;
import io.smth.validation.NameValidator;
import io.smth.validation.NumberValidator;
import io.smth.validation.SurnameValidator;

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
                scan.nextLine();
            } catch(InputMismatchException e){
                System.out.println("Incorrect input");
                scan.nextLine();
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
    private String inputName(Scanner scan, NameValidator nameVal){
        System.out.println("Input name of Person");
        String name = scan.nextLine();
        if(!nameVal.validate(name)){
            name = inputName(scan,nameVal);
        }
        return name;
    }
    private String inputSurname(Scanner scan, SurnameValidator surVal){
        System.out.println("Input surName of Person");
        String surname = scan.nextLine();
        if(!surVal.validate(surname)){
           surname = inputSurname(scan, surVal);
        }
        return surname;
    }
    private String inputEmail(Scanner scan, MailValidator mailVal){
        System.out.println("Input email of Person");
        String email = scan.nextLine();
        if(!mailVal.validate(email)){
            email = inputEmail(scan, mailVal);
        }
        return email;
    }
    private String inputNumber(Scanner scan, NumberValidator numVal){
        System.out.println("Input phone number of Person");
        String number = scan.nextLine();
        if(!numVal.validate(number)){
           number = inputNumber(scan, numVal);
        }
        return number;
    }

    private void addNewPerson(Scanner scan) {
        NumberValidator numVal = new NumberValidator();
        NameValidator nameVal = new NameValidator();
        SurnameValidator surVal = new SurnameValidator();
        MailValidator mailVal = new MailValidator();
        String name = inputName(scan, nameVal);
        String surname = inputSurname(scan, surVal);
        String email = inputEmail(scan, mailVal);
        String number = inputNumber(scan, numVal);
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
