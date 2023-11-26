public class LunchOrderTelescope {
    private String bread;
    private String patty;
    private String sauce;

    public LunchOrderTelescope(String bread, String patty, String sauce) {
        this(bread, patty);
        // this calls another constructor which calls another constructor -> telescoping
        this.sauce = sauce;
    }
    public LunchOrderTelescope(String bread, String patty) {
        this(bread);
        this.patty = patty;
    }
    public LunchOrderTelescope(String bread) {
        this.bread = bread;
    }
    // all other variations are not possible as paramterized constructor works on the basis of datatype and no. of params
    public String getBread() {
        return bread;
    }

    public String getPatty() {
        return patty;
    }

    public String getSauce() {
        return sauce;
    }
}
/*
It does become immutable but
Drawbacks here:
What if I want only patty
What if I want patty and sauce
What if I want bread and sauce

This class doesn't allow setting params => thus becoming immutable but is not flexible to customize lunchOrder
 */