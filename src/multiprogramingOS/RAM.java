package multiprogramingOS;

public class RAM {
	
	int RAM= 192 * 1024;
	int AvailableSpaceInRAMFromCPU=0;
	int AvailableSpaceInRAMToHD=0;
	
	readyQueue<PCB> RQ=new readyQueue<PCB>();
	hardDisk HD=new hardDisk();
	public int fullRAM(jobQueue<PCB> JQ) {
		while(!JQ.empty()) {
			   NodeHD<PCB> pcb2=JQ.remove ();
			   int ERM=pcb2.data.EMR;
			   if(ERM<=RAM) {   
			   PCB pcb=new PCB(pcb2.data.ID,"Ready",pcb2.data.ECU,pcb2.data.EMR,0,0,0);
			   RQ.insert(pcb);
			   AvailableSpaceInRAMToHD+=pcb2.data.getEMR();
			   System.out.println("Job inserted to Ready Queue: ");
			   System.out.println("ID: "+pcb2.data.ID+" ECU: "+pcb.ECU+" EMR: "+pcb2.data.EMR+" CUT: "+pcb.CUT+" State: "+pcb.State);
			   RAM=RAM-ERM;
			   
			   }else {
				   System.out.println("Can't add more job, the RAM is full ");
				   AvailableSpaceInRAMFromCPU=CPU.pullJub(RQ);
				   System.out.println("AvailableSpaceInRAM="+AvailableSpaceInRAMFromCPU);
				   RAM+=AvailableSpaceInRAMFromCPU;
				   System.out.println("The available space of RAM after CPU= "+RAM);
			   }
			  
		   }
		AvailableSpaceInRAMFromCPU=CPU.pullJub(RQ);
		RAM+=AvailableSpaceInRAMFromCPU;
		System.out.println("RAM New="+RAM);
		System.out.println("The available space of RAM after CPU= "+RAM);
		return AvailableSpaceInRAMToHD;
	}

}
