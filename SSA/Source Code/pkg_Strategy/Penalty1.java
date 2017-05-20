package pkg_Strategy;

import pkg_Data_Store.DS;
import pkg_Data_Store.DS_1;

public class Penalty1 extends Penalty{

	@Override
	public void Penalty(DS ds) {
		((DS_1)ds).setTempB((((DS_1) ds).getTempB()) - 20);
	}

}
