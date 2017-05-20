package pkg_Strategy;

import pkg_Data_Store.*;


public class MakeDeposit2 extends MakeDeposit{

	@Override
	public void MakeDeposit(DS ds) {
		((DS_2)ds).setTempB((((DS_2)ds).getTempB()) + (((DS_2) ds).getTempD()));
	}

}
