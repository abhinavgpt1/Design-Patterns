public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CarCompanyFactory mercedesFactory = CarCompanyFactory.getCarFactory(CarCompany.MERCEDES);
        CarCompanyFactory tataFactory = CarCompanyFactory.getCarFactory(CarCompany.TATA);
        ICar mercedesSedan = mercedesFactory.getCar(CarType.SEDAN);
        ICar tataSuv = tataFactory.getCar(CarType.SUV);
        System.out.println(mercedesSedan.getCompany() + ", " + mercedesSedan.getCountryCode() + ": " + mercedesSedan.getName());
        System.out.println(tataSuv.getCompany() + ", " + tataSuv.getCountryCode() + ": " + tataSuv.getName());
    }
}
/*
 * Output
 * ------
 * Mercedes, DE: Mercedes-Benz C-Class
 * Tata, IN: Tata Harrier
 */
