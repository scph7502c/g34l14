package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddPerson() {
        phoneBook.addPerson("Leon Kennedy", "123456789", "Raccoon City Police Department");

        assertEquals(1, phoneBook.phoneBookEntries.size());
        assertTrue(phoneBook.phoneBookEntries.containsKey("Leon Kennedy"));
    }

    @Test
    public void testFindPerson() throws EntryNotFoundException {
        phoneBook.addPerson("Arthur Morgan", "987654321", "Clemens Point");

        Person person = phoneBook.findPerson("Arthur Morgan");

        assertNotNull(person);
        assertEquals("Arthur Morgan", person.getFullName());
        assertEquals("987654321", person.getPhoneNumber());
        assertEquals("Clemens Point", person.getAddress());
    }

    @Test
    public void testFindPersonNotFound() {
        assertThrows(EntryNotFoundException.class, () -> phoneBook.findPerson("Kyle Crane"));
    }

    @Test
    public void testLoadFromFile() {
        String filePath = "C:\\Users\\damia\\OneDrive\\Pulpit\\FutureCollars\\Java\\Projekty\\g34l14\\src\\main\\resources\\book.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String fullName = data[0];
                    String phoneNumber = data[1];
                    String address = data[2];
                    phoneBook.addPerson(fullName, phoneNumber, address);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(2, phoneBook.phoneBookEntries.size());

        assertTrue(phoneBook.phoneBookEntries.containsKey("Leon Kennedy"));
        assertTrue(phoneBook.phoneBookEntries.containsKey("Arthur Morgan"));

    }

}