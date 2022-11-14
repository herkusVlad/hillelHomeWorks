package MyArrayList;

import MyArrayList.MyArray.MyArrayList;

public class RunApplication {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(5);
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("4");
        list.add("4");
        list.add("5");

        System.out.println("print collection with iterator method : ");
        while (list.hasNext()){
            System.out.print(list.next()+" ");
        }

        list.remove();
        System.out.println("\n\nList after remove with iterator method : " + list);

        System.out.println("\nNew collection with unique value from list : "+list.getUnique());
    }
}
