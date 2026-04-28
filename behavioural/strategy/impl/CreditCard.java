public class CreditCard {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    // Bryan Hansen's impl had this instance param - which make ValidationStrategy tightly coupled to card.
    // private ValidationStrategy validationStrategy;

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        // this.validationStrategy = validationStrategy;
    }

    public boolean isValid(ValidationStrategy strategy) {
        return strategy.isValid(this);
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
