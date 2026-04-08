/**
 * This approach uses the same class as builder.
 * FYI, it's an early stage architecture decision which isn't flexible in
 * comparison to separate builder class approach which works well with legacy
 * code.
 * 
 * There is no build() since the instantiation happens at the start.
 * No problem of duplicate properties. No Builder class to manage.
 */
public class LunchOrder_SelfBuilder {
    private String bread;
    private String patty;
    private String sauce;

    public LunchOrder_SelfBuilder() {
        bread = null;
        patty = null;
        sauce = null;
    }

    public LunchOrder_SelfBuilder withBread(String bread) {
        this.bread = bread;
        return this;
    }

    public LunchOrder_SelfBuilder withPatty(String patty) {
        this.patty = patty;
        return this;
    }

    public LunchOrder_SelfBuilder withSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public void printOrder() {
        System.out.println("Your order:");
        if (bread != null)
            System.out.println("Bread: " + bread);
        if (patty != null)
            System.out.println("Patty: " + patty);
        if (sauce != null)
            System.out.println("Sauce: " + sauce);
    }
}