public class Person {
    private String first_name;


    private String last_name;
    

    private String date_of_birth;
    

    private String address;

    public Person(){
        System.out.println("I am the base class");
    }


    public Person(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Person(String first_name, String last_name, String date_of_birth){
        this(first_name, last_name);
        this.date_of_birth = date_of_birth;
    }
    
    public Person(String first_name, String last_name, String date_of_birth, String address){
        this(first_name, last_name, date_of_birth);
        this.address = address;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    void display(){
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(date_of_birth);
        System.out.println(address);
    }






}
