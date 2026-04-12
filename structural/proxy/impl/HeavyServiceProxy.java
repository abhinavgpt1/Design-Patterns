public class HeavyServiceProxy implements IService {
    HeavyService heavyService;
    // Note: such kind of reference storage was seen in adapter & decorator.

    public HeavyServiceProxy() {
        // Lazy initialization is also possible
        // - put thread-safe code under if(isValid()) {...}
        this.heavyService = new HeavyService();
    }

    @Override
    public void heavyOperation() {
        System.out.println("Starting operation in proxy layer...");
        if (isValid()) {
            System.out.println("Validations passed...");
            System.out.println("Executing service...");
            heavyService.heavyOperation();
        } else {
            // restrict access by return, throw error, or handle it based on business logic
        }
    }

    private boolean isValid() {
        System.out.println("Performing validations/checks...");
        // ---------perform validations here---------
        // eg.
        // 1. has valid permissions and roles
        // 2. dependencies if any are initialized
        // 3. business logic or pre-requisites are met
        return true; // assuming they pass
    }
}
