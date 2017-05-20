package pkg_Strategy;

import pkg_Data_Store.*;

public class MakeDeposit1 extends MakeDeposit{

	@Override
	public void MakeDeposit(DS ds) {
		((DS_1)ds).setTempB((((DS_1)ds).getTempB()) + (((DS_1) ds).getTempD()));
	}

}
