import java.util.Scanner;
public class DemoFruit {

    public static void main(String[] args) {
        System.out.println("Enter the number of fruits");
        Scanner input = new Scanner(System.in);

        int fruitsNumber = input.nextInt();
        input.nextLine();

        Fruits[] fruits = new Fruits[fruitsNumber];

        for (int i=0;i<fruits.length;i++)
        {
            System.out.println("Enter the Name of the fruit");
            String name = input.nextLine();

            System.out.println("Enter the Color of the fruit");
            String color = input.nextLine();

            System.out.println("Enter the taste of the fruit");
            String taste = input.nextLine();

            fruits[i] = new Fruits();
            fruits[i].setName(name);
            fruits[i].setColor(color);
            fruits[i].setTaste(taste);
        }
    }
    
}
