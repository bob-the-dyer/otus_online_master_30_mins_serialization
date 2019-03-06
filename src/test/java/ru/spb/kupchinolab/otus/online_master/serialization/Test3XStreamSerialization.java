package ru.spb.kupchinolab.otus.online_master.serialization;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3XStreamSerialization {

    @Test
    public void fixMe() {
        Person person = new Person();
        person.phoneNumber = 79111234567L;
        person.name = "Vasya";
        person.surname = "Pupkin";
        person.sessionIdentifier = person.phoneNumber + person.name + person.surname;

        XStream xstream = new XStream();
        xstream.alias("person", Person.class);

        try (FileOutputStream fileOut = new FileOutputStream("/tmp/person.ser.xml")) {
            xstream.toXML(person, fileOut);
        } catch (IOException e) {
            Assertions.fail(e);
        }

        try (FileInputStream fileIn = new FileInputStream("/tmp/person.ser.xml")) {
            Person anotherPerson = (Person) xstream.fromXML(fileIn);
            assertEquals(person.phoneNumber, anotherPerson.phoneNumber);
            assertEquals(person.name, anotherPerson.name);
            assertEquals(person.surname, anotherPerson.surname);
            assertEquals(person.sessionIdentifier, anotherPerson.sessionIdentifier);
        } catch (IOException e) {
            Assertions.fail(e);
        }

    }

}
