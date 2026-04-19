// Originator
public class Person {
    private String name;
    private String phone;

    public Person(String name, String phone) {
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
        return String.format("(%s, %s)", name, phone);
    }

    public PersonMemento getMemento() {
        return new PersonMemento(name, phone);
    }

    // This can be a static function as well so that you can get a new instance.
    // But if you're maintaining a single instance then it's fine.
    public void setFromMemento(PersonMemento memento) {
        this.name = memento.getName();
        this.phone = memento.getPhone();
        // Check SerializableDemo.java for transient fields.
    }
}