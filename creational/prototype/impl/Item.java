public abstract class Item implements Cloneable {
    private String title;
    private double price;
    private String url;

    @Override
    public Object clone() throws CloneNotSupportedException{
        // 1. Since Cloneable interface is from Java1.0, we can't use custom class or generics. So return Object and later typecase it

        // 2. Shallow copy
        // Can implement deep copy too
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

    public static void drawline() {
        for(int i=0; i<10; i++){
            System.out.print('-');
        }
        System.out.println();
    }
    public static void drawline(int len) {
        for(int i=0; i<len; i++){
            System.out.print('-');
        }
        System.out.println();
    }
}
