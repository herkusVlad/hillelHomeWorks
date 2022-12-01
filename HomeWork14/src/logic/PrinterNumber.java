package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Class for print and parse data from array 'args'
public class PrinterNumber {
    private List<Integer> list;
    private int iterator = 0;
    private final RecoveryNumber recNumber = new RecoveryNumber();

    public PrinterNumber(String... args) {
        list = new ArrayList<>();
        Arrays.asList(args)
                .stream()
                .forEach(e -> {
                    try {
                        list.add(Integer.parseInt(e));
                    } catch (NumberFormatException exc) {
                    }
                });
    }

    public boolean add(Integer i) {
        return list.add(i);
    }

    public boolean add(String str) {
        try {
            return list.add(Integer.parseInt(str));
        } catch (NumberFormatException exc) {
        }
        return false;
    }

    public void print() {
        for(int i=1;i<=list.size();i++){
            list.stream().map(recNumber::getNumber)
                    .map(e -> e.get(iterator))
                    .forEach(e-> System.out.print(e+" "));
            iterator=i;
            System.out.println();
        }
        iterator = 0;
    }
}
