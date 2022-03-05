package programs;

 public class CPUProcess{
	int startTime;
	int endTime;
	int noOfCPU;
	
	public CPUProcess() {
		
	}
	public CPUProcess(int startTime, int endTime, int noOfCPU) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.noOfCPU = noOfCPU;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getNoOfCPU() {
		return noOfCPU;
	}
	public void setNoOfCPU(int noOfCPU) {
		this.noOfCPU = noOfCPU;
	}
	
	
}
