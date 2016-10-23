package siit.homework9;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		ComputeSalaries compute = new ComputeSalaries();

		try {
			compute.readFromFile("D:\\Java SPACE\\SIIT\\src\\siit\\homework9\\sales-team.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
