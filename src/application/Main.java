package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enuns.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter departament's name: ");
		String departament = sc.nextLine();
		System.out.println();

		System.out.println("Enter worker data:");

		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(departament));

		System.out.print("How many contracts to this worker?: ");
		int cont = sc.nextInt();

		for (int i = 1; i <= cont; i++) {
			System.out.println("Enter contract #" + i + " data:");

			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int hours = sc.nextInt();

			worker.addContract(new HourContract(date, valuePerHour, hours));

		}

		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int c_moth =  Integer.parseInt(monthAndYear.substring(0,2));
		int c_year =  Integer.parseInt(monthAndYear.substring(3));	

		

		

		System.out.println();
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Level: "+worker.getLevel());
		System.out.printf("Income for " + monthAndYear+": $%.2f",worker.income(c_year, c_moth));
		

		sc.close();
	}

}
