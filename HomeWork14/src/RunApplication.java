import logic.PrinterNumber;

public class RunApplication {
    public static void main(String[] args) {
        PrinterNumber number = new PrinterNumber(args[0]);
        number.print();
    }
}
