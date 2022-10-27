import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunApplication {

    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        student.setAddress("derib 123");
        student.setData("14/05/2000");
        student.setCourse(1);
        student.setFaculty("IOP");
        student.setGroup("101");
        student.setPhone("380976547385");
        student.setFirstName("Darim");
        student.setLastName("Darimen");
        student.setThirdName("Darimanovich");
        Student[] arr = {
                student,
                new Student("Herkus","Vladyslav","Konstantinovich",
                        "28/06/1999","tair 23","0981726438","IOP",2,"110"),
                new Student("Dar","Name","Kalmov",
                        "20/07/1999","tair 45","0981726438","IOP",3,"111"),
                new Student("Var","Jen","Solenov",
                        "25/08/1998","tair 32","0981724438","IOS",4,"111"),
                new Student("Lan","Gas","Mevon",
                        "22/09/1997","Malin 3","0981526438","IOS",1,"111"),
                new Student("Pon","Kar","Milov",
                        "18/01/1992","Kalin 2","0961726438","IOS",1,"110"),
                new Student("Far","Lat","Somin",
                        "12/02/1993","Kalin 3","0987722438","IOD",2,"110"),
                new Student("Get","Nem","Diminov",
                        "15/12/1994","Malin 12","0931526438","IOD",3,"101"),
                new Student("Hen","Oil","Kilovanichev",
                        "18/11/1991","Malin 34","0981626738","IOD",4,"101"),
                new Student("Dser","Pas","Sater",
                        "28/03/1998","tair 56","0981126338","IOS",5,"110")
        };

        System.out.println("\nGet student from faculty IOP : ");
        getFaculty(arr, "IOP");

        System.out.println("\nGet student from faculty IOS and course 1: ");
        getFacultyAndCourse(arr, "IOS",1);

        System.out.println("\nGet student older 27/03/1998 : ");
        getOlderStudent(arr, "27/03/1998");

        System.out.println("\nGet student from group 101 : ");
        getGroup(arr, "101");
    }

    public static void getFaculty(Student[] arr, String faculty){
        for(Student s: arr){
            if(s.getFaculty().equals(faculty)){
                System.out.println(s.toString());
            }
        }
    }

    public static void getFacultyAndCourse(Student[] arr, String faculty,int course){
        for(Student s: arr){
            if(s.getFaculty().equals(faculty) && s.getCourse() == course){
                System.out.println(s.toString());
            }
        }
    }

    public static void getOlderStudent(Student[] arr, String data) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        for(Student s: arr){
            if(new SimpleDateFormat("dd/MM/yyyy").parse(s.getData()).getTime() < date.getTime()){
                System.out.println(s.toString());
            }
        }
    }

    public static void getGroup(Student[] arr, String group){
        for(Student s: arr){
            if(s.getGroup().equals(group)){
                System.out.println(s.toString());
            }
        }
    }
}
