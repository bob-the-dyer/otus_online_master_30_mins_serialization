package ru.spb.kupchinolab.otus.online_master.serialization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2ExternalisedSerialization {

    @Test
    public void fixMe() {
        SmartPerson person = new SmartPerson();
        person.phoneNumber = 79111234567L;
        person.name = "Vasya";
        person.surname = "Pupkin";
        person.sessionIdentifier = person.phoneNumber + person.name + person.surname;

        try (FileOutputStream fileOut = new FileOutputStream("/tmp/smart_person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
        } catch (IOException e) {
            Assertions.fail(e);
        }

        try (FileInputStream fileIn = new FileInputStream("/tmp/smart_person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            SmartPerson anotherPerson = (SmartPerson) in.readObject();
            assertEquals(person.phoneNumber, anotherPerson.phoneNumber);
            assertEquals(person.name, anotherPerson.name);
            assertEquals(person.surname, anotherPerson.surname);
            assertEquals(null, anotherPerson.sessionIdentifier);
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }

    }

}
