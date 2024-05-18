import java.util.Scanner;

public class RapidRental {
    
    public static void main(String[] args) {
        final double ECONOMY_PRICE = 31.95;
        final double INTERMEDIATE_PRICE = 41.95;
        final double FULL_PRICE = 49.95;
        final double SPECIALITY_SPORTS = 59.95;
        double chargesForRental = 0;
        int numberOfDays;
        String rentalType;
        double discount = 0.85;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the type of the rental: (Economy | Intermediate | Full-Size | Speciality-Sports)");
        rentalType = input.nextLine();
        System.out.println("Enter the number of days: ");
        numberOfDays = input.nextInt();

        /*if (rentalType.toLowerCase().equals("economy")) {
            if (numberOfDays > 7)
            {
                chargesForRental = numberOfDays * ECONOMY_PRICE * discount;
                System.out.println("The rental value is: " + chargesForRental);

            } else {
                chargesForRental = numberOfDays * ECONOMY_PRICE;
                System.out.println("The rental value is: " + chargesForRental);
            }

        } else if(rentalType.toLowerCase().equals("intermediate")) {
            if (numberOfDays > 7)
            {
                chargesForRental = numberOfDays * INTERMEDIATE_PRICE * discount;
                System.out.println("The rental value is: " + chargesForRental);

            } else {
                chargesForRental = numberOfDays * INTERMEDIATE_PRICE;
                System.out.println("The rental value is: " + chargesForRental);
            }

        } else if(rentalType.toLowerCase().equals("full-size")) {
            if (numberOfDays > 7)
            {
                chargesForRental = numberOfDays * FULL_PRICE * discount;
                System.out.println("The rental value is: " + chargesForRental);

            } else {
                chargesForRental = numberOfDays * FULL_PRICE;
                System.out.println("The rental value is: " + chargesForRental);
            }

        } else if(rentalType.toLowerCase().equals("speciality-sports")) {
            if (numberOfDays > 7)
            {
                chargesForRental = numberOfDays * SPECIALITY_SPORTS * discount;
                System.out.println("The rental value is: " + chargesForRental);

            } else {
                chargesForRental = numberOfDays * SPECIALITY_SPORTS;
                System.out.println("The rental value is: " + chargesForRental);
            }
        }
        */

        if((rentalType.toLowerCase().equals("economy")) || (rentalType.toLowerCase().equals("intermediate")) || (rentalType.toLowerCase().equals("full-size")) || (rentalType.toLowerCase().equals("speciality-sports")) && ((numberOfDays > 0) && (numberOfDays <= 30)))
        {
            if (numberOfDays < 8)
            {
                switch (rentalType.toLowerCase()) {
                    case "economy":
                        chargesForRental += numberOfDays * ECONOMY_PRICE;
                        break;
                    case "intermediate":
                        chargesForRental += numberOfDays * INTERMEDIATE_PRICE;
                        break;
                    case "full-size":
                        chargesForRental += numberOfDays * FULL_PRICE;
                        break;
                    case "speciality-sports":
                        chargesForRental += numberOfDays * SPECIALITY_SPORTS;
                        break;
                    default:
                        break;
                }
            } 
            else 
            {
                switch (rentalType.toLowerCase()) {
                    case "economy":
                        chargesForRental += numberOfDays*ECONOMY_PRICE*discount;
                        break;
                    case "intermediate":
                        chargesForRental += numberOfDays*INTERMEDIATE_PRICE*discount;
                        break;
                    case "full-size":
                        chargesForRental += numberOfDays*FULL_PRICE*discount;
                        break;
                    case "speciality-sports":
                        chargesForRental += numberOfDays*SPECIALITY_SPORTS*discount;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.print("The rental type is: " + rentalType + "\nThe period of rental is: " + numberOfDays);
        System.out.println("\nThe total charges would be: " + chargesForRental);

    }

}
