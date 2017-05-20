package pkg_Mda_Efsm;

import pkg_Abstract_Factory.AbstractFactory;
import pkg_Output.Output;

public class MDAEFSM 
{
	States start_state = new StartState(this);
	States stop_state = new StopState(this);
	//Objects for all states
	States statechkpn = new StateCheckPin(this);
	States stateidle = new StateIdle(this);
	States statelkd = new StateLocked(this);
	States stateovdr = new StateOverdrawn(this);
	States staterdy = new StateReady(this);
	States statespd = new StateSuspended(this);
	States states1 = new StateS1(this);
	
	Output output = null;
	States efsmState = null;
	AbstractFactory factory =null;
	
	//Constructor to set the object values
	public MDAEFSM (AbstractFactory fact, Output out)
	{
		efsmState = start_state;
        this.factory = fact;
        this.output = out;
	}
	
	/*
	 * Methods implementation to the next state 
	 */
	public void Open()
	{
		efsmState.Open();
		printCurrentState();
	}
	
	public void Login ()
	{
		efsmState.Login();
		printCurrentState();
	}
	
	public void IncorrectLogin()
	{
		efsmState.IncorrectLogin();
		printCurrentState();
	}
	
	public void IncorrectPin(int max)
	{
		efsmState.IncorrectPin(max);
		printCurrentState();
	}
	
	public void CorrectPinBelowMin()
	{
		efsmState.CorrectPinBelowMin();
		printCurrentState();
	}
	
	public void CorrectPinAboveMin()
	{
		efsmState.CorrectPinAboveMin();
		printCurrentState();
	}
	
	public void Deposit()
	{
		efsmState.Deposit();
		printCurrentState();
	}
	
	public void BelowMinBalance()
	{
		efsmState.BelowMinBalance();
		printCurrentState();
	}
	
	public void AboveMinBalance()
	{
		efsmState.AboveMinBalance();
		printCurrentState();
	}
	
	public void Logout()
	{
		efsmState.Logout();
		printCurrentState();
	}
	
	public void Balance()
	{
		efsmState.Balance();
		printCurrentState();
	}
	
	public void Withdraw()
	{
		efsmState.Withdraw();
		printCurrentState();
	}
	
	public void WithdrawBelowMinBalance()
	{
		efsmState.WithdrawBelowMinBalance();
		printCurrentState();
	}
	
	public void NoFunds()
	{
		efsmState.NoFunds();
		printCurrentState();
	}
	
	public void Lock()
	{
		efsmState.Lock();
		printCurrentState();
	}
	
	public void IncorrectLock()
	{
		efsmState.IncorrectLock();
		printCurrentState();
	}
	
	public void Unlock()
	{
		efsmState.Unlock();
		printCurrentState();
	}
	
	public void IncorrectUnlock()
	{
		efsmState.IncorrectUnlock();
		printCurrentState();
	}
	
	public void Suspend()
	{
		efsmState.Suspend();
		printCurrentState();
	}
	
	public void Activate()
	{
		efsmState.Activate();
		printCurrentState();
	}
	
	public void Close()
	{
		efsmState.Close();
		printCurrentState();
	}
	
	
    public void setState(States efsmState) 
    {
        this.efsmState = efsmState;
    }
    public States getAccountState() 
    {
        return efsmState;
    }
    
    public States getCheckPinState() 
    {
        return statechkpn;
    }
    public States getIdleState() 
    {
        return stateidle;
    }
    public States getLockedState() 
    {
        return statelkd;
    }
    
    public States getOverdrawnState() 
    {
        return stateovdr;
    }
    
    public States getReadyState() 
    {
        return staterdy;
    }
    
    public States getSuspendedState() 
    {
        return statespd;
    }
    
    public States getS1State() 
    {
        return states1;
    }
	public void printCurrentState()
	{
		System.out.println("The Current State is :"+ efsmState.getClass().getName());
	}

	public States getStopstate() {
		return stop_state;
	}

}
