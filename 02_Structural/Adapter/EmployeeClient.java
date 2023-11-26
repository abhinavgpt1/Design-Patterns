import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
    
    public List<IEmployee> getAllEmployees() {
        List<IEmployee> listEmployees = new ArrayList<>();
        listEmployees.addAll(getDBEmployees());
        // listEmployees.addAll(getLDAPEmployees());// incompatible here : The method addAll(Collection<? extends IEmployee>) in the type List<IEmployee> is not applicable for the arguments (List<EmployeeLDAP>)
        List<EmployeeLDAP> ldapEmployees = getLDAPEmployees();
        for(EmployeeLDAP employee: ldapEmployees) {
            listEmployees.add(new EmployeeLDAPAdapter(employee));
        }

        EmployeeCSV empCsv = new EmployeeCSV("106877,Sherlock,Holmes,sherlockholmes@gmail.com");
        // listEmployees.add(empCsv); // error: The method add(IEmployee) in the type List<IEmployee> is not applicable for the arguments (EmployeeCSV)
        listEmployees.add(new EmployeeCSVAdapter(empCsv));

        return listEmployees;
    }
    
    public static List<IEmployee> getDBEmployees(){
        List<IEmployee> listEmployees = new ArrayList<>();
        listEmployees.add(new Employee("W123456", "John", "Smith", "johnsmith@gmail.com"));
        listEmployees.add(new Employee("W123457", "Will", "Smith", "willsmith@gmail.com"));
        listEmployees.add(new Employee("W123458", "Adam", "Smith", "adamsmith@gmail.com"));
        return listEmployees;
    }
    public static List<EmployeeLDAP> getLDAPEmployees(){
        List<EmployeeLDAP> listEmployees = new ArrayList<>();
        listEmployees.add(new EmployeeLDAP("W213456", "White", "Walker", "whitewalker@gmail.com"));
        listEmployees.add(new EmployeeLDAP("W213457", "Laura", "Walker", "laurawalker@gmail.com"));
        listEmployees.add(new EmployeeLDAP("W213458", "Megan", "Walker", "meganwalker@gmail.com"));
        return listEmployees;
    }
}
