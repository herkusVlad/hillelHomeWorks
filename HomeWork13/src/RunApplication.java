public class RunApplication {
    public static void main(String[] args) {
        System.out.println("Average from 1,2,3,4,5,6,7,8,9: " + new Average().average());

        System.out.println("\nConvert string to hashmap:");
        new StringConverter().convertToUpperCase().forEach((e,t)-> System.out.println("{"+e+" : "+ t+"}"));

        System.out.println("\nString before filter:Fasr asf hrh aasfh asge AFAF hSAGKSAK AGKAGK asdf plof Aasf fssL" +
                "\nString after filter:");
        new FilterString().filter().forEach(e-> System.out.print(e + " "));
    }
}
