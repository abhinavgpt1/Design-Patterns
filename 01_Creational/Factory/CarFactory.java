// aka Factory
public class CarFactory {

    // aka Factory method
    public static Car getCar(CarCompany carCompany) {
        switch (carCompany) {
            case MERCEDES: {
                return new Mercedes();
            }
            case TATA: {
                return new Tata();
            }        
            default: {
                return null;
            }
        }
    }
}
