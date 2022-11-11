/**
 * Author:      Phuoc Le
 * Date:        10/26/2022
 * File:        AssignmentISBN.java
 * Description: The program must calculate books returned or checked out. 
 *              For each book, check the ISBN. If the ISBN is invalid, 
 *              display an error message and re-accept the ISBN. If the 
 *              ISBN is valid, check if the book is being returned or being 
 *              checked out. At the end of the day (you decide on how you 
 *              wish to continue in the loop), display the count of books 
 *              processed, returned or checked out.
 */

import java.util.Scanner;

public class AssignmentISBN {
	
	public static void main(String[] args) {
		
		int book_returned = 0;
		int book_checked_out = 0;
	    int total_book = 0;
	    int result = 0;
	    int thirteenth_digit_int = 0;
	    String thirteenth_digit_string = "X";
	    String check_sum = "";
	    boolean shutdown_flag = false;
	       
	    System.out.println("************************************************");
	    System.out.println("* Welcome to the Daily Book Inventory Program! *");
	    System.out.println("************************************************");
	       
	    Scanner input0 = new Scanner(System.in);	       
	    do {
	    	System.out.print("Enter the first 12 digits of an ISBN-13 as a String: ");
	    	String isbn_string = input0.nextLine();
	    	int[] digit = new int [12];
	    	if (isbn_string.length() == 12) {
	    		for (int i = 0; i < 12; i++) {
	    			char digitCharacter = isbn_string.charAt(i);
	    			digit[i] = Character.getNumericValue(digitCharacter);
	    		}
	    		
	    		//do not have the textbook therefore, found the equation online
	    		//13 digits: d1d2d3d4d5d6d7d8d9d10d11d12checksum 
	    		//the thirteenth digit is the checksum
	    		//the thirteenth digit = 10-(d1+3d2+d3+3d4+d5+3d6+d7+3d8+d9+3d10+d11+3d12)%10
	    		//if the checksum is 10, have to replace it to 0
    			result = (digit[0] + 3*digit[1] + digit[2] + 3*digit[3] + digit[4]  + 3*digit[5] + 
    					  digit[6] + 3*digit[7] + digit[8] + 3*digit[9] + digit[10] + 3*digit[11]);
	    		thirteenth_digit_int = 10 - (result % 10);	    		
	    		if (thirteenth_digit_int == 10) thirteenth_digit_int = 0;
	    		
	    		//convert the thirteenth digit from integer to string
	    		thirteenth_digit_string = "" + thirteenth_digit_int;
	    		
	    		//append thirteenth_digit_string to the number originally input by the user
	    		//to get the correct ISBN-13 number
	    		check_sum = isbn_string.concat(thirteenth_digit_string);
	    		
	    		System.out.println("The ISBN-13 number is " + check_sum);
	    		System.out.println(""); //trying to match the examples
	    		
	    		Scanner input1 = new Scanner(System.in);
	    		do {
	    			System.out.print("Enter 'R' for return or 'C' for check out: ");
	    			String return_checkout = input1.nextLine();
	    			char ch1 = return_checkout.charAt(0);

	    			if ((return_checkout.length() == 1) && (ch1 == 'R' || ch1 == 'C')) { //only accept 1 UpperCase char
	    				total_book++;
	    				if (ch1 == 'R') {
	    					book_returned++;
	    				} else if (ch1 == 'C') {
	    					book_checked_out++;
	    				}
	    				System.out.println("************************************************");
	    				System.out.println("*             Daily Book Inventory             *");
	    				System.out.println("************************************************");
	    				System.out.println("Number of books returned:      " + book_returned);
	    				System.out.println("Number of books checked out:   " + book_checked_out);
	    				System.out.println("The total of books processed:  " + total_book);
	    				System.out.println("************************************************");
	    				break;
	    			} else {
	    				System.out.println("Invalid Input! Enter 'R' for return or 'C' for check out AGAIN. ");
	    			}
	    		} while (true);
	    		
	    		Scanner input2 = new Scanner(System.in);
	    		do {
	    			System.out.print("Enter 'Y' to continue, 'N' to quit: ");
	    			String continue_quit = input2.nextLine();
	    			char ch2 = continue_quit.charAt(0);
	    			if (continue_quit.length() == 1 && ch2 == 'N') { //only accept 1 UpperCase char
	    				System.out.println(""); //trying to match the examples
	    				System.out.println("************************************************");
	    				System.out.println("*             Daily Book Inventory             *");
	    				System.out.println("************************************************");
	    				System.out.println("Number of books returned:      " + book_returned);
	    				System.out.println("Number of books checked out:   " + book_checked_out);
	    				System.out.println("The total of books processed:  " + total_book);
	    				System.out.println("************************************************");
	    				shutdown_flag = true;
	    				break;
	    			} else if (continue_quit.length() == 1 && ch2 == 'Y') { //only accept 1 UpperCase char
	    				System.out.println("");
	    				break;
	    			} else {
	    				System.out.println("Invalid Input! Enter 'Y' to continue, 'N' to quit AGAIN. ");
	    			}
	    		} while (true);
	    	} else {
	    		System.out.println("Invalid ISBN-13 number! Try again.");
	    	}
	    	if(shutdown_flag){
	    		break;
	    	}
	    } while (true);
	}
}