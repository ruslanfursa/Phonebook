package io.smth;

import io.smth.repo.PersonStorageManager;
import io.smth.repo.impl.PersonDBManager;
import io.smth.repo.impl.PersonFileManager;
import io.smth.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        PersonStorageManager pdm = new PersonDBManager();
        UserInterface uif = new UserInterface(pdm);
        uif.communication();
        pdm.close();
    }
}