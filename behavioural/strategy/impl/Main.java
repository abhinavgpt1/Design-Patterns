public class Main {
    public static void main(String[] args) {
        ValidationStrategy visaStrategy = new VisaStrategy();
        ValidationStrategy amexStrategy = new AmexStrategy();

        CreditCard visaCard = new CreditCard("4242424242424242", "John Doe", "12/25", "123");
        System.out.println("Is the Visa credit card valid? " + visaCard.isValid(visaStrategy));
        System.out.println("Is the Visa credit card valid for Amex? " + visaCard.isValid(amexStrategy));

        System.out.println();

        CreditCard amexCard = new CreditCard("378282246310005", "Jane Smith", "11/24", "456");
        System.out.println("Is the Amex credit card valid? " + amexCard.isValid(amexStrategy));
        System.out.println("Is the Amex credit card valid for Visa? " + amexCard.isValid(visaStrategy));

        // Other test cards:
        // - Visa: 4012888888881881, 4000056655665556
        // - Amex: 371449635398431, 378734493671000

        // See how clean our code is, imagine the nested if-else in Main otherwise.
        // From scalability pov, other strategies can just be plugged in without
        // changing any (significant) code here!
    }
}
/**
 * Output:
 * -------
 * Is the Visa credit card valid? true
 * Is the Visa credit card valid for Amex? false
 * 
 * Is the Amex credit card valid? true
 * Is the Amex credit card valid for Visa? false
 */