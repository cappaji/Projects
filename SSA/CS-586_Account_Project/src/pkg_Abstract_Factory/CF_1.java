package pkg_Abstract_Factory;

import pkg_Data_Store.DS;
import pkg_Data_Store.DS_1;
import pkg_Strategy.*;


/*
 * Concrete Factory 1 that consists of implementations of the ACCOUNT-1
 */
public class CF_1 implements AbstractFactory 
{
	DS obj_ds = new DS_1();
	StoreData obj_sdt = new StoreData1();
	DisplayBalance obj_bal = new DisplayBalance1();
	DisplayMenu obj_dme = new DisplayMenu1();
	IncorrectLockMsg obj_ilm = new IncorrectLockMsg1();
	IncorrectUnlockMsg obj_iulm = new IncorrectUnlockMsg1();
	IncorrectIdMsg obj_idm = new IncorrectIdMsg1();
	IncorrectPinMsg obj_ipm = new IncorrectPinMsg1();
	MakeDeposit obj_mdt = new MakeDeposit1();
	MakeWithdraw obj_mwt = new MakeWithdraw1();
	NoFundsMsg obj_nfm = new NoFundsMsg1();
	Penalty obj_pty = new Penalty1();
	PromptForPin obj_pfp = new PromptForPin1();
	TooManyAttemptsMsg obj_tmam = new TooManyAttemptsMsg1();
	

	@Override
	public DS CreateDataStoreObj() {
		return this.obj_ds;
	}
	
	public DS GetDataStore(){
		return this.obj_ds;
	}
	
	@Override
	public StoreData CreateStoreDataObj() {
		return this.obj_sdt; 
	}

	@Override
	public DisplayBalance CreateDisplayBalanceObj() {
		return this.obj_bal;
	}

	@Override
	public DisplayMenu CreateDisplayMenuObj() {
		return this.obj_dme;
	}

	@Override
	public IncorrectLockMsg CreateIncorrectLockMsgObj() {
		return this.obj_ilm;
	}

	@Override
	public IncorrectUnlockMsg CreateIncorrectUnlockMsgObj() {
		return this.obj_iulm;
	}

	@Override
	public IncorrectIdMsg CreateIncorrectIdMsgObj() {
		return this.obj_idm;
	}

	@Override
	public IncorrectPinMsg CreateIncorrectPinMsgObj() {
		return this.obj_ipm;
	}

	@Override
	public MakeDeposit CreateMakeDepositObj() {
		return this.obj_mdt;
	}

	@Override
	public MakeWithdraw CreateMakeWithdrawObj() {
		return this.obj_mwt;
	}

	@Override
	public NoFundsMsg CreateNoFundsMsgObj() {
		return this.obj_nfm;
	}

	@Override
	public Penalty CreatePenaltyObj() {
		return this.obj_pty;
	}

	@Override
	public PromptForPin CreatePromptForPinObj() {
		return this.obj_pfp;
	}

	@Override
	public TooManyAttemptsMsg CreateTooManyAttemptsMsgObj() {
		return this.obj_tmam;
	}

}
