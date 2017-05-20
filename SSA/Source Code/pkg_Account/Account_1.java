package pkg_Account;

import pkg_Data_Store.*;
import pkg_Mda_Efsm.MDAEFSM;

public class Account_1 {
	
	MDAEFSM mdaefsm =null;
	DS datastore = null;

	public Account_1(MDAEFSM mdaefsm, DS datastore)
	{
		this.mdaefsm = mdaefsm;
		this.datastore = datastore;
		//this.open(((DS_1)datastore).tempP, ((DS_1)datastore).tempY, ((DS_1)datastore).tempB);
	}
	
	
	public void open(String p, String y, float a)
	{
		((DS_1)datastore).tempP= p;
		((DS_1)datastore).tempY=y;
		((DS_1)datastore).tempB=a;
		mdaefsm.Open();
	}
	
	public void login(String y)
	{
		if ((((DS_1)datastore).tempY).equals(y))
		{
			((DS_1)datastore).settemp_attempts(3);
			mdaefsm.Login();
		}
		else
		{
			mdaefsm.IncorrectLogin();
		}
	}
	
	public void pin(String x)
	{
			if((((DS_1)datastore).tempP).equals(x) && (((DS_1)datastore).tempB > 500))
			{
				mdaefsm.CorrectPinAboveMin();
			}
			else if((((DS_1)datastore).tempP).equals(x) && (((DS_1)datastore).tempB <= 500))
			{
				mdaefsm.CorrectPinBelowMin();
			}
			else if(!(((DS_1)datastore).tempP).equals(x) && (((DS_1)datastore).temp_attempts > 0))
			{
				((DS_1)datastore).temp_attempts = ((DS_1)datastore).temp_attempts - 1;
				mdaefsm.IncorrectPin(((DS_1)datastore).temp_attempts);
			}
			
	}
	
	public void deposit(float d)
	{
		((DS_1)datastore).tempD = d;
		if (((((DS_1)datastore).tempB) + d) > 500)
		{
			mdaefsm.Deposit();
			mdaefsm.AboveMinBalance();
		}
		else if (((((DS_1)datastore).tempB) + d)  <= 500)
		{
			mdaefsm.Deposit();
			mdaefsm.BelowMinBalance();
		}
		else
		{
			mdaefsm.Deposit();
		}
	}
	
	public void withdraw(float w)
	{
		((DS_1)datastore).tempW = w;
		if (((((DS_1)datastore).tempB) - w) > 500)
		{
			mdaefsm.Withdraw();
			mdaefsm.AboveMinBalance();
		}
		else if (((((DS_1)datastore).tempB) - w)  <= 500)
		{
			mdaefsm.Withdraw();
			mdaefsm.WithdrawBelowMinBalance();
		}
		else
		{
			mdaefsm.BelowMinBalance();
		}
	}
	
	public void balance()
	{
		mdaefsm.Balance();
	}
	
	public void logout()
	{
		mdaefsm.Logout();
	}
	
	public void lock(String x)
	{
		if ((((DS_1)datastore).tempP).equals(x))
		{
			mdaefsm.Lock();
		}
		else
		{
			mdaefsm.IncorrectLock();
		}
	}
	
	public void unlock(String x)
	{
		if ((((DS_1)datastore).tempP).equals(x) && (((DS_1)datastore).tempB > 500) )
		{
			mdaefsm.Unlock();
			mdaefsm.AboveMinBalance();
		}
		else if ((((DS_1)datastore).tempP).equals(x) && (((DS_1)datastore).tempB <= 500))
		{
			mdaefsm.Unlock();
			mdaefsm.BelowMinBalance();
		}
		else if (!(((DS_1)datastore).tempP).equals(x))
		{
			mdaefsm.IncorrectUnlock();
		}
	}
	
}
