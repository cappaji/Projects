package pkg_Strategy;

import pkg_Data_Store.*;

public class DisplayBalance2 extends DisplayBalance {

	@Override
	public void DisplayBalance(DS ds) {
		System.out.println("CURRENT BALANCE IN THE ACCOUNT : "+ ((DS_2)ds).getTempB());
		
	}

}
