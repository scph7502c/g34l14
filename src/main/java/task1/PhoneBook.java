package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    final Map<String, Person> phoneBookEntries;

    public PhoneBook() {
        this.phoneBookEntries = new HashMap<>();
    }

    public void addPerson(String fullName, String phoneNumber, String address) {
        if (fullName.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
            throw new IllegalArgumentException("Full name, phone number, and address are mandatory fields.");
        }
        Person person = new Person(fullName, phoneNumber, address);
        phoneBookEntries.put(fullName, person);
    }

    public Person findPerson(String fullName) throws EntryNotFoundException {
        if (!phoneBookEntries.containsKey(fullName)) {
            throw new EntryNotFoundException("Entry not found for: " + fullName);
        }
        return phoneBookEntries.get(fullName);
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addPerson(parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}