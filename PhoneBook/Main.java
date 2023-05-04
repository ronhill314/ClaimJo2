package PhoneBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    static ArrayList<People> phoneBook = new ArrayList<People>();
    static Scanner scr = new Scanner (System.in);


    public static void main(String[] args) {

        People testPerson1 = new People("John", "Doe", "",
        new Address(114, "Market St", "St Louis", "MO", 63403), "6366435698");
        phoneBook.add(testPerson1);
        People testPerson2 = new People("John", "Doe", "E",
        new Address(324, "Main St", "St Charles", "MO",63303), "8475390126");
        phoneBook.add(testPerson2);
        People testPerson3 = new People("John", "Doe", "Michael West", 
        new Address(574, "Pole ave", "St. Peters", "MO", 63333), "5628592375");
        phoneBook.add(testPerson3);
        



        int choice;
        do {
            System.out.println("Welcome to To the Phonebook");

            System.out.println("What Would you like to do: ");
            System.out.println("1) Add an Entry");
            System.out.println("2) Search for existing entry: ");
            System.out.println("3) Edit an existing entry: ");
            System.out.println("4) Delete an existing entry: ");
            choice = scr.nextInt();
            scr.nextLine();

            switch (choice) {
                case 1:
                    addAnEntry();
                    break;
                case 2:
                    searchEntries();
                    break;
                case 3:
                    editEntry();
                    break;
                case 4:
                    deleteEntry();
                    break;
                case 888:
                    System.out.println("Thank you come again");
                    break;
            }
        } while (choice != 888);

        
    }



    public static void addAnEntry() {

        System.out.println("What is your first name: ");
        String firstName = scr.nextLine();
        System.out.println("What is your middle name: ");
        String middleName = scr.nextLine();
        System.out.println("What is your last name: ");
        String lastName = scr.nextLine();
        System.out.println("What is your phone number: ");
        String phoneNumber = scr.nextLine();

        System.out.println("What is your house number: ");
        Integer houseNumber = scr.nextInt();
        scr.nextLine();
        System.out.println("What is your street name: ");
        String streetName = scr.nextLine();
        System.out.println("What is your city: ");
        String city = scr.nextLine();
        System.out.println("What is your state: ");
        String state = scr.nextLine();
        System.out.println("What is your zip code: ");
        Integer zipCode = scr.nextInt();
        scr.nextLine();

        Address address = new Address( houseNumber,  streetName,  city,  state,  zipCode);

        People people = new People(firstName, lastName, middleName, address, phoneNumber);
        
        phoneBook.add(people);

    }
    
    
    public static People searchEntries() {


    System.out.println("What do you want to search");
    System.out.println("1) First Name");
    System.out.println("2) Last Name");
    System.out.println("3) Phone Number and edit entry");

    int choice = scr.nextInt();
            scr.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter First Name");
                    String firstName = scr.nextLine(); 
                    for (int i = 0; i < phoneBook.size(); i++) {
                        if (firstName.equals(phoneBook.get(i).getFirstName())){
                            System.out.println(phoneBook.get(i).toString());
                        }
                    }
                    break;
                case 2:
                System.out.println("Enter Last Name");
                String lastName = scr.nextLine(); 
                for (int i = 0; i < phoneBook.size(); i++) {
                    if (lastName.equals(phoneBook.get(i).getLastName())){
                        System.out.println(phoneBook.get(i).toString());
                        }
                    }
                break;
                case 3:
                System.out.println("Enter Phone Number");
                String phoneNumber = scr.nextLine(); 
                for (int i = 0; i < phoneBook.size(); i++) {
                    if (phoneNumber.equals(phoneBook.get(i).getPhoneNumber())){
                        System.out.println(phoneBook.get(i).toString());
                        return phoneBook.get(i);
                        }
                    }
                break;
                case 888:
                    System.out.println("Thank you come again");
                    break;
                }
                
                return null;

    }

    public static void editEntry() {

        System.out.println("What do you want to edit");
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Phone Number");
        int choice = scr.nextInt();
            scr.nextLine();
        
            People people = searchEntries();
            switch (choice) {
                case 1:
                    people.setFirstName(scr.nextLine());
                    break; 
                case 2:
                    people.setLastName(scr.nextLine());
                    break; 
                case 3:
                    people.setPhoneNumber(scr.nextLine());
                    break; 
            }


    }

    public static  void deleteEntry() {

        System.out.println("Enter the number of the file to delete.");
        String search = scr.nextLine();
        Integer searchListBook = phoneBook.size();
        int indexToRemove = 0;
        for (int i = 0; i < searchListBook; i++) {
            if (phoneBook.get(i).getPhoneNumber().equals(search)) {
                indexToRemove = i;
            }
            
        }
        phoneBook.remove(indexToRemove);
    }


}
