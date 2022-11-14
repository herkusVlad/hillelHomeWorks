import Discriminant.Disc;

public class RunApplication {
    public static void main(String[] args) {
        Disc disc = new Disc("3-4+1");
        System.out.println("Discriminant : " + disc.getDiscriminant());
        System.out.println("Roots : " +disc.getEquationRoots()+"\n");

        disc = new Disc("1+4+4");
        System.out.println("Discriminant : " +disc.getDiscriminant());
        System.out.println("Roots : " +disc.getEquationRoots()+"\n");

        disc = new Disc("1+6+45");
        System.out.println("Discriminant : " +disc.getDiscriminant());
        System.out.println("Roots : " +disc.getEquationRoots()+"\n");
    }
}
