package ru.spb.kupchinolab.otus.online_master.serialization;

public class Person {
    long phoneNumber;
    String name;
    String surname;
    transient String sessionIdentifier;
}
