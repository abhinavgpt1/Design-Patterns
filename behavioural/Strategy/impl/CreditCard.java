public class CreditCard {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    // this instance param could've been avoided, and isValid could have taken an arg too.
    private ValidationStrategy validationStrategy;

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate, String cvv, ValidationStrategy validationStrategy) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.validationStrategy = validationStrategy;
    }

    public boolean isValid() {
        return validationStrategy.isValid(this);
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public String getCvv() {
        return cvv;
    }
}
