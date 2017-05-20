package pkg_Mda_Efsm;

public class StartState implements States
{

	MDAEFSM mdaefsm = null;
	
	public StartState(MDAEFSM mdaefsm) {
		this.mdaefsm= mdaefsm;
		
	}
	@Override
	public void Open() {
		mdaefsm.output.StoreData();
		mdaefsm.setState(mdaefsm.getIdleState());
	}

	@Override
	public void Login() {
		
	}

	@Override
	public void IncorrectLogin() {
		
	}

	@Override
	public void IncorrectPin(int max) {
		
	}

	@Override
	public void CorrectPinBelowMin() {
		
	}

	@Override
	public void CorrectPinAboveMin() {
		
	}

	@Override
	public void Deposit() {
		
	}

	@Override
	public void BelowMinBalance() {
		
	}

	@Override
	public void AboveMinBalance() {
		
	}

	@Override
	public void Logout() {
		
	}

	@Override
	public void Balance() {
		
	}

	@Override
	public void Withdraw() {
		
	}

	@Override
	public void WithdrawBelowMinBalance() {
		
	}

	@Override
	public void NoFunds() {
		
	}

	@Override
	public void Lock() {
		
	}

	@Override
	public void IncorrectLock() {
		
	}

	@Override
	public void Unlock() {
		
	}

	@Override
	public void IncorrectUnlock() {
		
	}

	@Override
	public void Suspend() {
		
	}

	@Override
	public void Activate() {
		
	}

	@Override
	public void Close() {
		
	}

}
