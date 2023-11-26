// Just a bean class
public class LunchOrderExposedSetters {
    private String bread;
    private String patty;
    private String sauce;

    // default constructor

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getPatty() {
        return patty;
    }

    public void setPatty(String patty) {
        this.patty = patty;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}

/*
 * Has high flexibility on setting the params of lunchOrder, but is not immutable
 */