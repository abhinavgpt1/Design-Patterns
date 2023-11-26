import java.util.StringTokenizer;

public class EmployeeCSV {
    private int empId;
    private String firstName;
    private String familyName;
    private String workEmailId;

    public EmployeeCSV(String employeeDetails) {
        StringTokenizer tokenizer = new StringTokenizer(employeeDetails, ",");
        if (tokenizer.hasMoreTokens()) {
            this.empId = Integer.parseInt(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            this.firstName = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            this.familyName = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            this.workEmailId = tokenizer.nextToken();
        }
    }

    // Getters
    public int getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getWorkEmailId() {
        return workEmailId;
    }
}
