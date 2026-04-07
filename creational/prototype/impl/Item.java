public abstract class Item implements Cloneable {
    private String title;
    private double price;
    private String url;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 1. Since Cloneable interface is from Java 1.0, we can't use custom class or generics. So return Object and later typecast it.
        // 2. It's Shallow copy for now, can implement deep copy too if necessary.
        return super.clone();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
