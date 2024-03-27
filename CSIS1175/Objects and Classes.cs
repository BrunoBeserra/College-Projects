namespace Objects
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Objects
                // 1- properties (attributes) - variables
                // 2- operations (actions) - methods

            // Private
            // Protected
            // Internal
            // Public

            Student student1 = new Student();
            Student student2 = new Student();

            Student[] allStudents = new Student[10];
            List<int> myGrades = new List<int>();
            List<Student> allStudentsInCollege = new List<Student>();

            student1.StudentID = 1;
            student1.FirstName = "Bruno";
            student1.LastName = "Beserra";
            student1.Age = 30;

            allStudentsInCollege.Add(student1); // add the student to the list
            allStudents[0] = student1;          // add the student to the array


            Instructor teacher1 = new Instructor();

            Instructor.Teaching();
            teacher1.Marking();

            Math.Ceiling();

            myGrades.Add(100);
            myGrades.Add(95);
            myGrades.Add(58);
            myGrades.Remove(1);
            myGrades.Add(67);

        }
    }

    class Student
    {
        private string firstName;

        public string FirstName
        {
            get
            {
                if (firstName != "")
                {
                    return firstName;
                }
                else
                {
                    return "ERROR";
                }
            }
            set
            {
                if (firstName != "ABC")
                {
                    firstName = value;
                }
            }
        }

        
        public string LastName;
        public int Age;
        public int StudentID;
        public bool isMarried;
        public static string Department = "CSIS";



        void Enroll()
        {

        }
        void Withdraw(int courseID)
        {

        }
        public Student()
        {
            Age = 0;
            StudentID = 0;
            FirstName = "";
        }
    }
    class Instructor
    {
        public int ID;
        public string Degree;
        private string FullName;

        public Instructor()
        {
            ID = 111;
            Degree = "MS";
        }

        static public void Teaching(int courseID)
        {

        }
        public void Marking() 
        { 

        }
    }
}