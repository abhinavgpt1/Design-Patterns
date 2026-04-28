public abstract class ValidationStrategy {
    public abstract boolean isValid(CreditCard creditCard);

    // LuhnAlgorithm (/:loon/) is a basic algo to validate card numbers in real-world.
    // - Eliminates auto‑generated numbers easily.
    // - Since we want this common to all strategies, so ValidationStrategy is an abstract class and not an interface.
    protected boolean passesLuhnAlgorithm(String cardNumber) {
        // Logic: Double every second digit from the right, adjust values over 9, 
        // sum all digits, and check if the total is divisible by 10.
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
