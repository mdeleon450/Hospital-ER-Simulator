
public class HospitalERSim {

	public static void main(String[] args) {
		Patients[] patientList = new Patients[15]; // Create a List of 15 Patients
		int randHour = ((int) (Math.random() * 24)); // Generates a random hour for the simulation (24 hour clock)
		initializePatients(patientList, randHour); // Initializes List and Sorts by Time Arrived
		PriorityQueue patientQueue = new PriorityQueue(patientList.length); // Creates a priority queue of the same size
																			// as there are patients
		// print(patientList); //Used this to see how patients were arriving
		startSimulation(patientList, patientQueue, randHour); // Starts the simulation using the sorted patientlist the
																// new priority queue and the hour
	}

	public static void initializePatients(Patients[] patientsList, int randHour) {
		// Method populates the array with patients with random minute arrivals
		patientsList[0] = (new Patients("John", "Doe", "Heart Attack", "" + randHour, (int) (Math.random() * 59), 1));
		patientsList[1] = (new Patients("Wilt", "Carlyn", "Chest Pain", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[2] = (new Patients("Jolie", "Lita", "Minor Cut", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[3] = (new Patients("Simon", "Emersyn", "Abdominal Pain", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[4] = (new Patients("Hepsie", "Dolly", "Broken Bones", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[5] = (new Patients("Dottie", "Syd", "Shortness of Breath", "" + randHour,
				(int) (Math.random() * 59), 1 + (int) (Math.random() * 19)));
		patientsList[6] = (new Patients("Fredrick", "Flynn", "Headache", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[7] = (new Patients("Warner", "Blanche", "Swelling", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[8] = (new Patients("Roxanne", "Rose", "Heart Attack", "" + randHour, (int) (Math.random() * 59),
				1));
		patientsList[9] = (new Patients("Wilson", "Gabriel", "Minor Cut", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[10] = (new Patients("Lori", "Giselle", "Abdominal Pain", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[11] = (new Patients("Edward", "Rivera", "Chest Pain", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[12] = (new Patients("John", "Marshall", "Headache", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[13] = (new Patients("Kelly", "Boyce", "Broken Bones", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		patientsList[14] = (new Patients("Stephanie", "Nicole", "Chest Pain", "" + randHour, (int) (Math.random() * 59),
				1 + (int) (Math.random() * 19)));
		sortByTime(patientsList); // calls the method to sort this newly populated array
		// print(patientsList);
	}

	// Method that Sorts an Array Using bubble sort
	public static void sortByTime(Patients[] patientsList) {
		for (int i = 0; i < patientsList.length - 1; i++) {
			for (int j = 0; j < patientsList.length - i - 1; j++) {
				if (patientsList[j].getArrTime() > patientsList[j + 1].getArrTime()) {
					Patients temp = patientsList[j];
					patientsList[j] = patientsList[j + 1];
					patientsList[j + 1] = temp;
				}
			}
		}
	}

	// Helper Method that assisted in printing the patient array
	public static void print(Patients[] patientsList) {
		for (int i = 0; i < patientsList.length; i++) {
			System.out.println(patientsList[i]);
		}
	}

	// Method that simulates the arrival of patients and attends them based on both
	// priority and time of arrival
	public static void startSimulation(Patients[] patientsList, PriorityQueue patientsQueue, int randHour) {
		int j = 0;
		for (int i = 0; i < 60; i++) {
			if (j < patientsList.length) {
				int pMinute = patientsList[j].getArrTime();
				if (pMinute <= i) {
					patientsQueue.offer(patientsList[j]);
					j++;

				} else if (!patientsQueue.isEmpty()) {
					if (i + 1 < 10) {
						Patients temp = patientsQueue.poll();
						i += 1;
						temp.setTimeAttend(randHour + ":0" + (i));
						System.out.println("Patient Attended: " + temp);
					} else {
						Patients temp = patientsQueue.poll();
						i += 1;
						temp.setTimeAttend(randHour + ":" + (i));
						System.out.println("Patient Attended: " + temp);
					}
				}
			}
			else if (!patientsQueue.isEmpty()) {
				Patients temp = patientsQueue.poll();
				i += 1;
				temp.setTimeAttend(randHour + ":" + (i));
				System.out.println("Patient Attended: " + temp);
			}
		}
	}
}
