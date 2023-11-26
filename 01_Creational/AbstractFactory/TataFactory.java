public class TataFactory extends CarCompanyFactory {

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
