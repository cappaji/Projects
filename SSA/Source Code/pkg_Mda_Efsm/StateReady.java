 package pkg_Mda_Efsm;

public class StateReady implements States
{
	MDAEFSM mdaefsm = null;

	public StateReady(MDAEFSM mdaefsm) {
		this.mdaefsm= mdaefsm;
	}

	@Override
	public void Open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IncorrectLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IncorrectPin(int max) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CorrectPinBelowMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CorrectPinAboveMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deposit() {
		mdaefsm.output.MakeDeposit();
		mdaefsm.setState(mdaefsm.getReadyState());
	}

	@Override
	public void BelowMinBalance() {
		
	}

	@Override
	public void AboveMinBalance() {
		
	}

	@Override
	public void Logout() {
		mdaefsm.setState(mdaefsm.getIdleState());
	}

	@Override
	public void Balance() {
		mdaefsm.output.DisplayBalance();
		mdaefsm.setState(mdaefsm.getReadyState());
	}

	@Override
	public void Withdraw() {
		mdaefsm.output.MakeWithdraw();
		mdaefsm.setState(mdaefsm.getS1State());
	}

	@Override
	public void WithdrawBelowMinBalance() {
		
	}

	@Override
	public void NoFunds() {
		mdaefsm.output.NoFunds_Msg();
		mdaefsm.setState(mdaefsm.getReadyState());
	}

	@Override
	public void Lock() {
		mdaefsm.setState(mdaefsm.getLockedState());
	}

	@Override
	public void IncorrectLock() {
		mdaefsm.output.IncorrectLock_Msg();
		mdaefsm.setState(mdaefsm.getReadyState());
	}

	@Override
	public void Unlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IncorrectUnlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Suspend() {
		mdaefsm.setState(mdaefsm.getSuspendedState());
	}

	@Override
	public void Activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Close() {
		mdaefsm.setState(mdaefsm.getStopstate());
	}

}
