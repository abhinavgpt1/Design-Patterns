public class Main {
    public static void main(String[] args) {
        CreditCard visaCard = new CreditCard("4242424242424242", "John Doe", "12/25", "123", new VisaStrategy());
        System.out.println("Is the Visa credit card valid? " + visaCard.isValid());

        CreditCard amexCard = new CreditCard("378282246310005", "Jane Smith", "11/24", "456", new AmexStrategy());
        System.out.println("Is the Amex credit card valid? " + amexCard.isValid());

        // other valid cards
        // Visa: 4012888888881881, 4000056655665556
        // Amex: 371449635398431, 378734493671000

        // See how clean our code is, imagine the nested if-else in Main otherwise.
        // From scalability pov - Other strategies can just be plugged in without changing any code here!
    }
}
/**
 * Output:
 * -------
 * Is the Visa credit card valid? true
 * Is the Amex credit card valid? true
 */