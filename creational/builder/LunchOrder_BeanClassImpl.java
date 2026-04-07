/**
 * Bean class: high flexibility because of setters, but is not immutable.
 */
public class LunchOrder_BeanClassImpl {
    private String bread;
    private String patty;
    private String sauce;

    // <Default constructor>

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
