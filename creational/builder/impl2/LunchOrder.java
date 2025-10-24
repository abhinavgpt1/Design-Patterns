class LunchOrder{
    private String bread;
    private String patty;
    private String sauce;

    public LunchOrder(){
        bread=null;
        patty=null;
        sauce=null;
    }
    public LunchOrder withBread(String bread){
        this.bread = bread;
        return this;
    }
    public LunchOrder withPatty(String patty){
        this.patty = patty;
        return this;
    }
    public LunchOrder withSauce(String sauce){
        this.sauce = sauce;
        return this;
    }
    public void print(){
        System.out.println("Your order:");
        if(bread != null)
        System.out.println("Bread: " + bread);
        if(patty != null)
        System.out.println("Patty: " + patty);
        if(sauce != null)
        System.out.println("Sauce: " + sauce);
    }
}

class LunchOrder2 {
    private String bread;
    public static class Builder {
        public Builder withBread(String bd){
            // bread = bd; //notpossible -hence define properties again in builder
            return this;
        }
    }
}