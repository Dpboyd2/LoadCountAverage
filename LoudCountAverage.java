import java.util.Scanner;

public class LoudCountAverage {

    /**Prompts the user to enter in their monthly load count for the year
     * After the input, the program calculates and displays the average load count per quarter and whole year.
     * These results will be rounded to the nearest whole number **/

     public static void main(String[] args) {
         // Initialize variables to calculate the averages for each quarter and the whole year
         double sum = 0; //Holds the total number of all loads
         double q1Sum = 0, q2Sum = 0, q3Sum = 0, q4Sum = 0; //Holds the sum of each quarter (Q1, Q2, Q3, Q4)
         int count = 12; //Number of months in a year
         
         //Array to store load count for each month of the year
         double[] monthlyLoads = new double[count];
         
         //Create scanner to take user input
         Scanner scanner = new Scanner(System.in);
         
         //Loop to collect load count for all 12 months
         for (int month = 0; month < count; month++) {
             System.out.print("Please enter the total load count for the month " + (month + 1) + " (must be a non-negative number): ");
             double currentInput; //Initialize variable to hold user input
             
             //Validate user input to make sure it's a non-negative number 
             while (true) {
                 try {
                     currentInput = scanner.nextDouble(); //Read user input as a double 
                     
                     if (currentInput < 0) { 
                         //If user input is negative, print an error message and ask again
                         System.out.println("ERROR: Load count cannot be negative! Please try again.");
                         continue; //Restart the loop to get valid input
                     }
                     break; //Exit loop if input is valid
                 } catch (Exception e) {
                     //Catch invalid input like non-numerical values and ask user to enter a valid number 
                     System.out.println("ERROR: Input must be a numeric value! Please try again.");
                     scanner.nextLine(); //Clear invalid input from the scanner buffer
                 }
             }
             monthlyLoads[month] = currentInput; //Store the valid input in the array for the current month 
         }
         
         //Calculate the sum for each quarter
         for (int i = 0; i < 3; i++) { //First quarter (Jan-March)
             q1Sum += monthlyLoads[i];
         }
         for (int i = 3; i < 6; i++) { //Second quarter (Apr-Jun)
             q2Sum += monthlyLoads[i];
         }
         for (int i = 6; i < 9; i++) { //Third quarter (Jul-Sep)
             q3Sum += monthlyLoads[i];
         }
         for (int i = 9; i < 12; i++) { //Forth quarter (Oct-Dec)
             q4Sum += monthlyLoads[i];
         }
         
         // Calculate the total sum for the whole year
         for (double load : monthlyLoads) {
             sum += load;
         }
         
         //Calculate the averages for each quarter and whole year, then rounds them to the nearest whole number
         long q1Avg = Math.round(q1Sum / 3);
         long q2Avg = Math.round(q2Sum / 3);
         long q3Avg = Math.round(q3Sum / 3);
         long q4Avg = Math.round(q4Sum / 3); 
         long yearAvg = Math.round(sum / 12);
         
         //Display the results to the user and rounds them to the nearest whole number 
         System.out.println("\n--- Results ---");
         System.out.println("Quarter 1 (Jan-March) average number of loads: " + q1Avg);
         System.out.println("Quarter 2 (Apr-Jun) average number of loads: " + q2Avg);
         System.out.println("Quarter 3 (Jul-Sep) average number of loads: " + q3Avg);
         System.out.println("Quarter 4 (Oct-Dec) average number of loads: " + q4Avg);
         System.out.println("Average monthly load count for the year: " + yearAvg);

         //Close the scanner to prevent resource leak
         scanner.close();
     }
}