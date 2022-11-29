package HomeWorkClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 *Имеется коллекция из String, отфильтровать и вывести на экран все значения,
             которые написаны в loverCase and length = 4
 */
public class FilterString {
    private String str = "Fasr asf hrh aasfh asge AFAF hSAGKSAK AGKAGK " + " asdf plof Aasf fssL";
    private List<String> list = new ArrayList<>();

    public FilterString(){
        list = Arrays.asList(str.split(" "));
    }

    public FilterString(String string){
        list = Arrays.asList(string.split(" "));
    }

    public FilterString(List<String> list){
        this.list = list;
    }

    public List<String> filter(){
        return list.stream()
                .filter(e-> e.equals(e.toLowerCase()))
                .filter(e -> e.length() == 4)
                .toList();
    }
}
