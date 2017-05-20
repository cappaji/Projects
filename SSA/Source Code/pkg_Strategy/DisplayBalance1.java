package pkg_Strategy;

import pkg_Data_Store.*;

public class DisplayBalance1 extends DisplayBalance {

	@Override
	public void DisplayBalance(DS ds) {
		System.out.println("CURRENT BALANCE IN THE ACCOUNT : "+ ((DS_1)ds).getTempB());
	}	
}
