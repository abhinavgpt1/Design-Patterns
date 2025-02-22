public class ShapeFacade {
    //keeping them private so as to restrict client from internal logic access
    private Shape circle;
    private Shape square;

    //no storage of triangle object, hence client can't access it
    public ShapeFacade() {
        this.circle = new Circle();
        this.square = new Square();
    }

    //this way we limit operations on internal classes, and allow only the task we want client to have access to
    public void drawCircle() {
        this.circle.draw();
    }
    public void drawSquare() {
        this.square.draw();
    }
}
