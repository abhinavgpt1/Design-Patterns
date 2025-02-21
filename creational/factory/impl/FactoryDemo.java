// Also, checkout - https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
public class FactoryDemo {
    public static void main(String[] args) {
        Car nexon = CarFactory.getCar(CarCompany.TATA);
        Car cClass = CarFactory.getCar(CarCompany.MERCEDES);
        // since all the classes are part of default package, hence nexon.company would work -> but it shouldn't
        System.out.println(nexon.getCompany() + ", " + nexon.getCountryCode());
        System.out.println(cClass.getCompany() + ", " + cClass.getCountryCode());
    }
}
/*
 * Output:
 * -------
 * Tata, IN
 * Mercedes, DE
 */