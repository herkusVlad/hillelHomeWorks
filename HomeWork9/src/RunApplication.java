public class RunApplication {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        MyLinkedList list2 = new MyLinkedList();
        list2.add("5");
        list2.add("6");
        list2.add("7");

        System.out.println("List 1 : " + list);
        System.out.println("List 2 : " + list2);
        System.out.println("Add list2 to list1 : "+ list.addAll(list2));
        System.out.println("List after adds collection : " + list +"\n");

        System.out.println("Add 8 to list : " +list.add("8"));
        System.out.println("List after adds 8 : " + list+"\n");

        System.out.println("Delete first item from list : " + list.delete(0));
        System.out.println("List after deletes first item : " + list+"\n");

        System.out.println("Delete last item from list : " + list.delete("8"));
        System.out.println("List after deletes last item : " + list+"\n");

        System.out.println("Get item with 2 index from list : " + list.get(2));
        System.out.println("Get item with 10 index from list : " + list.get(10)+"\n");

        System.out.println("Check contains 5 in list : " + list.contains("5"));
        System.out.println("Check contains 12 in list : " + list.contains("12")+"\n");

        System.out.println("Get collection size : " + list.size()+"\n");

        System.out.println("Get trim method : " + list.trim()+"\n");

        System.out.println("Clear list : "+ list.clear());
        System.out.println("Get list: " + list);

    }
}
