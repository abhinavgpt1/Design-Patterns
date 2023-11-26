public class Movie extends Item {
    private int runtime; //seconds

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void print(){
        System.out.println("Movie: " + this.getTitle());
        drawline(20);
        System.out.println("Price: " + this.getPrice());
        System.out.println("Runtime: " + this.getRuntime());
        System.out.println("Click here: " + this.getUrl());
        drawline(20);
        System.out.println();
    }
}
