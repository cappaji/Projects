package pkg_Strategy;

import pkg_Data_Store.*;


public class MakeWithdraw2 extends MakeWithdraw{

	@Override
	public void MakeWithdraw(DS ds) {
		((DS_2)ds).setTempB((((DS_2)ds).getTempB()) - (((DS_2) ds).getTempW()));
	}

}
