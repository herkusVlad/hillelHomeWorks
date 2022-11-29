import java.util.*;
/*
 *Имеется коллекция из String, привести все стринги в UPPERCASE и вернуть коллекцию List<Pair>
 * in: "one", "two", ...
 * out: {"one":"ONE"}, {"two", "TWO"}, ...
 */
public class StringConverter {
    private List<String> collection = new ArrayList<>();

    public StringConverter(){
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("four");
    }

    public StringConverter(List<String> list){
        collection = list;
    }

    public HashMap<String,String> convertToUpperCase(){
       HashMap<String,String> map = new HashMap<>();
       collection.forEach(e -> {
                   map.put(e,e.toUpperCase());
               });
        return map;
    }

}
