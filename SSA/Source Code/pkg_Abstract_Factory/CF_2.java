package pkg_Abstract_Factory;

import pkg_Data_Store.DS;
import pkg_Data_Store.DS_2;
import pkg_Strategy.*;

public class CF_2 implements AbstractFactory
{
	DS obj_ds = new DS_2();
	StoreData obj_sdt = new StoreData2();
	DisplayBalance obj_bal = new DisplayBalance2();
	DisplayMenu obj_dme = new DisplayMenu2();
	IncorrectLockMsg obj_ilm = new IncorrectLockMsg2();
	IncorrectUnlockMsg obj_iulm = new IncorrectUnlockMsg2();
	IncorrectIdMsg obj_idm = new IncorrectIdMsg2();
	IncorrectPinMsg obj_ipm = new IncorrectPinMsg2();
	MakeDeposit obj_mdt = new MakeDeposit2();
	MakeWithdraw obj_mwt = new MakeWithdraw2();
	NoFundsMsg obj_nfm = new NoFundsMsg2();
	Penalty obj_pty = new Penalty2();
	PromptForPin obj_pfp = new PromptForPin2();
	TooManyAttemptsMsg obj_tmam = new TooManyAttemptsMsg2();
	

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
		return null;
	}

	@Override
	public IncorrectUnlockMsg CreateIncorrectUnlockMsgObj() {
		return null;
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
