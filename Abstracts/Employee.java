package Abstracts;

public class Employee extends Person implements Bills{

    private String fullName;


    @Override
    public double taxes(double amount) {
        return amount*.2;
    }

    @Override
    public double calculateTelePhoneBill(double amount){
        return this.taxes(amount) + amount;

    }
    
    @Override
    public String toString(); {
        return "Employee []";
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName (){
        return this.fullName;

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
