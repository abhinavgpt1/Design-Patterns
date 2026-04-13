import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
    private String name;
    private String address;
    private String phone;
    public Employee(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
}

public class MementoExample {
    // this example lacks caretaker
    public static void main(String[] args) {
        Employee emp = new Employee("Amit", "123 Street", "555-1234"); // Originator
        serialize(emp);

        Employee empDeserialized = deserialize(); // Memento
        System.out.println(empDeserialized.getName());
    }
    public static void serialize(Employee emp) {
        try {
            FileOutputStream fos = new FileOutputStream("amitserialized.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Employee deserialize() {
        Employee emp = null;
        try {
            FileInputStream fis = new FileInputStream("amitserialized.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            emp = (Employee) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return emp;
    }
}

/**
 * Output:
 * -------
 * Amit
 */