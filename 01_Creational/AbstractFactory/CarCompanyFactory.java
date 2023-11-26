public abstract class CarCompanyFactory {
    public static CarCompanyFactory getCarFactory(CarCompany carCompany) {
        switch (carCompany) {
            case MERCEDES: {
                return new MercedesFactory();
            }
            case TATA: {
                return new TataFactory();
            }
            default: {
                return null;
            }
        }
    }

    // need to be public (if in main class reference type of object is CarCompanyFactory and main class exists outside package (generally yes)).
    // Say these functions are protected, then due to object slicing it won't be visible outside package even if overridding function is public.
    // At the moment protected will work as AbstractFactoryDemo.java is in same package
    public abstract ICar getCar(CarType carType); 
}
