package Abstracts;

public class Student extends Person implements Bills{

    private String fullName;


    @Override
    public double taxes(double amount) {
        return amount*.02;
    }

    @Override
    public double calculateTelePhoneBill(double amount){
        return this.taxes(amount) + amount;
    }

    @Override
    public String toString() {
        return "toString []";
    
    }

    @Override
    public double carInsurance(double amount) {
        return this.taxes(amount) + amount;
    }

    @Override
    public double gasBill(double amount) {
        return this.taxes(amount) + amount;
    }

    
}
