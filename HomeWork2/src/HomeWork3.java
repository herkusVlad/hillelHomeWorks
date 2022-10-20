public class HomeWork3 {
    public static void main(String[] args) {
        double money = Double.parseDouble(args[0]);
        double percentToYear = Double.parseDouble(args[1]);
        double waitingYear = Double.parseDouble(args[2]);
        double restOfYear = isNeedTransform(waitingYear) ? roundAvoid((waitingYear - (int) waitingYear),3) : 0;

        for(int i = 0; i< (int) waitingYear; i++){
            System.out.println("Year number : " + (i+1) +". Percent to years: " +percentToYear * (i+1)
                            + ". Money from years: " + money * ((percentToYear * (i+1)) * 0.01d) );
        }

        if(isNeedTransform(waitingYear)){
            double transformYearToDecimal = restOfYear / 0.12d * 0.1d + ((int) waitingYear);
            System.out.println("Year number : " + waitingYear +". Percent to years: " +percentToYear * transformYearToDecimal
                    + ". Money from years: " + money * ((percentToYear * transformYearToDecimal) * 0.01d) );
        }
    }

    public static boolean isNeedTransform(double year){
        return !(year % (int) year == 0);
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
