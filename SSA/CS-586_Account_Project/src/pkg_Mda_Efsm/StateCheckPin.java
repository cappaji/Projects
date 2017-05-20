package pkg_Mda_Efsm;

public class StateCheckPin implements States 
{
	MDAEFSM mdaefsm = null;

	public StateCheckPin(MDAEFSM mdaefsm) {
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
		if (max > 0){
			mdaefsm.output.IncorrectPin_Msg();
			System.out.println("ENTER THE PIN AGAIN");
			mdaefsm.setState(mdaefsm.getCheckPinState());
		}
		
		else if (max == 0){
			mdaefsm.output.TooManyAttempts_Msg();
			mdaefsm.setState(mdaefsm.getIdleState());
		}
		
	}

	@Override
	public void CorrectPinBelowMin() {
		mdaefsm.output.DisplayMenu();
		mdaefsm.setState(mdaefsm.getOverdrawnState());
	}

	@Override
	public void CorrectPinAboveMin() {
		mdaefsm.output.DisplayMenu();
		mdaefsm.setState(mdaefsm.getReadyState());
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
		mdaefsm.setState(mdaefsm.getIdleState());
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
