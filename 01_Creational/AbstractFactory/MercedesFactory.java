public class MercedesFactory extends ICarCompanyFactory {

    @Override
    public ICar getCar(CarType carType) {
        switch (carType) {
            case SUV: {
                return new BenzGLS();
            }
            case SEDAN: {
                return new BenzCClass();
            }
            default: {
                return null;
            }
        }        
    }    
}
