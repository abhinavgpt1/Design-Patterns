public class TataFactory extends ICarCompanyFactory {

    @Override
    public ICar getCar(CarType carType) {
        switch (carType) {
            case SUV: {
                return new TataHarrier();
            }
            case SEDAN: {
                return new TataTigor();
            }
            default: {
                return null;
            }
        }
    }    
}
