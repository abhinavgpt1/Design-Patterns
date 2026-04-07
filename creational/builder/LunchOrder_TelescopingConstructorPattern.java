/**
 * Telescoping Constructor Pattern does make class Immutable but here are the drawbacks:
 * What if I want only patty
 * What if I want patty and sauce
 * What if I want bread and sauce
 * 
 * This class doesn't allow setting params based on name
 * => Not flexible enough to customize lunchOrder
 */
public class LunchOrder_TelescopingConstructorPattern {
    private String bread;
    private String patty;
    private String sauce;

    public LunchOrder_TelescopingConstructorPattern(String bread, String patty, String sauce) {
        this(bread, patty);
        // this calls another constructor which calls another constructor -> telescoping
        this.sauce = sauce;
    }

    public LunchOrder_TelescopingConstructorPattern(String bread, String patty) {
        this(bread);
        this.patty = patty;
    }

    public LunchOrder_TelescopingConstructorPattern(String bread) {
        this.bread = bread;
    }

    // [IMP] All other variations are not possible as
    // paramterized constructor works on the basis of datatype and no. of params
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