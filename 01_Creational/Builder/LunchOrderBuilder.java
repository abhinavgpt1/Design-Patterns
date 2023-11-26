public class LunchOrderBuilder {

    public static class Builder {
        private String bread;
        private String patty;
        private String sauce;

        // Incase we want to put restriction on existence of a param, then we can mention and set it here in this constuctor
        // say, we want lunchOrder to have bread everytime
        // public Builder(String bread){
        //     this.bread = bread;
        //     // we can still provide customization to the order by exposing withBread()
        //     // but we have restricted lunchOrder to mention bread/String at the time of creation of lunchOrder 
        // }

        public LunchOrderBuilder build(){
            return new LunchOrderBuilder(this);
        }
        public Builder withBread(String bread){
            this.bread = bread;
            return this;
        }
        public Builder withPatty(String patty){
            this.patty = patty;
            return this;
        }
        public Builder withSauce(String sauce){
            this.sauce = sauce;
            return this;
        }
    }

    // Ensured: properties are private and immutable
    // no setters only getters
    // Beauty -> beanClass like beahviour with contract nature on constuctor
    private final String bread;
    private final String patty;
    private final String sauce;
    public LunchOrderBuilder(Builder builder) {
        this.bread = builder.bread;
        this.patty = builder.patty;
        this.sauce = builder.sauce;
    }
    public void print(){
        System.out.println("Your order:");
        drawline(20);
        if(bread != null)
        System.out.println("Bread: " + bread);
        if(patty != null)
        System.out.println("Patty: " + patty);
        if(sauce != null)
        System.out.println("Sauce: " + sauce);
        drawline(20);
    }
    public static void drawline(int length){
        for(int i=0; i<length; i++){
            System.out.print('-');
        }
        System.out.println();
    }
    public static void drawline(){
        for(int i=0; i<10; i++){
            System.out.print('-');
        }
        System.out.println();
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