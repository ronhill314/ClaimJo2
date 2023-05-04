package WeekTwo.SallysLemonadeStand.Account;

import java.util.ArrayList;

import WeekTwo.SallysLemonadeStand.CreditCardJava;
import WeekTwo.SallysLemonadeStand.Product.Product;

public class Account {

    private String nameString;
    private String email;
    private String password;
    private String phoneNumbers;
    // you will have a list of products to keep track of your purchases
    private ArrayList<Product> boughProducts;
    private CreditCardJava creditCard;

    


    public Account() {
    }


    


    public Account(String nameString, String email, String password, String phoneNumbers) {
        this.nameString = nameString;
        this.email = email;
        this.password = password;
        this.phoneNumbers = phoneNumbers;
    }





    public String getNameString() {
        return nameString;
    }
    public void setNameString(String nameString) {
        this.nameString = nameString;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    



    @Override
    public String toString() {
        return "Account [nameString=" + nameString + ", email=" + email + ", password=" + password + ", phoneNumbers="
                + phoneNumbers + ", boughProducts=" + boughProducts + ", creditCard=" + creditCard + "]";
    }


    


    public ArrayList<Product> getBoughProducts() {
        return boughProducts;
    }





    public void setBoughProducts(ArrayList<Product> boughProducts) {
        this.boughProducts = boughProducts;
    }





    public CreditCardJava getCreditCard() {
        return creditCard;
    }





    public void setCreditCard(CreditCardJava creditCard) {
        this.creditCard = creditCard;
    }

    
    

    
}
