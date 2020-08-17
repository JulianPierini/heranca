package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxPayers = new ArrayList<>(); 
		
		System.out.print("Enter the number of tax payers: ");
		int numberOfTaxPayers = sc.nextInt();
		
		for(int i=1; i <=numberOfTaxPayers; i++) {
			System.out.println("Tax payer #" +i+" data:");
			System.out.print("Individual or company (i/c)? ");
			char payerType = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if (payerType == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenses = sc.nextDouble();
				taxPayers.add(new Individual(name, anualIncome, healthExpenses));
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
			
		}
		
	
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double sumTax = 0.0;
		
		for (TaxPayer payer : taxPayers) {
			double tax = payer.tax();
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", tax));
			sumTax += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sumTax));
		
		
		sc.close();

	}

}
