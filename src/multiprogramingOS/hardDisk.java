package multiprogramingOS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class hardDisk {
	int hardDisk=2 * 1024 * 1024;
	jobQueue<PCB> JQ=new jobQueue<PCB>();
	int NumOfProcess=0;
	static RAM ram=new RAM();
	boolean fillIsEmply=false;
	int SumJobSize=0;
	int MinJobSize=0;
	int MaxJobSize=0;
	int AvailableSpaceInHD=0;
	ArrayList <Integer> list=new ArrayList<>();
	public void ReadFile(String file){ 
	 try {
		   FileReader FR=new FileReader(file);
		   BufferedReader br=new BufferedReader(FR);
		   String Line;
		   while((Line=br.readLine())!=null) {
			   
			   System.out.println("Reading from Job.txt file");
			   int StartIndex1=Line.indexOf(":");
			   int EndIndex1=Line.indexOf(",");
			   String id=Line.substring(StartIndex1+1, EndIndex1);
			   
			   int StartIndex2=Line.indexOf(":",StartIndex1+1);
			   int EndIndex2=Line.indexOf(",",EndIndex1+1);
			   String ECU=Line.substring(StartIndex2+1, EndIndex2);
			   
			   int StartIndex3=Line.indexOf(":",StartIndex2+1);
			   String EMR=Line.substring(StartIndex3+1); 
			 
			   int IDInt=Integer.parseInt(id);
			   int EMRInt=Integer.parseInt(EMR);
			   int ECUInt=Integer.parseInt(ECU);
			   
			   if(EMRInt<=hardDisk) {
			          PCB pcb=new PCB(IDInt,"New",ECUInt,EMRInt,0,0,0);
			          NodeHD<PCB> pcb2=JQ.insert(pcb,EMRInt);
				      hardDisk=hardDisk-EMRInt;
				      NumOfProcess++;
				      SumJobSize+=EMRInt;
				      list.add(EMRInt);
				      System.out.println("Job inserted to Job Queue: ");
				      System.out.println("ID: "+pcb2.data.ID+" ECU: "+pcb2.data.ECU+" EMR: "+pcb2.data.EMR+" CUT: "+pcb2.data.CUT+" State: "+pcb2.data.State);
			         }else if(EMRInt>hardDisk) {
			        	 System.out.println("Can't add more job, the Hard Disk is full ");
			        	 AvailableSpaceInHD=ram.fullRAM(JQ);
			        	 hardDisk+=AvailableSpaceInHD;
			        	 System.out.println("The available space of Hard Disk after RAM= "+hardDisk);
			         }    
			   }
		   AvailableSpaceInHD=ram.fullRAM(JQ);
		   hardDisk+=AvailableSpaceInHD;
		   System.out.println("The available space of Hard Disk after RAM= "+hardDisk);
		   
		   br.close();
		   FR.close();
		   }catch(Exception ex){
			   
		   }
	 
	 
	 //=====================================Max & Min=================================
	 int [] a=new int[list.size()] ;
	 for(int i=0 ;i<list.size();i++) {
		 a[i]=list.get(i);
	 }
	 Arrays.sort(a);
	 MinJobSize=a[0];
	 MaxJobSize=a[a.length-1];
	}
	
        
}
