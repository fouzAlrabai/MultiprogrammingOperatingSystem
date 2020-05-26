package multiprogramingOS;

public class PCB {
	
	int ID;
	String State;
	int EMR;
	int ECU;
	int CUT=0;
	int IRT=0;
	int WT=0;
	String StateOfTer;
	
	public PCB(int iD, String state, int eCU,int eMR, int cUT, int iRT, int wT) {
		super();
		ID = iD;
		State = state;
		EMR = eMR;
		ECU=eCU;
		CUT = cUT;
		IRT = iRT;
		WT = wT;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getEMR() {
		return EMR;
	}

	public void setEMR(int eMR) {
		EMR = eMR;
	}

	public int getECU() {
		return ECU;
	}

	public void setECU(int eCU) {
		ECU = eCU;
	}

	public int getCUT() {
		return CUT;
	}

	public void setCUT(int cUT) {
		CUT = cUT;
	}

	public int getIRT() {
		return IRT;
	}

	public void setIRT(int iRT) {
		IRT = iRT;
	}

	public int getWT() {
		return WT;
	}

	public void setWT(int wT) {
		WT = wT;
	}
	
	public String getStateOfTer() {
		return StateOfTer;
	}

	public void setStateOfTer(String StateOfTer) {
		this.StateOfTer = StateOfTer;
	}
	
	
	
}
