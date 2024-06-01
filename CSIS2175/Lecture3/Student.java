public class Student {
    String fName;
    char midInitiaL;
    String lName;
    float cgpa;
    static int count;



    Student()
    {
        fName = "John";
        lName = "Doe";
        cgpa = 0.0f;

    }

    Student(String fName, String lName, float cgpa)
    {
        this.fName = fName;
        this.lName = lName;
        this.cgpa = cgpa;       

    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public float getCgpa() {
        return cgpa;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }


    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Peter", "Kuma", 2.67f);

        System.out.println(student2.fName + " " + student2.lName);
        System.out.println(student1.fName + " " + student1.lName);



    }





}
