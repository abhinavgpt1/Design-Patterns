import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Employee implements Serializable {
    private String name;
    private String address;
    private String phone;
    private transient String ssn;

    public Employee(String name, String address, String phone, String ssn) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSsn() {
        return ssn;
    }

    // Memento creation and restoration code resides in Originator

    public String serialize() {
        String employeeMementoFileName = name + "_" + new Random().nextInt(1_000_000) + ".txt";
        try (FileOutputStream fos = new FileOutputStream(employeeMementoFileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            // oos.close(); // not required since we are using try-with-resources
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeMementoFileName;
    }

    // deserialize() is a static function since we want new instance.
    // But if you're maintaining a single instance/state then it's fine to make it instance method.
    public static Person deserialize(String employeeMementoFileName) {
        Person emp = null;
        try (FileInputStream fis = new FileInputStream(employeeMementoFileName);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            emp = (Person) ois.readObject();
            // ois.close(); // not required since we are using try-with-resources
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emp;
    }
}

// This example lacks Caretaker
public class SerializableDemo {
    public static void main(String[] args) {
        Person amitEmployee = new Person("Amit", "123 Street", "555-1234", "123-45-6789"); // Originator
        String employeeMementoFileName = amitEmployee.serialize(); // Memento in this case is a file
        System.out.println("Memento created with file name: " + employeeMementoFileName);
        System.out.println();

        Person amitEmployeeDeserialized = Person.deserialize(employeeMementoFileName);
        System.out.println(amitEmployeeDeserialized.getName());
        System.out.println(amitEmployeeDeserialized.getAddress());
        System.out.println(amitEmployeeDeserialized.getPhone());
        System.out.println(amitEmployeeDeserialized.getSsn());

        // Recall: transient keyword is a variable modifier used to exclude specific
        // fields from the serialization process. When an object is converted into a
        // byte stream to be saved to a file or sent over a network, any field marked as
        // transient will be ignored by JVM.
    }
}

/**
 * Output:
 * -------
 * Memento created with file name: Amit_566629.txt
 * 
 * Amit
 * 123 Street
 * 555-1234
 * null
 */