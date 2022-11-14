public interface CustomCollection{
    boolean add(String str);

    boolean addAll(CustomCollection strColl);

    boolean delete (int index);

    boolean delete (String string);

    String get(int index);

    boolean contains(String string);

    boolean clear();

    int size();

    boolean trim();
}
