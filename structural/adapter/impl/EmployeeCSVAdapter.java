public class EmployeeCSVAdapter implements IEmployee {

    EmployeeCSV instance;

    public EmployeeCSVAdapter(EmployeeCSV instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "EmployeeCSVAdapter = " + getId() + ", " + getEmail();
    }

    @Override
    public String getEmail() {
        return instance.getWorkEmailId();
    }

    @Override
    public String getFirstName() {
        return instance.getFirstName();
    }

    @Override
    public String getId() {
        return String.valueOf(instance.getEmpId());
    }

    @Override
    public String getLastName() {
        return instance.getFamilyName();
    }
    
}
