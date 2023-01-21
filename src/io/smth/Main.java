package io.smth;

import io.smth.repo.PersonStorageManager;
import io.smth.repo.impl.PersonFileManager;
import io.smth.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        PersonStorageManager pfm = new PersonFileManager();
        UserInterface uif = new UserInterface(pfm);
        uif.communication();
    }
}