public class EmployeeLDAP {
    public String workId;
    public String givenName;
    public String lastName;
    public String workEmail;

    public EmployeeLDAP(String workId, String givenName, String lastName, String workEmail) {
        this.workId = workId;
        this.givenName = givenName;
        this.lastName = lastName;
        this.workEmail = workEmail;
    }
    
    // Getters
    public String getWorkId() {
        return workId;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    // Getters
    

}