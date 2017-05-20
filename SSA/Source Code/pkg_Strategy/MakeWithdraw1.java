package pkg_Strategy;

import pkg_Data_Store.*;

public class MakeWithdraw1 extends MakeWithdraw{

	@Override
	public void MakeWithdraw(DS ds) {
		((DS_1)ds).setTempB((((DS_1)ds).getTempB()) - (((DS_1) ds).getTempW()));
	}

}
