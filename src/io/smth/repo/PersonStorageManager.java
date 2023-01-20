package io.smth.repo;
import io.smth.models.Person;
import java.util.List;

public interface PersonStorageManager {
    List<Person> loadData();
    void saveData(Person person);
}

