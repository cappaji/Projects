package pkg_Abstract_Factory;

import pkg_Data_Store.DS;
import pkg_Strategy.*;

public interface AbstractFactory 
{
	public DS CreateDataStoreObj();
	public StoreData CreateStoreDataObj();
	public DisplayBalance CreateDisplayBalanceObj();
	public DisplayMenu CreateDisplayMenuObj();
	public IncorrectLockMsg CreateIncorrectLockMsgObj();
	public IncorrectUnlockMsg CreateIncorrectUnlockMsgObj();
	public IncorrectIdMsg CreateIncorrectIdMsgObj();
	public IncorrectPinMsg CreateIncorrectPinMsgObj();
	public MakeDeposit CreateMakeDepositObj();
	public MakeWithdraw CreateMakeWithdrawObj();
	public NoFundsMsg CreateNoFundsMsgObj();
	public Penalty CreatePenaltyObj();
	public PromptForPin CreatePromptForPinObj();
	public TooManyAttemptsMsg CreateTooManyAttemptsMsgObj();
}
