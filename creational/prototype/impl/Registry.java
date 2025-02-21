import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String, Item> itemDefaultMap = new HashMap<String, Item>();
    public Registry(){
        createDefaultItems();
    }
    private void createDefaultItems(){
        Movie movie = new Movie();
        //default param for all upcoming instances of movie. can be changed too. Also, rest are type defaults
        movie.setUrl("https://domain.com/movies");
        itemDefaultMap.put("Movie", movie); // can use enums

        Book book = new Book();
        book.setUrl("https://domain.com/books");
        itemDefaultMap.put("Book", book);
    }
    public Item createItem(String type){
        Item item = null;
        try {
            //have put try-catch as clone method throws an exception
            item = (Item)(itemDefaultMap.get(type)).clone();
        } catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
        return item;
    }
}
