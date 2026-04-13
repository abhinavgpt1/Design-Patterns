public abstract class ValidationStrategy {
    public abstract boolean isValid(CreditCard creditCard);

    // basic algo to validate card numbers in real-world. Eliminates auto‑generated numbers easily.
    // We want this to be used by all strategies -> hence made an abstract class instead of interface.
    protected boolean passesLuhnAlgorithm(String cardNumber) { // /loon/
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
