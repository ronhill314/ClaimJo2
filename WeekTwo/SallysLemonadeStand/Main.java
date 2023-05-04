package WeekTwo.SallysLemonadeStand;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import WeekTwo.SallysLemonadeStand.Account.Account;
import WeekTwo.SallysLemonadeStand.Product.Product;

public class Main {

    static ArrayList<Account> listOfAccounts = new ArrayList<Account>();
    static Scanner scr = new Scanner(System.in);
    static Product strLemonade = new Product("Strawberry Sweet", "Strawberry Lemondae", 8.99, 20000);
    static Product bbrLemonade = new Product("Blueberry Sweet", "Blueberry Lemonade", 6.99, 20000);
    static Product bwmLemonade = new Product("Boneless Goodness", "Boneless Watermelon Lemonade", 12.99, 20000);
    static Product sallyWater = new Product("It'11 make your hair grow", "Special Water", 10.99, 20000);

    public static void main(String[] args) {

        int choice;
        do {
            Account account = null;
            System.out.println("Welcome to Sallys Lemonade Stand!!!!");

            System.out.println("What Would you like to do: ");
            System.out.println("1) Create an Account");
            System.out.println("2) Login");
            System.out.println("3) Buy Some Lemonade");
            choice = scr.nextInt();

            switch (choice) {
                case 1:
                    createAnAccount();
                    break;
                case 2:
                    account = login();
                    break;
                case 3:
                    buyProduct(account);
                    account = null;
                    break;
                case 1337:
                    System.out.println("Thank you come again");
                    break;
            }
        } while (choice != 1337);

    }

    public static void createAnAccount() {

        System.out.println("Sign up for an acccount!");

        System.out.println("What is your name");
        String name = scr.nextLine();

        System.out.println("What is your email");
        String email = scr.nextLine();

        System.out.println("What is your password");
        String password = scr.nextLine();

        System.out.println("What is your Phone Number");
        String phoneNumber = scr.nextLine();

        Account account = new Account(name, email, password, phoneNumber);
        listOfAccounts.add(account);

    }

    public static Account login() {

        System.out.println("What is your email");
        String email = scr.nextLine();
        System.out.println("What is your password");
        String password = scr.nextLine();

        for(Account account : listOfAccounts){
            if(email.equals(account.getEmail())
            && password.equals(account.getPassword())){
                return account;
            }
        }
        return null;

    
    }

    public static void buyProduct(Account account) {

        boolean buyMore;
        ArrayList<Product> cart = new ArrayList<Product>();
        do{
            System.out.println("What kind of lemonade would you like: ");

            System.out.println("1) Strawberry");
            System.out.println("2) Blueberry");
            System.out.println("3) Watermelon");
            System.out.println("4) Special Water");

            // choose which one you want
            // choose how many
            // hit buy
            // what happens to data after?
            // 
            int choice = scr.nextInt();
            System.out.println("How many: ");
            int amount = scr.nextInt();

            switch(choice) {
                case 1:
                for (int i = 0; i <= amount; i++) {
                    cart.add(strLemonade);    
                }
                case 2:
                for (int i = 0; i <= amount; i++) {
                    cart.add(bbrLemonade);   
                }
                case 3:
                for (int i = 0; i <= amount; i++) {
                    cart.add(bwmLemonade);  
                }
                case 4:
                for (int i = 0; i <= amount; i++) {
                    cart.add(sallyWater); 
                }   
                break;
                
            }

            System.out.println("Would you like to buy more?");
            buyMore = scr.nextBoolean();


        }while(buyMore == true);

        Double cost = 0.0;
        for (int i = 0; i < cart.size(); i++) {

            if(account != null){

                account.getBoughProducts().add(cart.get(i));
    
            }else {
                cost += cost + cart.get(i).getPrice();
    
                cart.get(i).removeOneProuduct();
            }

            
        }

        boolean loopAgain = false;

        do {
            CreditCardJava creditCard = CreditCardJava(account, cost);
        
        if(cost > creditCard.getBalance()){
            System.out.println("Broke people can't shop here.");
            loopAgain = true;
            System.out.println("Enter in a different card.");
        }
        }while(loopAgain);

        System.out.println("Thank you for your patronage");

    }

    public static CreditCardJava CreditCardJava(Account account, Double cost) {

        System.out.println("Your total cost will be: " + cost);

        System.out.println("What is your name on the card: ");
        String name = scr.nextLine();

        System.out.println("What is your card number: ");
        String cardNumber = scr.nextLine();

        System.out.println("What is the date on the card: ");
        String date = scr.nextLine();
        LocalDate localDate = LocalDate.parse(date);

        System.out.println("What is the ccv: ");
        String ccv = scr.nextLine();

        System.out.println("What is the zipcode: ");
        String zipCode = scr.nextLine();
        Double balance = scr.nextDouble();

        CreditCardJava creditCard = new CreditCardJava(name, cardNumber, localDate, ccv, zipCode, balance);

        System.out.println("Would you like to add this card to your account: (Y/N)");
        String y0rN = scr.nextLine();
        if (y0rN.equals("Y") && account != null){
            account.setCreditCard(creditCard);
        }else if(account == null){
            System.out.println("Please login to connect card to your acccount. ");
        }


        return creditCard;
    }
    
}
