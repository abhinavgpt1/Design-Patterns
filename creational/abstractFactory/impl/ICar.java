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
    
    // crux of factory pattern - abstract method for object creation.
    public abstract void createCar();

    public void printCarDetails() {
        System.out.println("Car details:");
        System.out.println("Company: " + this.getCompany());
        System.out.println("Country Code: " + this.getCountryCode());
        System.out.println("Name: " + this.getName());
        System.out.println("Number of seats: " + this.getNumSeats());
    }
}
