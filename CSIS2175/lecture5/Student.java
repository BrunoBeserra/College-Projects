import java.util.Scanner;
public class Student {
    String fName;
    String lName;
    static final String college_name = "Douglas College";
    String program_enrolled;
    String[] courses_registered;
    double cgpa;

    Student(String fName, String lName, String program_enrolled)
    {
        this.fName = fName;
        this.lName = lName;
        this.program_enrolled = program_enrolled;
    }

    Student(String fName, String lName, String program_enrolled, String[] courses_registered){
        this(fName, lName, program_enrolled);
        this.courses_registered = courses_registered;
    }

    Student(String fName, String lName, String program_enrolled, String[] courses_registered, double cgpa){
        this(fName, lName, program_enrolled, courses_registered);
        this.cgpa = cgpa;
    }

    static void display(Student students){
        System.out.println("College Name: " + college_name);
        System.out.println("First Name: " + students.fName);
        System.out.println("Last Name: " + students.lName);
        System.out.println("Program Enrolled: " + students.program_enrolled);
        if(students.courses_registered != null){
            System.out.print("Courses Registered: ");
            for(int i=0; i < students.courses_registered.length; i++){
                System.out.print(students.courses_registered[i] + " ");
            }
            System.out.println("");
        }
        if (students.cgpa != 0){
            System.out.println("Student GPA: " + students.cgpa);
        }
        System.out.println("----------------------------");

    }

    static void userInfo(Student students){
        int no_of_courses = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        students.fName = input.nextLine();
        System.out.println("Enter student last name: ");
        students.lName = input.nextLine();
        System.out.println("Enter student program: ");
        students.program_enrolled = input.nextLine();
        System.out.println("Enter number of courses student is taking: ");
        no_of_courses = input.nextInt();
        input.nextLine();
        String[] courses = new String[no_of_courses];
        System.out.println("Enter student courses: ");
        for(int i=0; i < no_of_courses; i++){
            courses[i] = input.nextLine();
        }
        students.courses_registered = courses;
        System.out.println("Enter student gpa: ");
        students.cgpa = input.nextInt();
    }



    public static void main(String[] args) {
        String[] aux = {"CSIS1175", "CSIS2200", "CSIS1280"};
        Student student1 = new Student("Bruno", "Beserra", "CSIS");
        //userInfo(student1);

        //Student student2 = new Student("Breno", "Silva", "Arts", aux);
        Student student3 = new Student("Breno", "Silva", "Arts", aux, 3.87);

        //display(student1);
        //display(student2);
        display(student3);

    }


}
