package pkg_Mda_Efsm;

public class StopState implements States 
{
	MDAEFSM mdaefsm = null;
	
	public StopState(MDAEFSM mdaefsm) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BelowMinBalance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AboveMinBalance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Balance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void WithdrawBelowMinBalance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NoFunds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Lock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IncorrectLock() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub
		
	}

}
