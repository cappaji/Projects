package pkg_Mda_Efsm;

public class StateOverdrawn implements States 
{
	MDAEFSM mdaefsm = null;

	public StateOverdrawn(MDAEFSM mdaefsm) {
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
		mdaefsm.setState(mdaefsm.getS1State());
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
		mdaefsm.setState(mdaefsm.getIdleState());
	}

	@Override
	public void Balance() {
		mdaefsm.output.DisplayBalance();
		mdaefsm.setState(mdaefsm.getOverdrawnState());
	}

	@Override
	public void Withdraw() {
		
	}

	@Override
	public void WithdrawBelowMinBalance() {
		mdaefsm.output.NoFunds_Msg();
		System.out.println("Below minimum balance");
		mdaefsm.setState(mdaefsm.getOverdrawnState());
	}

	@Override
	public void NoFunds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Lock() {
		mdaefsm.setState(mdaefsm.getLockedState());
	}

	@Override
	public void IncorrectLock() {
		mdaefsm.output.IncorrectLock_Msg();
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
