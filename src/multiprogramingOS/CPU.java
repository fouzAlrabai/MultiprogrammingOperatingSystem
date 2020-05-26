package multiprogramingOS;
import static java.lang.Math.*;


public class CPU {
	
	public static int norIter=0;
	public static int abnormInter=0;
	public static int Interrupt=0;
	public static int RAM= 192 * 1024;
	public static double x,x2;
	public static int numJob=0;
	public static jobQueue<Job> JQFromHD=new jobQueue<Job>(); 
	public static readyQueue<PCB> RQ=new readyQueue<PCB>();
	public static OS os=new OS();
	public static boolean isCPUAvailable=true; 
	public static int CUT,ECU,EMR=0; 
	public static int AvailableSpace=0; 

	
	public static int pullJub(readyQueue<PCB> RQ){
		
		while(!RQ.empty() && isCPUAvailable) {
		isCPUAvailable=false;
		Node<PCB> PCB=RQ.remove();
		PCB.data.setState("Running");
		System.out.println("The Process "+PCB.data.getState()+" PID= "+PCB.data.getID()+", CUT= "+PCB.data.getCUT()+", ECU= "+PCB.data.getECU());
		 CUT = PCB.data.getCUT();
		 ECU=PCB.data.getECU();
		 EMR=PCB.data.getEMR();

		while (PCB.data.getState() != "Terminated") {
			CUT+=1 ;
			PCB.data.setCUT(CUT);
			System.out.println("The Process "+PCB.data.getState()+" PID= "+PCB.data.getID()+", CUT= "+PCB.data.getCUT()+", ECU= "+PCB.data.getECU());
			if(CUT>=ECU) {
			while (true) {

				 x = random() * 1;
				if (( round(x * 100) / 100) <= .1) { 
					 PCB.data.setState("Terminated");
					 PCB.data.setStateOfTer("Normal");
					 System.out.println("The Process "+PCB.data.getState()+" PID= "+PCB.data.getID()+", CUT= "+PCB.data.getCUT()+", ECU= "+PCB.data.getECU()+" The State Of Terminate: "+PCB.data.getStateOfTer());
					 AvailableSpace+=PCB.data.getEMR();
					 norIter++;
					 isCPUAvailable=true;
							break;
					 }
				 
				 x = random() * 1;
				 
				 if ((round(x * 100) / 100) <= .05) { 
					 PCB.data.setState("Terminated");
					 PCB.data.setStateOfTer("Abnormal");
					 System.out.println("The Process "+PCB.data.getState()+" PID= "+PCB.data.getID()+", CUT= "+PCB.data.getCUT()+", ECU= "+PCB.data.getECU()+" The State Of Terminate: "+PCB.data.getStateOfTer());
					 System.out.println(" IN Abnormal ");
					 AvailableSpace+=PCB.data.getEMR();
					 abnormInter++;
					 isCPUAvailable=true;
							break;
					 }
				
			
			}
		}//if
			else {
	
				 x = random() * 1;
				 
				 if (( round(x * 100) / 100)<= .1) { 
					 PCB.data.setState("Terminated");
					 PCB.data.setStateOfTer("Normal");
					 System.out.println("The Process "+PCB.data.getState()+" PID= "+PCB.data.getID()+", CUT= "+PCB.data.getCUT()+", ECU= "+PCB.data.getECU()+" The State Of Terminate: "+PCB.data.getStateOfTer());
					 AvailableSpace+=PCB.data.getEMR();
					 norIter++;
					 isCPUAvailable=true;
							break;
					 }
				 
				 x = random() * 1;
				 
				 if ((round(x * 100) / 100)<= .05) { 
					 PCB.data.setState("Terminated");
					 PCB.data.setStateOfTer("Abnormal");
					 System.out.println("The Process "+PCB.data.getState()+" PID= "+PCB.data.getID()+", CUT= "+PCB.data.getCUT()+", ECU= "+PCB.data.getECU()+" The State Of Terminate: "+PCB.data.getStateOfTer());
					 AvailableSpace+=PCB.data.getEMR();
					 abnormInter++;
					 isCPUAvailable=true;
							break;
					 }
				
			}//else
		}




	}
	isCPUAvailable=true;
	return AvailableSpace;
	}
}
