/**
 * This approach creates a Static Inner Class as Builder. 
 * Defines the same params as LunchOrder. 
 * Exposes a function in it called build() to instantiate LunchOrder.
 * 
 * qq: why duplicate properties in builder?
 * ans: SNC is not tied to Outer class object. So, it can't set/access members of LunchOrder. 
 * Hence, we need fields internally to represent fields of LunchOrder so that they can set them properly during build().
 * FYI: using an INC instead of SNC breaks the pattern. LunchOrder lo = new LunchOrder(); lo = lo.new LunchOrder.LunchOrderBuilder().with()...build(); // this clearly doesn't look nice
 * 
 * eg.
 * class LunchOrder_NoDupFields {
 *     private String bread;
 *     public static class LunchOrderBuilder_NoDupFields {
 *         public LunchOrderBuilder_NoDupFields withBread(String bread1){
 *             bread = bread1; // error: cannot make a static reference to the non-static field
 *             // Therefore, define properties again in builder
 *             return this;
 *         }
 *     }
 * }
*/

public class LunchOrder {

    public static class LunchOrderBuilder {
        private String bread;
        private String patty;
        private String sauce;

        // Incase, we want restriction on existence of a param, then we can mention and set it in a constuctor.
        // Say, we want lunchOrder to have bread everytime
        //  public LunchOrderBuilder(String bread){
        //      this.bread = bread;
        //  }
        // We can still provide customization to the order by exposing withBread().
        // This way we've restricted lunchOrder to have bread / String at the time of creation.

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public LunchOrderBuilder withBread(String bread) {
            this.bread = bread;
            return this;
        }

        public LunchOrderBuilder withPatty(String patty) {
            this.patty = patty;
            return this;
        }

        public LunchOrderBuilder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }
    }

    // Ensure that LunchOrder properties are private and final (immutable). No Setters, only Getters.
    // Beauty: This way we achieve Bean class like customization behavior with Immutability (with contract / restrictions if needed).
    private final String bread;
    private final String patty;
    private final String sauce;

    public LunchOrder(LunchOrderBuilder lunchOrderbuilder) {
        this.bread = lunchOrderbuilder.bread;
        this.patty = lunchOrderbuilder.patty;
        this.sauce = lunchOrderbuilder.sauce;
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