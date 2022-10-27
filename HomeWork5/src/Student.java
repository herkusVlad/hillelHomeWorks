public class Student {
    private static int ALL_ID = 0;
    private int ID;
    private String lastName;
    private String firstName;
    private String thirdName;
    private String data;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student(){
        ID = ALL_ID++;
    };
    public Student(String lastName, String firstName, String thirdName, String data, String address, String phone, String faculty, int course, String group) {
        ID = ALL_ID++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.thirdName = thirdName;
        this.data = data;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student: " + ID + " "
                + lastName +
                " " + firstName +
                " " + thirdName + ',' +
                " " + data + ',' +
                " " + address + ',' +
                " " + phone + ',' +
                " " + faculty + ',' +
                " " + course + ',' +
                " " + group ;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
