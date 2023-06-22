package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Product;

public class Program1 {

	public static void main(String[] args) {

		String path = "C://Users//gesio//OneDrive//Área de Trabalho//in.txt";

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			List<Product> products = new ArrayList<>();

			String nextLine = br.readLine();

			while (nextLine != null) {

				String[] columns = nextLine.split(",");

				System.out.println(columns[0] + " - " + columns[1]);

				products.add(new Product(columns[0], Double.parseDouble(columns[1])));
				
				nextLine = br.readLine();
			}
			
			Double average = products.stream().map(p -> p.getPrice()).reduce(0.0, (x , y) -> x + y) / products.size();
			
			System.out.println("Average price - " + String.format("%.2f", average));
			
			Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			
			List<String> names = products
				.stream()
				.filter(p -> p.getPrice() < average)
				.sorted(comp.reversed())
				.map(p -> p.getName())
				.collect(Collectors.toList());
			
			names.forEach(System.out::println);
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
