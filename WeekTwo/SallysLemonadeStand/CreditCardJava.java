package WeekTwo.SallysLemonadeStand;

import java.sql.Date;
import java.time.LocalDate;

public class CreditCardJava {

    private String nameOnCard;
    private String cardNumber;
    private LocalDate expDate;
    private String ccv;
    private String zipCode;
    private Double balance;


    public CreditCardJava(String nameOnCard, String cardNumber, LocalDate expDate, String ccv, String zipCode,
            Double balance) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.ccv = ccv;
        this.zipCode = zipCode;
        this.balance = balance;
    }



    public CreditCardJava() {
    }




    public String getNameOnCard() {
        return nameOnCard;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public LocalDate getExpDate() {
        return expDate;
    }
    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
    public String getCcv() {
        return ccv;
    }
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    @Override
    public String toString() {
        return "CreditCardJava [nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", expDate=" + expDate
                + ", ccv=" + ccv + ", zipCode=" + zipCode + ", balance=" + balance + "]";
    }



    public Double getBalance() {
        return balance;
    }



    public void setBalance(Double balance) {
        this.balance = balance;
    }


    


    
}
