package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Employee;

public class Program2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String path = "C://Users//gesio//OneDrive//Área de Trabalho//in.txt";

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			List<Employee> employees = new ArrayList<>();

			String nextLine = br.readLine();

			while (nextLine != null) {

				String[] columns = nextLine.split(";");

				employees.add(new Employee(columns[0], columns[1], Double.parseDouble(columns[2])));

				nextLine = br.readLine();
			}

			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			
			Comparator<Employee> comp = (emp1, emp2) -> emp1.getEmail().toUpperCase()
					.compareTo(emp2.getEmail().toUpperCase());
			
			System.out.println("Email of people whose salary is more than " + salary + ":");
			
			List<String> emails = employees
					.stream()
					.filter(e -> e.getSalary() > salary)
					.sorted(comp)
					.map(e -> e.getEmail())
					.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
			
			Double sum = employees
					.stream()
					.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (x , y) -> x + y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch ( InputMismatchException e) {
			System.out.println("Error: Please enter a correct character");
		}
		
		sc.close();
	}

}
