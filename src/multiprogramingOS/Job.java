package multiprogramingOS;

public class Job {
	
	int JID=0;
	int ECU;
	int EMR;
	
	public Job(int ID) {
		JID=ID;
		ECU=(int)(Math.random()*((512-16)+1))+16;
		EMR=(int)(Math.random()*((256-16)+1))+16;
		
	}
	
	public Job(int ID,int ECU,int EMR) {
		JID=ID;
		this.ECU=ECU;
		this.EMR=EMR;
		
	}
	
	
	
	public int getJID() {
		return JID;
	}

	public void setJID(int jID) {
		JID = jID;
	}

	public int getECU() {
		return ECU;
	}

	public void setECU(int eCU) {
		ECU = eCU;
	}

	public int getEMR() {
		return EMR;
	}

	public void setEMR(int eMR) {
		EMR = eMR;
	}

}
