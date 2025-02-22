public class EmployeeLDAPAdapter implements IEmployee {

    EmployeeLDAP instance;

    public EmployeeLDAPAdapter(EmployeeLDAP instance) {
        this.instance = instance;
    }

    // Some people may argue that different behaviour of toString as that in Employee.java doesn't adapt EmployeeLDAP but decorate
    // but some may argue that since we are returning the same interface and just changing the toString to represent the other way still makes it adapter
    @Override
    public String toString() {
        return "EmployeeLDAPAdapter: " + getFirstName() + ", " + getLastName() + ", " + getId();
    }
    

    @Override
    public String getEmail() {
        return instance.getWorkEmail();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String getId() {
        return instance.getWorkId();
    }

    @Override
    public String getLastName() {
        return instance.getLastName();
    }
    
}
