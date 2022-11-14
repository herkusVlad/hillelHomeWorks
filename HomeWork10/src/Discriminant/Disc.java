package Discriminant;

public class Disc {
    private double a;
    private double b;
    private double c;

    protected Disc() {
    }

    public Disc(String s) {
        Disc disc = new DiscFormatter().getItem(s);
        this.a = disc.getA();
        this.b = disc.getB();
        this.c = disc.getC();
    }

    public double getDiscriminant() {
        return (b * b) - (4 * a * c);
    }

    public String getEquationRoots() {
        String result = "";
        if (getDiscriminant() < 0) {
            return "Not roots";
        }

        if (getDiscriminant() > 0) {
            result = "x1 = " + (-b - Math.sqrt(getDiscriminant())) / (2 * a) + "\n";
            result += "x2 = " + (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        } else {
            result = "x1 = " + (-1 * (b / (2*a))) ;
        }
        return result;
    }

    protected void setA(double a) {
        this.a = a;
    }

    protected void setB(double b) {
        this.b = b;
    }

    protected void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
