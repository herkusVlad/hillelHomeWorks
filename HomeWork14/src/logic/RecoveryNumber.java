package logic;

import java.util.ArrayList;
import java.util.List;

//Some kind of factory for StringNumber class
public class RecoveryNumber {
    private StringNumber number = new StringNumber();

    public List<String> getNumber(int num) {
        switch (num) {
            case 0:
                return number.zero();
            case 1:
                return number.one();
            case 2:
                return number.two();
            case 3:
                return number.three();
            case 4:
                return number.four();
            case 5:
                return number.five();
            case 6:
                return number.six();
            case 7:
                return number.seven();
            case 8:
                return number.eight();
            case 9:
                return number.nine();
            default:
                return new ArrayList<>();
        }
    }
}
