/**
 * writing unit tests for each method of classes
 * If you have no idea about how to write unit tests, you can search the internet or check your first assignment
 * After each unit test you've written, please commit the changes and push to your repo

 * Hint: Your test coverage should be 100%
 * Attention:  We would check your commits and it will affect your score
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Phonebook_Test {
    @Test
    public void testaddContact()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);
        assertTrue(Phonebook.getAllContacts().contains(person1));

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);
        assertTrue(Phonebook.getAllContacts().contains(person2));

        Person person3 = new Person("Nima","09907556876");
        phonebook.addContact(person3);
        assertTrue(Phonebook.getAllContacts().contains(person3));

        Person person4 = new Person("","09113569254");
        phonebook.addContact(person4);
        assertFalse(Phonebook.getAllContacts().contains(person4));

        Person person5 = new Person("Melina","09113569254");
        phonebook.addContact(person5);
        assertFalse(Phonebook.getAllContacts().contains(person5));
    }

}
