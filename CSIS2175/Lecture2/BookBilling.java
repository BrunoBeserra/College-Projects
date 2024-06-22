import java.util.Scanner;
public class BookBilling {
    
    static final double PHOTOBOOK_PRICE = 14.99;
    static final double TAX = 0.08;
    
    // Cupons Codes
    static final int COUPOM10 = 10;
    static final int COUPOM15 = 15;
    static final int COUPOM20 = 20;
    static final int COUPOM25 = 25;

    double computeBill()
    {
        double total;
        total = PHOTOBOOK_PRICE * (1 + TAX);
        return total;
    }

    double computeBill(int quantity)
    {
        double total;
        total = PHOTOBOOK_PRICE * (1 + TAX) * quantity;
        return total;
    }

    double computeBill(int quantity, int cupomValue)
    {
        double total;
        total = (PHOTOBOOK_PRICE * quantity - cupomValue) * (1 + TAX);
        return total;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int qty_books;
        int coupom;
        BookBilling billing = new BookBilling();


        System.out.println("Welcome to the Happy Memories Company Library");

        System.out.println("Please Enter the number of books: ");
        qty_books = input.nextInt();

        System.out.println("\nPlease, now enter the discount cupom (if you have one): ");
        coupom = input.nextInt();

        if (qty_books == 1)
        {
            //billing = computeBill();
            System.out.println("The value is: " + billing.computeBill());
        }
        else if (coupom == 0) {
            //billing = computeBill(qty_books);
            System.out.println("The value is: " + billing.computeBill(qty_books));
        }
        else 
        {
            //billing = computeBill(qty_books, cupom);
            System.out.println("The value is: " + billing.computeBill(qty_books, coupom));
        }

    }


    











}
