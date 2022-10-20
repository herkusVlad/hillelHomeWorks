public class HomeWork2 {
    public static void main(String[] args) {
        double result = 0;
        for (String arg : args){
            result+= Double.parseDouble(arg);
        }
        System.out.println(result / args.length);
    }
}
