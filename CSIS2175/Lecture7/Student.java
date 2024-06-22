package Lecture7;

public class Student {
    String name;
    int roll_no;
    int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRoll_no() {
        return roll_no;
    }
    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}

class NameCompare implements Comparator<Student>{
    public int compare(Student o1, Student o2){
        return o1.name.compareTo(o2.name);
    }
}

class AgeCompare implements Comparator<Student>{
    public int compare(Student o1, Student o2){
        if (o1.age == o2.age){
            return 0;
        }

        else if (o1.age > o2.age){
            return 1;
        }
        else {
            return -1;
        }
    }
}