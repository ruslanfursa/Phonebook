package io.smth.repo.impl;
import io.smth.models.Person;
import io.smth.repo.PersonStorageManager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileManager implements PersonStorageManager {

    @Override
    public List<Person> loadData() {
        ArrayList<Person> people = new ArrayList<>();
        try(FileReader fr = new FileReader("test.txt");
        BufferedReader bf = new BufferedReader(fr)) {
            String s = bf.readLine();
            while(s != null){
                String[] strArray = s.split(",");
                if(strArray.length == 4){
                Person p = new Person(strArray[0], strArray[1], strArray[2], strArray[3]);
                people.add(p);
                }
                s = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("Create file");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return people;
    }

    @Override
    public void saveData(Person person) {
        try ( FileWriter fw = new FileWriter("test.txt", true)) {
           String s = String.format("%s,%s,%s,%s\n", person.getName(), person.getSurname(),
                   person.getEmail(), person.getNumber());
           fw.append(s);
           fw.flush();

        }
        catch(IOException e){
            System.out.println("Create file");
        }

    }

}
