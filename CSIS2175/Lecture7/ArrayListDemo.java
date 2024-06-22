package Lecture7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {
        int isLooking = 0;
        boolean isNumberInArray = false;
        ArrayList<Double> nums = new ArrayList<Double>();

        nums.add(23.0);
        nums.add(34.5);
        nums.add(89.2);
        nums.add(45.7);
        System.out.println(nums.size());
        nums.remove(2);
        System.out.println(nums);
        nums.remove(23.0);
        System.out.println(nums);

        nums.clear();

        System.out.println(nums);

        nums.add(23.8);
        nums.add(34.5);


        ArrayList<Double> nums_2 = new ArrayList<Double>();

        nums_2.add(45.9);
        nums_2.add(35.5);
        nums_2.add(10.0);
        nums_2.add(23.0);

        nums.addAll(nums_2);

        Collections.sort(nums);
        System.out.println(nums);

        
        java.util.Iterator itr = nums.iterator();
        
        System.out.println("Enter the element you want to find in the list: ");
        
        
        
        
        
        
        
        
        
        
        
        
        /*Scanner input = new Scanner(System.in);
        
        System.out.println("Wanna search for a value in the contents? (1 - Yes, 2 - No)");
        isLooking = input.nextInt();
        
        do {

            if (isLooking == 1){
                System.out.println("Enter the number you are looking for: ");
                double userInput = input.nextDouble();

                for (double num : nums) {
                    if (num == userInput){
                        System.out.println("Number Found!");
                        isNumberInArray = true;
                        break;
                    } 
                }
                if (isNumberInArray == false){
                    System.out.println("Number not found!");
                }

                System.out.println("\nWanna look for another number? (1 - Yes, 2 - No)");
                isLooking = input.nextInt();
            }

        } while (isLooking == 1);*/










    }

    
}