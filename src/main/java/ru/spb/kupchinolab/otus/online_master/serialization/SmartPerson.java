package ru.spb.kupchinolab.otus.online_master.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SmartPerson implements Externalizable {

    long phoneNumber;
    String name;
    String surname;
    transient String sessionIdentifier;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(phoneNumber);
        out.writeObject(name);
        out.writeObject(surname);
        out.writeObject(sessionIdentifier);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        phoneNumber = in.readLong();
        name = (String) in.readObject();
        surname = (String) in.readObject();
        sessionIdentifier = (String) in.readObject();
    }
}
