package calculator;

/*
 * Aurthor: Harmeet Sachdeva
 */

//-----------------------------------------------------
// Import Classes to use their Methods in the program
//-----------------------------------------------------

import java.util.InputMismatchException;
import java.util.Scanner;

//-------------------------
// Class Calculator
//-------------------------

public class Calculator {
  
//--------------------------------------
//    Introduction Method
//--------------------------------------
    
    private static void introduction (){
       
        System.out.println("Please select an operation that you would like to perform:");
        
        /* 
        *  So, for fun, I decided to create an array for my intro method.  I uderstand this could
        *  have been much simpler, but I could have also created a more comlicated multidemensional array
        *  that would have had choice numbers for one demension, and computation names for another demension.
        */
        
        String [] intro = { "1 for Addition","2 for Subtraction", "3 for Muliplication", "4 for Division"};
        for (String intro1 : intro) {System.out.println("Press " + intro1 + " operation");}
        System.out.println("Press 5 to quit the program");
        System.out.print("Your choice: " );}



    
//-------------------------------------------------------
// Scanner for the whole program ( creates a new object) 
//-------------------------------------------------------
    
     static final Scanner keyboard = new Scanner (System.in);
     
//------------------------------------------------------
//        An instance of type Calcuulator
//------------------------------------------------------

     static Calculator compute = new Calculator();

//--------------------------------------------------------   
//    Static methods for different formulas
//    Parameters will be passed to float a and float b 
//    from input varables num1 and num2
//-------------------------------------------------------
    
    private static float add(float a, float b){return a + b;}
    
    private static float subtract(float a, float b){return a - b;}
        
    private static float multiply(float a, float b){return a * b;}
        
    private static float divide(float a, float b){return a / b;}

//-----------------------------------
// Pause Program
//-----------------------------------
    
    private static void pauseProgram(){
         System.out.println("Press enter to continue...");
         
        /*
         *   There seems to be a problem with java skipping the first keyboard input
         *   therefore I had to call "keyboard.nextLine();" two times to make sure that 
         *   the user has a chance to hit enter and statement is not just ignored!
         */
         
            keyboard.nextLine();
            keyboard.nextLine();
}
    
//-------------------
// Static Variables
//-------------------
    
    static float num1,num2,result;
    static String input1,input2;
    
// -----------------------------
// Methods for all computation
// -----------------------------
   

// Addition 
    private static void addResult(){
          System.out.print("Please put in 2 numbers to add, separated by space: " );    
                       
                    input1 = keyboard.next();
                    input2 = keyboard.next();
                    
                    // using Regular Expression, match for real numbers only
                    // Regular expression is used through out the program to chech that only real numbers are being input by the user
                    
                    if (!input1.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                       System.out.print("Please put in numbers! Here is a second chance: ");
                        input1 = keyboard.next();
                        input2 = keyboard.next();}
                     if (!input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
                            {throw new InputMismatchException ();}
                        num1 = Float.valueOf(input1);
                        num2 = Float.valueOf(input2);
                        result = compute.add(num1,num2);
                    System.out.printf("The result is: %.2f \n", result);
    }
    
// Subtraction
    private static void subtractResult(){
        System.out.print("Please put in 2 numbers to subtract, separated by space: " );
                    
                    input1 = keyboard.next();
                    input2 = keyboard.next();
                    if (!input1.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                       System.out.print("Please put in numbers! Here is a second chance: ");
                        input1 = keyboard.next();
                        input2 = keyboard.next();}
                     if (!input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
                            {throw new InputMismatchException ();}
                     num1 = Float.valueOf(input1);
                     num2 = Float.valueOf(input2);
                     result = compute.subtract(num1,num2);
                    System.out.printf("The result is: %.2f \n", result);
}
    
// Multiplication
    private static void multiplyResult(){
                  System.out.print("Please put in 2 numbers to mulitply, separated by space: " );
                    input1 = keyboard.next();
                    input2 = keyboard.next();
                    if (!input1.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                       System.out.print("Please put in numbers! Here is a second chance: ");
                        input1 = keyboard.next();
                        input2 = keyboard.next();}
                        if (!input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
                            {throw new InputMismatchException ();}
             
                     num1 = Float.valueOf(input1);
                     num2 = Float.valueOf(input2);
                     result = compute.multiply(num1,num2);
                    System.out.printf("The result is: %.2f \n", result);
}
    
// Division
    private static void divisionResult(){
          System.out.print("Please put in 2 numbers to divide, separated by space: " );
                     input1 = keyboard.next();
                     input2 = keyboard.next();
                 
                    if (!input1.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                       System.out.print("Please put in numbers! Here is a second chance: ");
                        input1 = keyboard.next();
                        input2 = keyboard.next();}
                        num1 = Float.valueOf(input1);
                        num2 = Float.valueOf(input2); 	
                    
                    if (input2.matches("0")) {
                        System.out.println("You cannnot divide by zero!");
                        System.out.print("Please re-enter your values: ");
                            if (!input1.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || !input2.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                                System.out.print("Please use numbers: ");
                            }
                        num1 = keyboard.nextFloat();
                        num2 = keyboard.nextFloat();}
                    
                    
                    if (num2 == 0){throw new ArithmeticException();}
                        
                    result = compute.divide(num1,num2);
                    System.out.printf("The result is: %.2f \n", result);
                    
}
    
 // end of the program
       private static void endOfProgram (){
         System.out.println("Thank you for using Harmeet's Calculator program");
         System.out.println("Goodbye!");
}
       
//--------------------------
// main Mehtod
//--------------------------
    
    public static void main(String[] args) {
        System.out.println("Welcome to Harmeet's Calculator Program"); 
        
// Set boolean variable and initialize it for later use in the while loop
        boolean q = true;
       
// Begin infinate while loop, it can be broken by user to exit the program
        
        while(q){ 
          
        // Try block to catch any exceptions
            
            try{
            
              // calling introduction method
                
                introduction();
                
                    byte selection = keyboard.nextByte();
                
               // throw an exception for any nefarious inputs by the user to the selection menu
                    
                  if (((selection <1 || selection>4 && selection!=5 ))){
                        throw new InputMismatchException ();}
         
         System.out.println("You have selected choice " + selection);
 
        // aggregate of multiple if / else statements
            
            switch (selection){
                
             // Addition
                
                case 1: 
                        addResult();
                        break;
                   
             // Subtraction
                    
                case 2: 
                    subtractResult();
                    break;
                    
            // Multiplication
                    
                case 3: 
                    multiplyResult();
                    break;
                    
            // Division        
                
                case 4: 
                    divisionResult();
                    break;
                
            // End of the program    
                
                case 5: 
                    endOfProgram();
                    q = false;
                    System.exit(0);
                    break;
                     }
            
            // loop back to beginning, but pause to have user hit enter before displaying the menu again
            
                pauseProgram(); 
                  
                }
              
      
            //   Catch the exception for division by zero
            
                catch (ArithmeticException e){
                  System.out.println("You can not divide by zero, please start over");
                   pauseProgram();}
            
            
            //  Catch the exception for input mismatch by the user
            
                 catch (InputMismatchException e){
                   System.out.println("That is not a valid choice, please try again. Program will re-start!");
                    pauseProgram();}
        }    
    
            // Closes the Scanner object
        
              keyboard.close();
    
    }
 }

    

    

 