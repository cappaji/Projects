package pkg_Data_Store;
/*
 * DS_1 is the database for the ACCOUNT-1
 */
public class DS_1 extends DS 
{
	
	public String p= tempP;
	public String y = tempY;
	public float a = tempB;
	
	//public float b = temp_a;
	public static float tempB;
	public static String tempY;
	public static String tempP;
	public float tempD;
	public float tempW;
	public int temp_attempts;
	public int attempts;
	public int flag;
	
	public DS_1() {
		super();
	}
	
	public DS_1(String p, String y,float a){
		super();
		this.p = p;
		this.y = y;
		this.a = a;
	}
	
	public String getP()
	{
		return p;
	}
	
	public void setP(String p)
	{
		this.p = p;
	}
	
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	

	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getTempB() {
		return tempB;
	}
	public void setTempB(float tempB) {
		DS_1.tempB = tempB;
	}
	public String getTempY() {
		return tempY;
	}
	public void setTempY(String tempY) {
		DS_1.tempY = tempY;
	}
	public String getTempP() {
		return tempP;
	}
	public void setTempP(String tempP) {
		DS_1.tempP = tempP;
	}
	public float getTempD() {
		return tempD;
	}
	public void setTempD(float tempD) {
		this.tempD = tempD;
	}
	public float getTempW() {
		return tempW;
	}
	public void setTempW(float tempW) {
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
