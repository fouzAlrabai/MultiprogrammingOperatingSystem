package multiprogramingOS;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.awt.List;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;;

public class OS {
	
	public static void main(String [] arg) {
	int jobID=1; //ID OF JOB
	hardDisk HD=new hardDisk();
	
	String fileLocation=("Jobs.txt");
	File file = new File(fileLocation);
	
	   try {
	   System.out.println("Generate the Job.txt file");
	   FileWriter FW=new FileWriter(file);
	   System.out.println("Write in the Job.txt file");
	   for(int i=0 ; i<100 ; i++) {
		   Job job=new Job(jobID);
		   FW.write("The Job ID Is:"+job.getJID()+", The ECU Is:"+job.getECU()+", The EMR Is:"+job.getEMR()+"\n");
		   jobID++;
	   }
	       FW.close();
	   }catch(Exception ex){
		   
	   }
	   
	   System.out.println("After generated the Job.txt file");
	   HD.ReadFile(fileLocation);
	   
	   System.out.println("Total number of jobs processed = "+HD.NumOfProcess);
	   System.out.println("Average job size in KB = "+(HD.SumJobSize/HD.NumOfProcess));
	   System.out.println("Max job size in KB = "+HD.MaxJobSize);
	   System.out.println("Min job size in KB = "+HD.MinJobSize);
	   System.out.println("Number of jobs that completed Normal = "+CPU.norIter);
	   System.out.println("Number of jobs that completed Abnormal = "+CPU.abnormInter);
	   
	 //=========================Write Results==============================================
	   
	   File file2 = new File("Results.txt");
	   try {
		   System.out.println("Generate the  Results.txt file");
	   FileWriter FW=new FileWriter(file2);
	       System.out.println("Write in the Results.txt file");
	       FW.write("The Total number of jobs processed : "+HD.NumOfProcess+"\n");
	       FW.write("The Average of job size in KB: "+(HD.SumJobSize/HD.NumOfProcess)+ "\n");
	       FW.write("The Minimum of job size in KB: " +HD.MinJobSize +"\n"); 
	       FW.write("The Maximum of job size in KB: "+HD.MaxJobSize+ "\n");
	       FW.write("Number of jobs that completed normally is : " +CPU.norIter +"\n"); 
	       FW.write("Number of jobs that completed abnormally is : "+CPU.abnormInter+ "\n");
	       
	       FW.close();
	   }catch(Exception ex){
		   
	   }
	     
	}

}
