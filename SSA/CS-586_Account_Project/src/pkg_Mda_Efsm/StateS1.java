package pkg_Mda_Efsm;

public class StateS1 implements States
{
	MDAEFSM mdaefsm = null;

	public StateS1(MDAEFSM mdaefsm) {
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
		
	}

	@Override
	public void BelowMinBalance() {
		mdaefsm.setState(mdaefsm.getOverdrawnState());
	}

	@Override
	public void AboveMinBalance() {
		mdaefsm.setState(mdaefsm.getReadyState());
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
		mdaefsm.output.Penalty();
		mdaefsm.setState(mdaefsm.getOverdrawnState());
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
