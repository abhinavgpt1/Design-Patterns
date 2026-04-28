public class VisaStrategy extends ValidationStrategy {

    @Override
    public boolean isValid(CreditCard creditCard) {
        boolean isValid = creditCard.getCardNumber().startsWith("4");
        if (isValid) {
            isValid = creditCard.getCardNumber().length() == 16;
        }
        if (isValid) {
            isValid = passesLuhnAlgorithm(creditCard.getCardNumber());
        }
        return isValid;
    }
}