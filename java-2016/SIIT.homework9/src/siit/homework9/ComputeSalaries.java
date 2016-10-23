package siit.homework9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ComputeSalaries {

	public void readFromFile(String source) throws IOException {

		File file = new File(source);
		if (!file.exists()) {
			System.out.println("No file.");
		} else {
			try (BufferedReader in = new BufferedReader(new FileReader(file))) {
				String sCurrentLine;
				while ((sCurrentLine = in.readLine()) != null) {
					String[] tokens = splitLineToString(sCurrentLine);
					Employee emp = new Employee();
					setEmployeeData(tokens, emp);
					calculateSalary(emp);
				}
			}
		}
	}

	/**
	 * @param emp
	 * @return 
	 */
	int calculateSalary(Employee emp) {
		int salary = 0;
		int bonuses = 0;
		int total = 0;
		switch (emp.getPoz()) {
		case MANAGER:
			salary = 40 * (emp.getWorkedHours() + emp.getDaysOff() * 8);
			bonuses = 30 * emp.getPostpaidSales() + 15 * emp.getPrepaidSales();
			total = salary + bonuses;
			break;
		case SENIOR_SALES_OFFICER:
			salary = 20 * (emp.getWorkedHours() + emp.getDaysOff() * 8);
			bonuses = 50 * emp.getPostpaidSales() + 25 * emp.getPrepaidSales();
			total = salary + bonuses;
			break;
		case SALES_OFFICER:
			salary = 10 * (emp.getWorkedHours() + emp.getDaysOff() * 8);
			bonuses = 25 * emp.getPostpaidSales() + 10 * emp.getPrepaidSales();
			total = salary + bonuses;
			break;
		}
		System.out.println(emp.getName() + " - " + total);
		return total;
	}

	/**
	 * @param sCurrentLine
	 * @return
	 */
	String[] splitLineToString(String sCurrentLine) {
		String[] tokens = sCurrentLine.split("[|]", 6);
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].isEmpty()) {
				tokens[i] = "0";
			}
		}
		return tokens;
	}

	/**
	 * @param tokens
	 * @param emp
	 */
	void setEmployeeData(String[] tokens, Employee emp) {
		emp.setName(tokens[0]);
		if (tokens[1].compareTo("Sales Manager") == 0) {
			emp.setPoz(JobPosition.MANAGER);
		}else if(tokens[1].compareTo("Senior Sales Officer") == 0){
			emp.setPoz(JobPosition.SENIOR_SALES_OFFICER);
		}else if(tokens[1].compareTo("Sales Officer") == 0){
			emp.setPoz(JobPosition.SALES_OFFICER);
		}else{
			System.out.println("For employee " + tokens[0] + " role not correct:" + tokens[1]);
		}
		emp.setWorkedHours(Integer.parseInt(tokens[2]));
		emp.setDaysOff(Integer.parseInt(tokens[3]));
		emp.setPrepaidSales(Integer.parseInt(tokens[4]));
		emp.setPostpaidSales(Integer.parseInt(tokens[5]));
		//System.out.println(emp.toString());
	}

}
