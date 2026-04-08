public class Main {
    public static void main(String[] args) {
        ICarCompanyFactory mercedesFactory = ICarCompanyFactory.getCarFactory(CarCompany.MERCEDES);
        ICar mercedesSedan = mercedesFactory.getCar(CarType.SEDAN);
        mercedesSedan.printCarDetails();

        System.out.println();
        
        ICarCompanyFactory tataFactory = ICarCompanyFactory.getCarFactory(CarCompany.TATA);
        ICar tataSuv = tataFactory.getCar(CarType.SUV);
        tataSuv.printCarDetails();
    }
}
/*
 * Output
 * ------
 * Car details:
 * Company: Mercedes
 * Country Code: DE
 * Name: Mercedes-Benz C-Class
 * Number of seats: 5
 * 
 * Car details:
 * Company: Tata
 * Country Code: IN
 * Name: Tata Harrier
 * Number of seats: 5
 */
