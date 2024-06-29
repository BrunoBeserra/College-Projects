import java.util.Arrays;

public class Student extends Person{
    // Student class is the derived class
    
    // Person class is the base class
    
    String[]courses_registered;

    // parameterized constructor of the derived class
    Student(){
        System.out.println("I am a derived class");

        
    }
    Student(String first_name, String last_name, String date_of_birth, String address){
        super(first_name, last_name, date_of_birth, address);
    }

    @Override 
    void display(){
        super.display();
        System.out.println(Arrays.toString(courses_registered));
    }
    

    public static void main(String[] args) {
        Student student = new Student("Bruno", "Beserra", "1995-03-02", "Surrey");
        student.courses_registered = new String[3];
        student.courses_registered[0] = "CSIS2175";
        student.courses_registered[1] = "CSIS2300";
        student.courses_registered[2] = "CSIS2270";


        student.display();
  
    }


}
