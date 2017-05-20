package pkg_Data_Store;
/*
 * DS_2 is the database for the ACCOUNT-2
 */
public class DS_2 extends DS 
{
	
	public int p = tempP;
	public int y = tempY;
	public int a = tempB;
	
	//public float b = temp_a;
	public static int tempB;
	public static int tempY;
	public static int tempP;
	public int tempD;
	public int tempW;
	public int temp_attempts;
	public int attempts;
	public int flag;
	
	public DS_2() {
		super();
	}
	
	public DS_2(int p, int y, int a){
		super();
		this.p = p;
		this.y = y;
		this.a = a;
	}
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getTempB() {
		return tempB;
	}

	public void setTempB(int tempB) {
		DS_2.tempB = tempB;
	}

	public int getTempY() {
		return tempY;
	}

	public void setTempY(int tempY) {
		DS_2.tempY = tempY;
	}

	public int getTempP() {
		return tempP;
	}

	public void setTempP(int tempP) {
		DS_2.tempP = tempP;
	}

	public int getTempD() {
		return tempD;
	}

	public void setTempD(int tempD) {
		this.tempD = tempD;
	}

	public int getTempW() {
		return tempW;
	}

	public void setTempW(int tempW) {
		this.tempW = tempW;
	}
	

	public int gettemp_attempts()
	{
		return temp_attempts;
	}
	
	public void settemp_attempts(int t_at)
	{
		temp_attempts=t_at;
	}
	
	public int getattempts()
	{
		return attempts;
	}
	
	public void setattempts()
	{
		attempts = attempts+1;
	}

}