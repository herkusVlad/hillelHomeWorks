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

        while (list.hasNext()){
            System.out.println(list.next());
        }

        list.remove();
        System.out.println("List after remove : " + list);
        System.out.println(list.getUnique());
    }
}
