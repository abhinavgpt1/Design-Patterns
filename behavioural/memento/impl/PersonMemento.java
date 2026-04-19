// Memento
public class PersonMemento {
    private String name;
    private String phone;

    public PersonMemento(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}