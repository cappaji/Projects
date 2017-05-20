package pkg_Strategy;

import pkg_Data_Store.DS;
import pkg_Data_Store.DS_2;

public class Penalty2 extends Penalty{

	@Override
	public void Penalty(DS ds) {
		((DS_2)ds).setTempB((((DS_2)ds).getTempB()) - (((DS_2) ds).getTempW())- 20);
	}

}
