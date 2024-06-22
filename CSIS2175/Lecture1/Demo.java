import java.util.*;

class Demo {
    public static void main(String[] args) {

        System.out.println("Hello World");
        
        Scanner input = new Scanner(System.in);
        int radius;
        
        System.out.println("Enter circle radius (integer): ");
        radius = input.nextInt();
        
        System.out.println("Enter a value (float): ");
        float userInput = input.nextFloat();

        double area = Math.PI * Math.pow(radius, 2); 
        System.out.println("The area of the circle is: " + area + " and the float input is: " + userInput);
    }
}