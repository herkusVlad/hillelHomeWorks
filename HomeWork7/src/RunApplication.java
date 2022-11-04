import Collection.HandCollection;

public class RunApplication {
    public static void main(String[] args) {
        HandCollection collection = new HandCollection(5);

        System.out.println("Add string \"a\": " + collection.add("a"));
        System.out.println(collection + "\n");

        System.out.println("Delete element with 6 index Out of Bound?: "+ collection.delete(6));
        System.out.println(collection + "\n");

        System.out.println("Add some data to collection.");
        collection.add("1");
        collection.add("2");
        collection.add(null);
        collection.add("1");
        collection.add("3");
        collection.add("1");
        collection.add(null);
        System.out.println(collection + "\n");

        System.out.println("Add string \"b\" into 2 index: "+ collection.add(2,"b") );
        System.out.println(collection + "\n");

        System.out.println("Delete third element from collection : "+ collection.delete(2));
        System.out.println(collection + "\n");

        System.out.println("Add 4 to collection.");
        collection.add("4");
        System.out.println(collection + "\n");

        System.out.println("Delete first 1 from collection : "+ collection.delete("1"));
        System.out.println(collection + "\n");

        System.out.println("Delete all 1 from collection : "+ collection.deleteAll("1"));
        System.out.println(collection + "\n");

        System.out.println("Get second element from collection : " + collection.get(1));
        System.out.println(collection.get(1) + "\n");
    }
}
