package ru.spb.kupchinolab.otus.online_master.serialization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1StandardSerialization {

    @Test
    public void fixMe() {
        Person person = new Person();
        person.phoneNumber = 79111234567L;
        person.name = "Vasya";
        person.surname = "Pupkin";
        person.sessionIdentifier = person.phoneNumber + person.name + person.surname;

        try (FileOutputStream fileOut = new FileOutputStream("/tmp/person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
        } catch (IOException e) {
            Assertions.fail(e);
        }

        try (FileInputStream fileIn = new FileInputStream("/tmp/person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Person anotherPerson = (Person) in.readObject();
            assertEquals(person.phoneNumber, anotherPerson.phoneNumber);
            assertEquals(person.name, anotherPerson.name);
            assertEquals(person.surname, anotherPerson.surname);
            assertEquals(person.sessionIdentifier, anotherPerson.sessionIdentifier);
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }

    }

}
