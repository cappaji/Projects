package pkg_Mda_Efsm;

public interface States 
{
	public void Open();
	public void Login();
	public void IncorrectLogin();
	public void IncorrectPin(int max);
	public void CorrectPinBelowMin();
	public void CorrectPinAboveMin();
	public void Deposit();
	public void BelowMinBalance();
	public void AboveMinBalance();
	public void Logout();
	public void Balance();
	public void Withdraw();
	public void WithdrawBelowMinBalance();
	public void NoFunds();
	public void Lock();
	public void IncorrectLock();
	public void Unlock();
	public void IncorrectUnlock();
	public void Suspend();
	public void Activate();
	public void Close();

}
