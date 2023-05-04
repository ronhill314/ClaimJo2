package Abstracts;

public class Application {


    public static void main(String[] args) {

        Student donatello = new Student();
        Employee splinter = new Employee();

    double stuTelPhoneBill = donatello.calculateTelePhoneBill(120.5);
    System.out.println(stuTelPhoneBill);

    double empTelPhoneBill = splinter.calculateTelePhoneBill(120.5);
    System.out.println(empTelPhoneBill);

    Person michaelangelo = new Student();
    Person april = new Employee();

    double micTelPhoneBill = michaelangelo.calculateTelePhoneBill(120.5);
    System.out.println(stuTelPhoneBill);

    double aprTelPhoneBill = april.calculateTelePhoneBill(120.5);
    System.out.println(empTelPhoneBill);

    donatello.setFullName("dontello");
    System.out.println(donatello.getFullName());
    michaelangelo.setFullName("michael");
    System.out.println(michaelangelo.getFullName());

    School theSewerAcademy = new School();

    theSewerAcademy.getStudents().add(michaelangelo);

    }

    
}
