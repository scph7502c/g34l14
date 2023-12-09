package task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    final Map<String, Person> phoneBookEntries;
    private String filePath;

    public PhoneBook(String filename) {
        this.phoneBookEntries = new HashMap<>();
        this.filePath = filename;
        loadFromFile();
    }

    public void loadFromFile() {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("File path is not specified.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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

    public void addPerson(String fullName, String phoneNumber, String address) {
        if (fullName.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
            throw new IllegalArgumentException("Full name, phone number, and address are mandatory fields.");
        }
        Person person = new Person(fullName, phoneNumber, address);
        phoneBookEntries.put(fullName, person);
        saveToFile();
    }

    public Person findPerson(String fullName) throws EntryNotFoundException {
        if (!phoneBookEntries.containsKey(fullName)) {
            throw new EntryNotFoundException("Entry not found for: " + fullName);
        }
        return phoneBookEntries.get(fullName);
    }

    private void saveToFile() {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("File path is not specified.");
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Person> entry : phoneBookEntries.entrySet()) {
                String fullName = entry.getKey();
                Person person = entry.getValue();
                String phoneNumber = person.getPhoneNumber();
                String address = person.getAddress();
                writer.println(fullName + "," + phoneNumber + "," + address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}