public class AmexStrategy extends ValidationStrategy {

    @Override
    boolean isValid(CreditCard creditCard) {
        boolean isValid = creditCard.getCardNumber().startsWith("34") ||
                                   creditCard.getCardNumber().startsWith("37");
        if(isValid) {
            isValid = creditCard.getCardNumber().length() == 15;
        }
        if(isValid) {
            isValid = passesLuhnAlgorithm(creditCard.getCardNumber());
        }
        return isValid;
    }
}
