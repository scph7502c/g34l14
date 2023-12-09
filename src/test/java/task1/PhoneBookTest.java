package task1;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private static final String FILE_PATH = "C:\\\\Users\\\\damia\\\\OneDrive\\\\Pulpit\\\\FutureCollars\\\\Java\\\\Projekty\\\\g34l14\\\\src\\\\main\\\\resources\\\\book.txt";

    @Test
    public void testAddPerson() {
        PhoneBook phoneBook = new PhoneBook(FILE_PATH);

        phoneBook.addPerson("Leon Kennedy", "123456789", "Raccoon City Police Department");

        assertEquals(2, phoneBook.phoneBookEntries.size());
        assertTrue(phoneBook.phoneBookEntries.containsKey("Leon Kennedy"));
    }

    @Test
    public void testFindPerson() throws EntryNotFoundException {
        PhoneBook phoneBook = new PhoneBook(FILE_PATH);

        phoneBook.addPerson("Arthur Morgan", "987654321", "Clemens Point");

        Person person = phoneBook.findPerson("Arthur Morgan");

        assertNotNull(person);
        assertEquals("Arthur Morgan", person.getFullName());
        assertEquals("987654321", person.getPhoneNumber());
        assertEquals("Clemens Point", person.getAddress());
    }

    @Test
    public void testFindPersonNotFound() {
        PhoneBook phoneBook = new PhoneBook(FILE_PATH);

        assertThrows(EntryNotFoundException.class, () -> phoneBook.findPerson("Kyle Crane"));
    }

    @Test
    public void testLoadFromFile() {
        PhoneBook phoneBook = new PhoneBook(FILE_PATH);

        assertEquals(2, phoneBook.phoneBookEntries.size());

        assertTrue(phoneBook.phoneBookEntries.containsKey("Leon Kennedy"));
        assertTrue(phoneBook.phoneBookEntries.containsKey("Arthur Morgan"));
    }

    @Test
    public void testLoadFromFileContents() {
        PhoneBook phoneBook = new PhoneBook(FILE_PATH);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String fullName = data[0];
                    String phoneNumber = data[1];
                    String address = data[2];
                    Person person = phoneBook.findPerson(fullName);
                    assertNotNull(person);
                    assertEquals(fullName, person.getFullName());
                    assertEquals(phoneNumber, person.getPhoneNumber());
                    assertEquals(address, person.getAddress());
                    count++;
                }
            }
            assertEquals(count, phoneBook.phoneBookEntries.size());
        } catch (IOException | EntryNotFoundException e) {
            e.printStackTrace();
            fail("Exception thrown while testing loadFromFileContents");
        }
    }
}
