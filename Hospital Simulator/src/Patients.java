//Author: Maik De Leon Lopez
public class Patients {
	//Data Fields
	private String firstName;
	private String lastName;
	private String medCondition;
	private String hourArrived;
	private int arrTime;
	private String timeAttend;
	private int urgency;
	
	//Constructor
	public Patients(String first, String last, String condition, String hourArrived, int timeEntered, int priority) {
		this.firstName = first;
		this.lastName = last;
		this.medCondition = condition;
		this.arrTime = timeEntered;
		this.hourArrived = hourArrived;
		this.urgency = priority;
	}
	
	// Helper Methods
	public int getUrgency() {
		return this.urgency;
	}
	
	public int getArrTime() {
		return this.arrTime;
	}
	
	public void setTimeAttend(String attendTime) {
		this.timeAttend = attendTime;
	}
	
	public String toString() {
		if(arrTime < 10) {
			return "First Name: "+firstName+" Last Name: "+lastName+
				" Medical Condition: "+medCondition+ " Arrival Time: "+hourArrived+":0"+arrTime+" Time Attended: "+timeAttend+" Urgency: "+urgency;
		}
		else {
			return "First Name: "+firstName+" Last Name: "+lastName+
					" Medical Condition: "+medCondition+ " Arrival Time: "+hourArrived+":"+arrTime+" Time Attended: "+timeAttend+" Urgency: "+urgency;
		}
	}
}
