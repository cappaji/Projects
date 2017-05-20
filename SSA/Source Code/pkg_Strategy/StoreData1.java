package pkg_Strategy;

import pkg_Data_Store.*;

public class StoreData1 extends StoreData
{
	public void StoreData(DS ds1, DS ds2, DS ds3) {
		((DS_1)ds1).setP(((DS_1)ds1).tempP);
		((DS_1)ds2).setY(((DS_1)ds2).tempY);
		((DS_1)ds3).setA(((DS_1)ds3).tempB);
		
	}
}
