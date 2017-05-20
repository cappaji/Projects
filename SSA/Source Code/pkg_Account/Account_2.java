package pkg_Account;

import pkg_Data_Store.*;

import pkg_Mda_Efsm.MDAEFSM;

public class Account_2 
{
	MDAEFSM mdaefsm =null;
	DS datastore = null;

	public Account_2(MDAEFSM mdaefsm, DS datastore)
	{
		this.mdaefsm = mdaefsm;
		this.datastore = datastore;
		//this.OPEN(((DS_2)datastore).p, ((DS_2)datastore).y, ((DS_2)datastore).a);
	}
	


	public void OPEN(int p, int y, int a)
	{
		((DS_2)datastore).tempP = p;
		((DS_2)datastore).tempY = y;
		((DS_2)datastore).tempB = a;
		mdaefsm.Open();
	}
	
	public void LOGIN(int y)
	{
		if (y==((DS_2)datastore).tempY)
		{
			((DS_2)datastore).settemp_attempts(2);
			mdaefsm.Login();
		}
		else if(y!=((DS_2)datastore).tempY)
		{
			mdaefsm.IncorrectLogin();
		}
	}
	
	public void PIN(int x)
	{
			if((x==((DS_2)datastore).tempP))
			{
				mdaefsm.CorrectPinAboveMin();
			}
			
			else if((x!=((DS_2)datastore).tempP) && (((DS_2)datastore).temp_attempts > 0))
			{
				((DS_2)datastore).temp_attempts = ((DS_2)datastore).temp_attempts - 1;
				mdaefsm.IncorrectPin(((DS_2)datastore).temp_attempts);
			}
		
	}
	
	public void DEPOSIT(int d)
	{
		((DS_2)datastore).tempD = d;
		mdaefsm.Deposit();	
	}
	
	public void WITHDRAW(int w)
	{
		((DS_2)datastore).tempW = w;
		if ((((DS_2)datastore).tempB) <= 0)
		{
			mdaefsm.NoFunds();
		}
		else if ((((DS_2)datastore).tempB)> 0)
		{
			mdaefsm.Withdraw();
			mdaefsm.AboveMinBalance();
		}
	}
	
	public void BALANCE()
	{
		mdaefsm.Balance();
	}
	
	public void LOGOUT()
	{
		mdaefsm.Logout();
	}
	
	public void activate()
	{
		mdaefsm.Activate();
	}
	
	public void suspend()
	{
		mdaefsm.Suspend();
	}
	
	public void close()
	{
		mdaefsm.Close();
	}

}
