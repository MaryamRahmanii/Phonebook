/**
 * writing unit tests for each method of classes
 * If you have no idea about how to write unit tests, you can search the internet or check your first assignment
 * After each unit test you've written, please commit the changes and push to your repo

 * Hint: Your test coverage should be 100%
 * Attention:  We would check your commits and it will affect your score
 */
import org.junit.jupiter.api.Test;

import java.util.Objects;

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

        Person person6 = new Person("   ","09113569254");
        phonebook.addContact(person6);
        assertFalse(Phonebook.getAllContacts().contains(person6));


    }

    @Test
    public void testgetphonenumber()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);
        String name1="Maryam";
        assertTrue(Objects.equals(phonebook.getPhoneNumber(name1), "09113569254"));
    }

    @Test
    public void testgetContact()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);

        Person person3 = new Person("Nima","09907556876");
        phonebook.addContact(person3);

        String name1 ="Nima";

        assertEquals(phonebook.getContact(name1),1);

        String name2 ="Asal";

        assertEquals(phonebook.getContact(name2),0);

    }

    @Test
    public void testupdateContactName()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);

        String name1="Maryam";
        String newname1="MarMar";

        assertEquals(phonebook.updateContactName(name1,newname1),1);

        String name2="Arash";
        String newname2="   ";

        assertEquals(phonebook.updateContactName(name2,newname2),0);

        String name3 ="Maman";
        String newname3 ="Nima";

        assertEquals(phonebook.updateContactName(name3, newname3),0);

    }

    @Test
    public void updateContactPhone()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);

        Person person3 = new Person("Nima","09907556876");
        phonebook.addContact(person3);

        String name1 ="Maryam";

        assertEquals(phonebook.updateContactPhoneNumber(name1,"09113578291"),1);

        String name2 ="Asal";

        assertEquals(phonebook.updateContactPhoneNumber(name2,"09113578291"),0);

        String name3 ="Arash";

        assertEquals(phonebook.updateContactPhoneNumber(name3,"0911357"),0);

        assertEquals(phonebook.updateContactPhoneNumber(name3,"091135745687925"),0);

        assertEquals(phonebook.updateContactPhoneNumber(name3,"09907556876"),0);  //shomareye tekrari ke baraye kas dige save shode nemishe gozasht
    }

    @Test
    public void testdeleteContact()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);

        String name1 ="Maryam";

        phonebook.deleteContact(name1);

        assertFalse(phonebook.getAllContacts().contains(person1));

        String name2 ="Avin";

        phonebook.deleteContact(name2);

    }

    @Test
    public void testsetAllContactsHidden()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);

        phonebook.setAllContactsHidden();

        assertTrue(person1.isHidden() && person2.isHidden());
    }

    @Test
    public void testsetAllContactsUnHidden()
    {
        Person person1= new Person("Maryam","09113569254");
        Phonebook phonebook=new Phonebook();
        phonebook.addContact(person1);

        Person person2= new Person("Arash","09912650261");
        phonebook.addContact(person2);

        phonebook.setAllContactsUnHidden();

        assertFalse(person1.isHidden() && person2.isHidden());
    }





}
