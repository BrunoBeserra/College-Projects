public class Fruits {
    private String name;
    private String color;
    private String taste;

    void display()
    {
        System.out.println("I like eating " + name);
        System.out.println("The color is " + color);
        System.out.println("It tastes " + taste);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    public String getTaste() {
        return taste;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setTaste(String taste) {
        this.taste = taste;
    }
}
