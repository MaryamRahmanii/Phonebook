import java.util.ArrayList;
import java.util.Objects;

public class Phonebook {
    private static ArrayList<Person> contacts;

    public Phonebook() {
        this.contacts = new ArrayList<>();
    }


    /**
     * A Simple function to add a new contact
     * @param contact is the Person that we created and just adding it
     */
    public static void addContact(Person contact){

        int x=0;

        for (Person con: contacts)
            if (contact.getPhone().equals(con.getPhone())) {
                x = 1;
            }

        if(!contact.getName().trim().equals("") && x==0)
        {
            contacts.add(contact);
        }

    }

    /**
     * A Method to find a specific user's phone number by entering him/her name
     * @param name is the name of our contact
     * @return  is the phone number or an error (happens when we didn't find contact)
     */
    public String getPhoneNumber(String name){
        for (Person contact : contacts) {
            if(contact == null)
                return "Contact Not Found";
            if(Objects.equals(contact.getName(), name))
                return contact.getPhone();
        }
        return "Contact Not Found";
    }

    /**
     * @param name is The name of the contact who we are looking for
     * if we found the contact who we were looking for, we show the information
     * @return 1 if we found contact and 0 if we couldn't find it
    */
    public static int getContact(String name){
        for (Person contact : contacts) {
            if (contact == null)
                return 0;
            else if (Objects.equals(contact.getName(), name)) {
                System.out.println(contact);
                return 1;
            }
        }
        return 0;
    }

    /**
     * A simple function to update our contact name
     * @param name is the name of the contact who we want to change
     * @param newName is the new name of that conract
     * @return 1 if changing was successful and 0 if it missed
     */
    public int updateContactName(String name, String newName){
        for (Person contact : contacts) {
            if (contact == null)
                return 0;
            else if (Objects.equals(contact.getName(), name) && !newName.trim().equals("")) {
                contact.setName(newName);
                return 1;
            }
        }
        return 0;
    }
    /**
     * A simple function to update our contact name
     * @param name is the name of the contact who we want to change
     * @param newPhone is the new phone number of that contact
     * @return 1 if changing was successful and 0 if it missed
     */
    public int updateContactPhoneNumber(String name, String newPhone){

        int x=0;

        for (Person con: contacts)
            if (newPhone.equals(con.getPhone())) {
                x = 1;
            }


        for (Person contact : contacts) {
            if (contact == null)
                return 0;
            else if (Objects.equals(contact.getName(), name)) {
                contact.setPhone(newPhone);
                if(contact.getPhone().equals(newPhone) && x==0)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }


            }
        }
        return 0;
    }

    /**
     * A function to delete a specific contact from phonebook
     * @param name is the name of that contact
     */
    public void deleteContact(String name){
        for (Person contact : contacts) {
            if(Objects.equals(contact.getName(), name))
            {
                contacts.remove(contact);
            }
            else {
                System.out.println("this contact doesn't exist");
            }

        }


    }

    /**
     * A method to get all of our contacts in once
     * @return our List of contacts
     */
    public static ArrayList<Person> getAllContacts(){
        return contacts;
    }

    /**
     * As a security part of this phonebook, we created this function
     * here we can hide all contacts at once
     */
    public void setAllContactsHidden(){
        for (Person contact : contacts) {
            if(contact == null)
                return;
            contact.setHidden();
        }
    }
    /**
     * As a security part of this phonebook, we created this function
     * here we can make all contacts unhidden at once
     */
    public void setAllContactsUnHidden(){
        for (Person contact : contacts){
            if(contact == null)
                return;
            contact.setUnHidden();
        }
    }
}
