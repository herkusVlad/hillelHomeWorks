import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Имеется коллекция из Integers, использую стримы посчитать среденее значения всех чисел
 */
public class Average {
    private List<Integer> list = new ArrayList<>();

    public Average(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
    }

    public void print(){
        list.forEach(e -> System.out.print(e + " "));
    }

    public double average(){
       return list.stream()
                .mapToDouble(e->e)
                .average()
                .getAsDouble();
    }
}
