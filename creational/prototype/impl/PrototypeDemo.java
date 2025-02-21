public class PrototypeDemo {
    public static void main(String[] args) {
        //say we want to create 1000 items of similar type, say 1000 books -> all of which will have same properties, but different values
        // clone() is lightweight and faster object instantiation, hence 1000* new << 1000*clone

        // take care of shallow vs deep copy if necessary
        Registry registry = new Registry();
        Movie SM1 = (Movie)registry.createItem("Movie");
        SM1.setTitle("Spider-Man 1");
        SM1.setPrice(10);
        SM1.setRuntime(9000);
        SM1.setUrl(SM1.getUrl()+"/spiderman1");
        SM1.print();
        
        Movie SM2 = (Movie)registry.createItem("Movie");
        SM2.setTitle("Spider-Man 2");
        SM2.setPrice(30);
        SM2.setRuntime(9900);
        SM2.setUrl(SM2.getUrl()+"/spiderman2");
        SM2.print();
        
        Book RDPD = (Book)registry.createItem("Book");
        RDPD.setAuthor("Robert Kiyosaki");
        RDPD.setTitle("Rich Dad Poor Dad");
        RDPD.setPrice(3);
        RDPD.setUrl(RDPD.getUrl() + "/richdadpoordad");
        RDPD.print();
    }
}
/*
 *  Movie: Spider-Man 1
    --------------------
    Price: 10.0
    Runtime: 9000
    Click here: https://domain.com/movies/spiderman1
    --------------------

    Movie: Spider-Man 2
    --------------------
    Price: 30.0
    Runtime: 9900
    Click here: https://domain.com/movies/spiderman2
    --------------------

    Book: Rich Dad Poor Dad
    --------------------
    Price: 3.0
    Author: Robert Kiyosaki
    Click here: https://domain.com/books/richdadpoordad
    --------------------
 */