/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_chatapp;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class POE_ChatApp
{
    Scanner input = new Scanner(System.in);
    
	public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
	
         //WELCOMES THE USER
	 greetingsAndMenu();
	
	//VARABLLES TO CAPTURE USER CREDENTIALS
	 String userName;
	 String password;
	 String cellphoneNumber;
	 String firstName;
	 String lastName;

          //Registration of user
	   System.out.print("\nEnter your name: ");
           firstName = input.nextLine();
       
           System.out.print("\nEnter your surname: ");
           lastName = input.nextLine();
       
	   System.out.print("\nEnter your usename: ");
           userName = input.nextLine();
         
           //GIVES THE USER ANOTHER OPPORTUNITY TO ENTER THE CORRECT USERNAME
	  while (!registerUser(userName,"").equals("success"))
	  {	    
          System.out.print("\nEnter your username: ");
          userName = input.nextLine();
          }
    
         System.out.print("Enter your password: ");
	  password = input.nextLine(); 
    
          //GIVES THE USER ANOTHER OPPORTUNITY TO ENTER THE CORRECT PASSWORD
          while(!registerUser(userName,password).equals("success"))
          {
           System.out.print("Enter your password: ");
	   password = input.nextLine();   
          } 
     
          System.out.print("\nEnter your cellphone number (e.g +27********* OR 08********): ");
          cellphoneNumber = input.nextLine();
       
          //GIVES THE USER ANOTHER OPPORTUNITY TO ENTER THE CORRECT CELLPHONE NUMBER
         while (!checkCellPhoneNumber(cellphoneNumber)) {
         System.out.println("Cellphone number is incorrectly formatted. Please enter a correct number and try again.");
         System.out.print("Enter your cellphone number again: ");
         cellphoneNumber = input.nextLine();
          }

          System.out.println("Cellphone number successfully captured");
     
          //MESSAGE THAT DISPLAYS WHEN REGISTRATION IS SUCCESSFUL
          successfulRegistration(userName,password);
     
    
             //LOGGING IN OF USER
             System.out.println("\t============= LOGIN =============");
             Login.loginStatus(userName, password, firstName, lastName); 
	
	     } // end of main method
	
	     //METHOD THAT WELCOMES USER
             public static void greetingsAndMenu()
	     {
	      System.out.println("================= Welcome to the CHAT APP ==================");
	      System.out.println("\t===============  Register  ===================");    
	     }
	     //METHOD THAT CHECKS IF THE USERNAME IS IN THE CORRECT FORMAT
	     public static boolean userNameCheck(String username)
	     {
	     boolean  passwordIsValid = false;
	     if (username.contains("_") && username.length()<= 5 ) 
	      {
	     passwordIsValid = true;
	      }  
	     return passwordIsValid;
	     }
	
	     //METHOD THAT CHECKS IF THE PASSWORD IS IN THE CORRECT FORMAT
	     public static boolean checkpasswordComplexity(String password)
	     {
	     boolean correctFormat = false;
	     char character;
	     boolean passwordLength = false;
	     boolean hasNumber = false;
	     boolean hasUpperCase = false;
	     boolean hasSpecialCase = false;
	 
	     passwordLength = password.length() >= 8;
	     
	     if (passwordLength==true && !password.isEmpty())
	     { //if statement checks if the length is valid before check the characters of the password
	     for (int i=0 ; i<= password.length() - 1 ; i++)
	     {
	        
	     character = password.charAt(i); 
	    
	        if (Character.isDigit(character))
	         {
	           hasNumber = true;
	         }
	    
	         if (Character.isUpperCase(character))
	         {
	            hasUpperCase = true;
	         }
	         
	         if (!Character.isLetterOrDigit(character))
	         {
	            hasSpecialCase = true; 
	         }
	     
	      } 
	        
	            if (hasUpperCase==true && hasNumber==true && hasSpecialCase==true)
	             {
	                correctFormat = true;
	             }	 
	      } //end of if statement
	         else
	        {
	        correctFormat= false;
	       }
               return correctFormat;
	       }
	
	
             public static boolean checkCellPhoneNumber(String cellphoneNumber)
             {
              boolean validNumber= false;
      
              if (cellphoneNumber.matches("(\\+27|0)\\d{9}")){
             validNumber = true;
             } 
             return validNumber;
             }
    
             public static String registerUser(String username, String password )
             {
        
             if (password.equals("")) {
             if (!userNameCheck(username)) {
             System.out.println("\nUsername is not correctly formatted, please ensure that your username contains underscore and is no more than five characters in length.");
             System.out.println("\nPlease Try again!");
             return "invalid";
             }
             else {
             System.out.println("Username successfully captured");
             return "success";
             }
               }

             if (!checkpasswordComplexity(password)) {
             System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character");
             System.out.println("\nPlease Try again!");
             return "invalid";
             } 
             else {
             System.out.println("Password successfully captured");
              return "success";
             }  
                
               }
    
             public static void successfulRegistration(String username, String password)
             {
                if (checkpasswordComplexity(password) && userNameCheck(username)) 
               {
                System.out.println("\n Registration successful!!  Welcome "+ username);
               }
             }
    
    
    
}//end of main class

class Login {

     public static boolean loginUser(String enteredUsername, String enteredPassword,
                                    String registeredUsername, String registeredPassword,
                                    String firstName, String lastName) {

        if (enteredUsername.equals(registeredUsername) &&
            enteredPassword.equals(registeredPassword)) {

            System.out.println("\nLogin successful! Welcome back, "
                                + firstName + " " + lastName + "! It is great to see you");
            return true;

        } else {
            System.out.println("\nUsername or password incorrect. Please try again.");
            return false;
        }
    }

    public static void loginStatus(String registeredUsername, String registeredPassword,
                                    String firstName, String lastName) {

        Scanner input = new Scanner(System.in);

        String enteredUsername;
        String enteredPassword;

        boolean isLoggedIn = false;

        while (!isLoggedIn) {

            System.out.print("\nEnter your username: ");
            enteredUsername = input.nextLine();

            System.out.print("Enter your password: ");
            enteredPassword = input.nextLine();

            isLoggedIn = loginUser(enteredUsername, enteredPassword,
                                   registeredUsername, registeredPassword,
                                   firstName, lastName);
        }
    }
}
