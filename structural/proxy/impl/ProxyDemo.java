public class ProxyDemo {
    public static void main(String[] args) {
        ServiceInterface clientInterface = new ActualServiceProxy();
        clientInterface.heavyOperation();   
    }    
}
/**
 * Starting operation in proxy layer...
 * Performing validations/checks...
 * ---Validations passed---
 * ---Executing main object function---
 * Executing heavy implementation code
 */
