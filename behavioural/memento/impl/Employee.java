// Originator
public class Employee {
    private String name;
    private String phone;

    public Employee(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString() {
        return "Employee{name='" + name + "', phone='" + phone + "'}";
    }

    public EmployeeMemento getMemento() {
        return new EmployeeMemento(name, phone);
    }
    public void setFromMemento(EmployeeMemento memento) {
        this.name = memento.getName();
        this.phone = memento.getPhone();
    }
}
