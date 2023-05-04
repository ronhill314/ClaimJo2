package PhoneBook;

public class People {

    private String firstName;
    private String middleName;
    private String lastName;
    private Address address;
    private String phoneNumber;


    



    public People() {
    }

 



    public People(String firstName, String lastName, String middleName, Address address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }





    public String getFirstName() {
        return firstName;
    }





    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }





    public String getLastName() {
        return lastName;
    }





    public void setLastName(String lastName) {
        this.lastName = lastName;
    }





    public String getMiddleName() {
        return middleName;
    }





    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }





    public Address getAddress() {
        return address;
    }





    public void setAddress(Address address) {
        this.address = address;
    }





    public String getPhoneNumber() {
        return phoneNumber;
    }





    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }





    @Override
    public String toString() {
        return "People [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", address="
                + address + ", phoneNumber=" + phoneNumber + "]";
    }




    




    
}
