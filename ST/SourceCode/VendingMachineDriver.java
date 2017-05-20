import java.io.*;
import java.util.Scanner;


public class VendingMachineDriver
{
   public static void main(String [] args)
   {

	   int userChoice=0;
	   int retr= 0;
	   
	 
	  VendingMachine obj= new VendingMachine();
	  Scanner in = new Scanner(System.in);
	  
	 
	 while(userChoice!=11){
		 
		 int n;
		 System.out.println("Please choose from below options");
		 System.out.println("1.Set_Price");
		 System.out.println("2.Insert_Large_Cups");
		 System.out.println("3.Insert_Small_Cups");
		 System.out.println("4.Coin");
		 System.out.println("5.Small_Cup");
		 System.out.println("6.Large_Cup");
		 System.out.println("7.Sugar");
		 System.out.println("8.Tea");
		 System.out.println("9.Cancel");
		 System.out.println("10.Dispose");
		 System.out.println("");
		 System.out.println("");
		 System.out.println("11.Quit");
		 System.out.println("");
		 System.out.println("");
		 System.out.println("Testing Oriented Methods");
		 System.out.println("12.Show_state");
		 System.out.println("13.Show_All_Values");
		 System.out.println("");
		 userChoice=in.nextInt();
		 
		 switch(userChoice){
		 case 1:
			 int price;
			 System.out.println("Set_Price(int p)");
			 System.out.println("Enter value of p");
			 price=in.nextInt();
			 
			 retr=obj.set_price(price);
			 System.out.println("The return value="+retr);
			 break;
		 case 2:
			 System.out.println("Insert_Large_Cups(int n)");
			 System.out.println("Enter value of n");
			 n=in.nextInt();
			 
			 retr=obj.insert_large_cups(n);
			 System.out.println("The return value="+retr);
			 break;
		 case 3:
			
			 System.out.println("Insert_Small_Cups(int n)");
			 System.out.println("Enter value of n");
			 n=in.nextInt();
			 
			 retr=obj.insert_small_cups(n);
			 System.out.println("The return value="+retr);
			 break;
		 case 4:
			 System.out.println("Coin");
			 retr=obj.coin();
			 System.out.println("The return value="+retr);
			 break;
		 case 5:
			 System.out.println("Small_Cup");
			 retr=obj.small_cup();
			 System.out.println("The return value="+retr);
			 break;
		 case 6:
			 System.out.println("Large_Cup");
			 retr=obj.large_cup();
			 System.out.println("The return value="+retr);
			 break;
		 case 7:
			 System.out.println("Sugar");
			 retr=obj.sugar();
			 System.out.println("The return value="+retr);
			 break;
		 case 8:
			 System.out.println("Tea");
			 retr=obj.tea();
			 System.out.println("The return value="+retr);
			 break;
		 case 9:
			 System.out.println("Cancel");
			 retr=obj.cancel();
			 System.out.println("The return value="+retr);
			 break;
		 case 10:
			 System.out.println("Dispose");
			 retr=obj.dispose();
			 System.out.println("The return value="+retr);
			 break;
		 case 12:
			 System.out.println("Show_State");
			 obj.Show_State();
			 System.out.println("");
			 break;
		 case 13:
			 System.out.println("Show_All_Values");
			 obj.Show_All_Values();
			 System.out.println("");
			 break;
		 default:
			 if(userChoice!=11){
			 System.out.println("Please choose only from the given options!!");
			 System.out.println("Else Enter 11 to quit");
			 }
				 break;
		 }
		 System.out.println("");
		 System.out.println("");
						 
	 }
	 
	 System.out.println("VendingMachine Driver is Stopped");
	 System.exit(0);
   }
}