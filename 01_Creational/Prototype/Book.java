public class Book extends Item {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void print(){
        System.out.println("Book: " + this.getTitle());
        drawline(20);
        System.out.println("Price: " + this.getPrice());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Click here: " + this.getUrl());
        drawline(20);
        System.out.println();
    }
}
