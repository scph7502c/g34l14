package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddPerson() {
        phoneBook.addPerson("John Doe", "123456789", "123 Main St");

        assertEquals(1, phoneBook.phoneBookEntries.size());
        assertTrue(phoneBook.phoneBookEntries.containsKey("John Doe"));
    }

    @Test
    public void testFindPerson() throws EntryNotFoundException {
        phoneBook.addPerson("Jane Smith", "987654321", "456 Oak Ave");

        Person person = phoneBook.findPerson("Jane Smith");

        assertNotNull(person);
        assertEquals("Jane Smith", person.getName());
        assertEquals("987654321", person.getPhoneNumber());
        assertEquals("456 Oak Ave", person.getAddress());
    }

    @Test
    public void testFindPersonNotFound() {
        assertThrows(EntryNotFoundException.class, () -> {
            phoneBook.findPerson("Nonexistent Person");
        });
    }

    @Test
    public void testLoadFromFile() {
        File file = null;
        try {
            file = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("test.txt")).toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (file != null && file.exists()) {
            phoneBook.loadFromFile(file.getAbsolutePath());

            assertEquals(2, phoneBook.phoneBookEntries.size());
            assertTrue(phoneBook.phoneBookEntries.containsKey("John Doe"));
            assertTrue(phoneBook.phoneBookEntries.containsKey("Jane Smith"));
        } else {
            fail("Test file not found or inaccessible.");
        }
    }
}