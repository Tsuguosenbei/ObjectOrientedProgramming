package javapackage;
import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double totalAmountBeforeDeductions = 0.0;
        int totalQuantity = 0;
        boolean isStudent = false;
        boolean continueOrdering = true;

        while (continueOrdering) {
            
            System.out.println("\n===== MENU =====");
            System.out.println("1. Burger   - $80.00");
            System.out.println("2. Pizza    - $120.00");
            System.out.println("3. Fries    - $50.00");
            System.out.println("4. Pasta    - $150.00");
            System.out.println("5. Soda     - $45.00");
            System.out.println("================");

            
            System.out.print("Enter item number (1-5): ");
            int itemNo = input.nextInt();

            if (itemNo < 1 || itemNo > 5) {
                System.out.println("Invalid entry: Item must correspond to a choice in the menu.");
                continue;
            }

       
            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            if (quantity < 1 || quantity > 10) {
                System.out.println("Invalid entry: Quantity must be at least 1 but no more than 10.");
                continue; 
            }

          
            System.out.print("Are you a student? (Y/N): ");
            String studentInput = input.next();
            if (studentInput.equalsIgnoreCase("Y")) {
                isStudent = true;
            }

         
            double price = 0;
            switch(itemNo) {
                case 1: price = 80.0; break;
                case 2: price = 120.0; break;
                case 3: price = 50.0; break;
                case 4: price = 150.0; break;
                case 5: price = 45.0; break;
            }

         
            totalAmountBeforeDeductions += (price * quantity);
            totalQuantity += quantity;

           
            System.out.print("Do you want to order again? (Y/N): ");
            String again = input.next();
            if (again.equalsIgnoreCase("N")) {
                continueOrdering = false; // 7. Stop accepting orders
            }
        }

       
        double discountRate = 0.0;
        
        if (isStudent && totalAmountBeforeDeductions >= 500) {
            discountRate = 0.15; 
        } else if (isStudent) {
            discountRate = 0.10; 
        } else if (totalAmountBeforeDeductions >= 500) {
            discountRate = 0.05;
        } 

        double totalDeduction = totalAmountBeforeDeductions * discountRate;
        double finalAmount = totalAmountBeforeDeductions - totalDeduction;

   
        System.out.println("\n===== TRANSACTION SUMMARY =====");
        System.out.println("Total quantity of items purchased: " + totalQuantity);
        System.out.printf("Total amount before deductions: $%.2f\n", totalAmountBeforeDeductions);
        System.out.printf("Total deduction: $%.2f\n", totalDeduction);
        System.out.printf("Final amount to pay: $%.2f\n", finalAmount);
        System.out.println("===============================");

        input.close();
    }
}
