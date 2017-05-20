import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pkg_Abstract_Factory.CF_1;
import pkg_Abstract_Factory.CF_2;
import pkg_Account.Account_1;
import pkg_Account.Account_2;
import pkg_Mda_Efsm.MDAEFSM;
import pkg_Output.Output;

public class DriverClass {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	String input = null;
    	int choice = 1 ;
    	
    	System.out.println(" *** CS 586 ***" );
    	System.out.println(" *** Project ***" );
    	System.out.println(" *** Demo ***" );
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();

    	System.out.println("Press Enter key to continue");
    	input = bufferedReader.readLine();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	
    	for(;;){
		Return:{ System.out.println(" *** Select Account-1, Account-2 ***" );
		System.out.println("          1. Account-1" );
		System.out.println("          2. Account-2" );
		
		input = bufferedReader.readLine();
		if(input.equalsIgnoreCase("1"))
		{
			String p,y,x;
			float a,d,w;
	    	CF_1 factory = new CF_1();
	    	Output output = new Output(factory,factory.GetDataStore());
	    	MDAEFSM mdaefsm = new MDAEFSM(factory,output);
	    	Account_1 ac_1 = new Account_1(mdaefsm,factory.GetDataStore());
    	
	        System.out.println("*** Menu of Operations ***" );	
	        System.out.println("          0. open(string, string, float)" );
	        System.out.println("          1. login(string)" );
	        System.out.println("          2. pin(string)" );
	        System.out.println("          3. deposit(float)" );
	        System.out.println("          4. withdraw(float)" );
	        System.out.println("          5. balance()" );
	        System.out.println("          6. logout()" );
	        System.out.println("          7. lock(string)" );
	        System.out.println("          8. unlock(string)" );
	        System.out.println("          q. Quit the demo program" );
	        System.out.println();
	        System.out.println("  Please make a note of these operations" );	  	    	
	        System.out.println("           ACCOUNT-1 Execution" );
		
			while (true) 
	        {
	        	
	        	System.out.println("  Select Operation: ");
	        	System.out.println("0-open,1-login,2-pin,3-deposit,4-withdraw,5-balance,6-logout,7-lock,8-unlock,q-Quit");
	            try{ 
				input = bufferedReader.readLine();
	            
	
	            if(input.isEmpty()) continue;
	            if(input.equalsIgnoreCase("q"))
	            	break;
	            
	            choice = Integer.parseInt(input);
	            
	            switch(choice)
	            {
	             case 0:   //Opening Account
		      			System.out.println("  Operation:  open(string p, string y, float a)\n");
		      			System.out.println("  Enter value of the parameter p:");
		      			p = bufferedReader.readLine();
		      			System.out.println("  Enter value of the parameter y:");
		      			y = bufferedReader.readLine();
		      			System.out.println("  Enter value of the parameter a:");
		      			input = bufferedReader.readLine();
		      			a = Float.parseFloat(input);
		      			ac_1.open(p,y,a);
		      			break;
	      			
	             case 1:   //Login
		      			System.out.println("  Operation:  login(string y)");
		      			System.out.println("  Enter value of the parameter y:");
		      			y = bufferedReader.readLine();
		      			ac_1.login(y);
		      			break;
		      			
	             case 2:  //Pin
		      			System.out.println("  Operation: pin(string x)");
		      			System.out.println("  Enter value of the parameter x:");
		      			x = bufferedReader.readLine();
		      			ac_1.pin(x);
		      			break;
	
		      	 case 3:  //Deposit
		      	    	System.out.println("  Operation: deposit(float d)");
		      			System.out.println("  Enter value of the parameter d:");
		      			input = bufferedReader.readLine();
		      			d = Float.parseFloat(input);
		      			ac_1.deposit(d);
		      			break;
		      				
		      	 case 4:  //Withdraw
		      			System.out.println("  Operation:  withdraw(float w)");
		      			System.out.println("  Enter value of the parameter w:");
		      			input = bufferedReader.readLine();
		      			w = Float.parseFloat(input);
		      			ac_1.withdraw(w);
		      			break;
	
		      	 case 5:  // Balance
		      			System.out.println("  Operation:  balance()");
		      			ac_1.balance();
		      			break;
	
		      	 case 6:  // logout
		      			System.out.println("  Operation:  logout()");
		      			ac_1.logout();
		      			break;
	
		      	 case 7:  // Lock
		      			System.out.println("  Operation:  lock(string x)");
		      			System.out.println("  Enter value of the parameter x:");
		      			x = bufferedReader.readLine();
		      			ac_1.lock(x);
		      			break;
	
		      	 case 8:  // Unlock
			      		System.out.println("  Operation:  unlock(string x)");
		      			System.out.println("  Enter value of the parameter x:");
		      			x = bufferedReader.readLine();
		      			ac_1.unlock(x);
		      			break;
		      			
		      	 default:
		      			System.out.println("Invalid Choice!!! Enter a Valid Choice");
		      			break;
	            }
	            }
	            catch(NumberFormatException e){
	            	
	            	System.out.println("Enter correct choice or value of the parameter");
	            	System.out.println();
	            	
	            }
	            catch(NullPointerException e){
	            	System.out.println("Failed!!! NULL reference invoke open first");
	            	System.out.println();
	            }
	            
	        }
			System.out.println("Thanks for using Account - 1" );
			break;
        
		}
		
		else if(input.equalsIgnoreCase("2"))
		{
			int p,y,a,x,d,w;
	    	CF_2 factory = new CF_2();
	    	Output output = new Output(factory,factory.GetDataStore());
	    	MDAEFSM mdaefsm = new MDAEFSM(factory,output);
	    	Account_2 ac_2 = new Account_2(mdaefsm,factory.GetDataStore());
    	
	        System.out.println("*** Menu of Operations ***" );	
	        System.out.println("          0. OPEN(int, int, int)" );
	        System.out.println("          1. LOGIN(int)" );
	        System.out.println("          2. PIN(int)" );
	        System.out.println("          3. DEPOSIT(int)" );
	        System.out.println("          4. WITHDRAW(int)" );
	        System.out.println("          5. BALANCE()" );
	        System.out.println("          6. LOGOUT()" );
	        System.out.println("          7. suspend()" );
	        System.out.println("          8. activate()" );
	        System.out.println("          9. close()" );
	        System.out.println("          q. Quit the demo program" );
	        System.out.println();
	        System.out.println("  Please make a note of these operations" );	  	    	
	        System.out.println("           ACCOUNT-2 Execution" );
		
			while (true) 
	        {
	        	
	        	System.out.println("  Select Operation: ");
	        	System.out.println("0-OPEN,1-LOGIN,2-PIN,3-DEPOSIT,4-WITHDRAW,5-BALANCE,6-LOGOUT,7-suspend,8-activate,9-close,q-Quit");
	            try{
				input = bufferedReader.readLine();
	
	            if(input.isEmpty()) continue;
	            if(input.equalsIgnoreCase("q"))
	            	break;
	            
	            choice = Integer.parseInt(input);
	            
	            switch(choice)
	            {
	             case 0:   //Opening Account
		      			System.out.println("  Operation:  OPEN(int p, int y, int a)\n");
		      			System.out.println("  Enter value of the parameter p:");
		      			input = bufferedReader.readLine();
		      			p = Integer.parseInt(input);
		      			System.out.println("  Enter value of the parameter y:");
		      			input = bufferedReader.readLine();
		      			y = Integer.parseInt(input);
		      			System.out.println("  Enter value of the parameter a:");
		      			input = bufferedReader.readLine();
		      			a = Integer.parseInt(input);
		      			ac_2.OPEN(p,y,a);
		      			break;
	      			
	             case 1:   //Login
		      			System.out.println("  Operation:  LOGIN(int y)");
		      			System.out.println("  Enter value of the parameter y:");
		      			input = bufferedReader.readLine();
		      			y = Integer.parseInt(input);
		      			ac_2.LOGIN(y);
		      			break;
		      			
	             case 2:  //Pin
		      			System.out.println("  Operation: PIN(int x)");
		      			System.out.println("  Enter value of the parameter x:");
		      			input = bufferedReader.readLine();
		      			x = Integer.parseInt(input);
		      			ac_2.PIN(x);
		      			break;
	
		      	 case 3:  //Deposit
		      	    	System.out.println("  Operation: DEPOSIT(int d)");
		      			System.out.println("  Enter value of the parameter d:");
		      			input = bufferedReader.readLine();
		      			d = Integer.parseInt(input);
		      			ac_2.DEPOSIT(d);
		      			break;
		      				
		      	 case 4:  //Withdraw
		      			System.out.println("  Operation:  WITHDRAW(int w)");
		      			System.out.println("  Enter value of the parameter w:");
		      			input = bufferedReader.readLine();
		      			w = Integer.parseInt(input);
		      			ac_2.WITHDRAW(w);
		      			break;
	
		      	 case 5:  // Balance
		      			System.out.println("  Operation:  BALANCE()");
		      			ac_2.BALANCE();
		      			break;
	
		      	 case 6:  // Logout
		      			System.out.println("  Operation:  LOGOUT()");
		      			ac_2.LOGOUT();
		      			break;
	
		      	 case 7:  // Suspend
		      			System.out.println("  Operation:  suspend()");
		      			ac_2.suspend();
		      			break;
	
		      	 case 8:  // Activate
			      		System.out.println("  Operation:  activate()");
		      			ac_2.activate();
		      			break;
		      			
		      	 case 9:  // Close
			      		System.out.println("  Operation:  close()");
		      			ac_2.close();
		      			break;		
		      			
		      	 default:
		      			System.out.println("Invalid Choice!!! Enter a Valid Choice");
		      			break;
	            }
	            }
	            catch(NumberFormatException e){
	            	
	            	System.out.println("Enter correct choice or parameter");
	            	System.out.println();
	            	
	            }
	            catch(NullPointerException e){
	            	System.out.println("Failed!! Null reference Invoke OPEN first");
	            	System.out.println();
	            }
	            
	        }
			System.out.println("Thanks for using Account - 2" );
			break;
        
		}
		else
		{
			System.out.println("Enter either 1 or 2");
			break Return;
		}
    	}
    	}
    	}
	

}
