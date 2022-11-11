import MyArrayList.MyArrayList;

public class RunApplication {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        MyArrayList list2 = new MyArrayList(3);
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("e");
        list2.add(null);
        list2.add("g");
        list2.add("h");

        System.out.println("Add some data : "+list.add("a"));
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list+"\n");

        System.out.println("Delete a : "+list.delete("a"));
        System.out.println(list);
        System.out.println("List size : " + list.size()+"\n");

        System.out.println("Delete f : "+list.delete("f"));
        System.out.println(list);
        System.out.println("List size : " + list.size()+"\n");

        System.out.println("Add NULL and 'g' " + list.add(null));
        list.add("g");
        System.out.println(list+"\n");

        System.out.println("Add 'a' like first list item : "+list.add(0,"a"));
        System.out.println(list+"\n");

        System.out.println("Add 'h' like last list item : "+list.add(7, "h"));
        System.out.println(list+"\n");

        System.out.println("Check list contains 'a': " + list.contain("a"));
        System.out.println("Check list contains 'f': " + list.contain("f")+"\n");

        System.out.println("Check list equals list2 : " + list.equals(list2));
        System.out.println("Delete NULL from list2 : " + list2.delete(null));
        System.out.println("Check list equals list2 after delete item from list2 : "+ list.equals(list2)+"\n");

        System.out.println("Clear list : "+ list.clear());
        System.out.println("List after clear : " + list);
    }
}
