public class Main {
    public static void main(String[] args) {
        IService clientInterface = new HeavyServiceProxy();
        clientInterface.heavyOperation();
    }
}
/**
 * Output:
 * -------
 * Starting operation in proxy layer...
 * Performing validations/checks...
 * Validations passed...
 * Executing service...
 * Heavy execution completed
 */
