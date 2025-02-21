public abstract class Car {
    protected String countryCode;
    protected String company; // made protected so that they can be used inside subclass only

    Car() {
        createCar();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCompany() {
        return company;
    }

    // crux of factory pattern - all concrete classes will go through this method while instantiating
    public abstract void createCar();
}