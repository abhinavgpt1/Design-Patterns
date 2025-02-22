public class ActualServiceProxy implements ServiceInterface {
    ActualService actualService;
    public ActualServiceProxy() {
        this.actualService = new ActualService();
    }
    
    @Override
    public void heavyOperation() {
        System.out.println("Starting operation in proxy layer...");
        if(isValid()){
            System.out.println("---Validations passed---");
            System.out.println("---Executing main object function---");
            actualService.heavyOperation();
        } else {
          //restrict access  
        }
    }

    private boolean isValid() {
        System.out.println("Performing validations/checks...");
        // add validations here
        
        // assuming the validations pass here
        return true;
    }
}
