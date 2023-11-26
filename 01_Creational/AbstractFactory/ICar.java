public abstract class ICar {
    protected String countryCode;
    protected String company;
    protected String name;
    
    protected int numSeats;
    
    public String getCountryCode() {
        return countryCode;
    }
    public String getCompany() {
        return company;
    }
    public String getName() {
        return name;
    }
    public int getNumSeats() {
        return numSeats;
    }
    
    public ICar(){
        createCar();
    }
    
    public abstract void createCar();
}
