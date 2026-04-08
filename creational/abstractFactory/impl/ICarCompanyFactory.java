public abstract class ICarCompanyFactory {
    // Both the methods below should be public since Main / Client uses them
    public static ICarCompanyFactory getCarFactory(CarCompany carCompany) {
        switch (carCompany) {
            case MERCEDES: {
                return new MercedesFactory();
            }
            case TATA: {
                return new TataFactory();
            }
            default: {
                System.out.println("Factory not found for this car company: " + carCompany);
                return null;
            }
        }
    }

    public abstract ICar getCar(CarType carType);
}
