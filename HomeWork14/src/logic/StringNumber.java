package logic;

import java.util.ArrayList;
import java.util.List;

//Class with method for gets String number
public class StringNumber {
    private final List<String> one ;
    private final List<String> two ;
    private final List<String> three ;
    private final List<String> four ;
    private final List<String> five ;
    private final List<String> six ;
    private final List<String> seven ;
    private final List<String> eight ;
    private final List<String> nine ;
    private final List<String> zero ;

    public StringNumber(){
        one = createOne();
        two = createTwo();
        three = createThree();
        four = createFour();
        five = createFive();
        six = createSix();
        seven = createSeven();
        eight = createEight();
        nine = createNine();
        zero = createZero();
    }

    public List<String> one() {
        return one;
    }

    public List<String> two() {
        return two;
    }

    public List<String> three() {
        return three;
    }

    public List<String> four() {
        return four;
    }

    public List<String> five() {
        return five;
    }

    public List<String> six() {
        return six;
    }

    public List<String> seven() {
        return seven;
    }

    public List<String> eight() {
        return eight;
    }

    public List<String> nine() {
        return nine;
    }

    public List<String> zero() {
        return zero;
    }

    private List<String> createOne(){
        List<String> list = new ArrayList<>();
        list.add("  @@  ");
        list.add("@@@@  ");
        list.add("  @@  ");
        list.add("  @@  ");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createTwo(){
        List<String> list = new ArrayList<>();
        list.add(" @@@@ ");
        list.add("@    @");
        list.add("   @@ ");
        list.add("  @@  ");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createThree(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("    @@");
        list.add("@@@@@@");
        list.add("    @@");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createFour(){
        List<String> list = new ArrayList<>();
        list.add("@@  @@");
        list.add("@@  @@");
        list.add("@@@@@@");
        list.add("    @@");
        list.add("    @@");
        return list;
    }

    private List<String> createFive(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("@@    ");
        list.add("@@@@@@");
        list.add("    @@");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createSix(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("@@    ");
        list.add("@@@@@@");
        list.add("@@  @@");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createSeven(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("   @@ ");
        list.add("  @@  ");
        list.add(" @@   ");
        list.add("@@    ");
        return list;
    }

    private List<String> createEight(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("@@  @@");
        list.add("@@@@@@");
        list.add("@@  @@");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createNine(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("@@  @@");
        list.add("@@@@@@");
        list.add("    @@");
        list.add("@@@@@@");
        return list;
    }

    private List<String> createZero(){
        List<String> list = new ArrayList<>();
        list.add("@@@@@@");
        list.add("@@  @@");
        list.add("@@  @@");
        list.add("@@  @@");
        list.add("@@@@@@");
        return list;
    }
}