import java.util.List;

public class AdapterDemo {
    public static void main(String[] args) {
        EmployeeClient employeeClient = new EmployeeClient();
        List<IEmployee> listEmployees = employeeClient.getAllEmployees();
        for(IEmployee employee: listEmployees)
            System.out.println(employee);
    }    
}
/*
 * Output:
 * -------
 * Employee [id=W123456, firstName=John, lastName=Smith, email=johnsmith@gmail.com]
 * Employee [id=W123457, firstName=Will, lastName=Smith, email=willsmith@gmail.com]
 * Employee [id=W123458, firstName=Adam, lastName=Smith, email=adamsmith@gmail.com]
 * EmployeeLDAPAdapter: White, Walker, W213456
 * EmployeeLDAPAdapter: Laura, Walker, W213457
 * EmployeeLDAPAdapter: Megan, Walker, W213458
 * EmployeeCSVAdapter = 106877, sherlockholmes@gmail.com
 */
