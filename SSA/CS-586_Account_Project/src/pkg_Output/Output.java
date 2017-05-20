package pkg_Output;

import pkg_Abstract_Factory.AbstractFactory;
import pkg_Data_Store.*;
import pkg_Strategy.*;


public class Output 
{
	AbstractFactory factory =null;
	DS data_store_obj = null;
	
	//Constructor for setting the object values
	public Output(AbstractFactory factory,DS dataStore) 
	{
        this.factory = factory;
        this.data_store_obj = dataStore;
    }

	//Action that stores data values
	public void StoreData()
	{
		//String temp_s = data_store_obj.getClass().getName();
		
		System.out.println(" OUTPUT-> Action StoreData");
		StoreData sd = factory.CreateStoreDataObj();
		
			sd.StoreData(data_store_obj, data_store_obj, data_store_obj);		

	}

	public void IncorrectId_Msg()
	{
		System.out.println(" OUTPUT-> Action IncorrectId_Msg");
		IncorrectIdMsg icd_msg = factory.CreateIncorrectIdMsgObj();
		icd_msg.IncorrectIdMsg();
	}
	
	public void IncorrectPin_Msg()
	{
		System.out.println(" OUTPUT-> Action IncorrectPin_Msg");
		IncorrectPinMsg icp_msg = factory.CreateIncorrectPinMsgObj();
		icp_msg.IncorrectPinMsg();
	}
	
	public void TooManyAttempts_Msg()
	{
		System.out.println(" OUTPUT-> Action TooManyAttempts_Msg");
		TooManyAttemptsMsg tma_msg = factory.CreateTooManyAttemptsMsgObj();
		tma_msg.TooManyAttemptsMsg();
	}
	
	public void DisplayBalance()
	{
		System.out.println(" OUTPUT-> Action Balance");
		DisplayBalance dbal = factory.CreateDisplayBalanceObj();
		dbal.DisplayBalance(data_store_obj);
	}
	
	public void DisplayMenu()
	{
		System.out.println(" OUTPUT-> Action Menu");
		DisplayMenu dmenu = factory.CreateDisplayMenuObj();
		dmenu.DisplayMenu();
	}
	
	public void MakeDeposit()
	{
		System.out.println(" OUTPUT-> Action Deposit");
		MakeDeposit mdp = factory.CreateMakeDepositObj();
		mdp.MakeDeposit(data_store_obj);
	}
	
	public void MakeWithdraw()
	{
		System.out.println(" OUTPUT-> Action MakeWithdraw");
		MakeWithdraw mwdr = factory.CreateMakeWithdrawObj();
		mwdr.MakeWithdraw(data_store_obj);
	}
	
	public void Penalty()
	{
		System.out.println(" OUTPUT-> Action Penalty");
		Penalty plt = factory.CreatePenaltyObj();
		plt.Penalty(data_store_obj);
	}
	
	public void IncorrectLock_Msg()
	{
		System.out.println(" OUTPUT-> Action IncorrectLock_Msg");
		IncorrectLockMsg ilk_msg = factory.CreateIncorrectLockMsgObj();
		ilk_msg.IncorrectLockMsg();
	}
	
	public void IncorrectUnlock_Msg()
	{
		System.out.println(" OUTPUT-> Action IncorrectUnlock_Msg");
		IncorrectUnlockMsg iulk_msg = factory.CreateIncorrectUnlockMsgObj();
		iulk_msg.IncorrectUnlockMsg();
	}
	
	public void NoFunds_Msg()
	{
		System.out.println(" OUTPUT-> Action NoFunds_Msg");
		NoFundsMsg nfd_msg = factory.CreateNoFundsMsgObj();
		nfd_msg.NoFundsMsg();
	}
	
	public void PromptForPin()
	{
		System.out.println(" OUTPUT-> Action PromptForPin_Msg");
		PromptForPin pfp_msg = factory.CreatePromptForPinObj();
		pfp_msg.PromptForPin();
	}
}
