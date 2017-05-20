package pkg_Strategy;

import pkg_Data_Store.*;

public class StoreData2 extends StoreData
{
	public void StoreData(DS ds1, DS ds2, DS ds3) {
		((DS_2)ds1).setP(((DS_2)ds1).tempP);
		((DS_2)ds2).setY(((DS_2)ds2).tempY);
		((DS_2)ds2).setA(((DS_2)ds2).tempB);
		
	}
}
