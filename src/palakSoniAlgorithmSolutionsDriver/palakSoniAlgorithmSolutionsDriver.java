package palakSoniAlgorithmSolutionsDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class palakSoniAlgorithmSolutionsDriver {

	public static void printCompanyStockPriceAscendingOrder(Company[] comArr) {
		Arrays.sort(comArr);

		for (int i = 0; i < comArr.length; i++) {
			System.out.println(comArr[i].getStockPrice());
		}
	}

	public static void printCompanyStockPriceDescendingOrder(Company[] comArr) {
		Arrays.sort(comArr, Collections.reverseOrder());

		for (int i = 0; i < comArr.length; i++) {
			System.out.println(comArr[i].getStockPrice());
		}
	}

	public static void getTotalNoOfCompaniesPriceRoseToday(Company[] comArr) {
		int total = 0;

		for (int i = 0; i < comArr.length; i++) {
			if (comArr[i].getIsPriceRoseToday()) {
				total++;
			}
		}
		System.out.println("Total no of companies for which stock prices rose today is ::" + total);
	}

	public static void getTotalNoOfCompaniesPriceDeclinedToday(Company[] comArr) {
		int total = 0;

		for (int i = 0; i < comArr.length; i++) {
			if (!comArr[i].getIsPriceRoseToday()) {
				total++;
			}
		}
		System.out.println("Total no of companies for which stock prices declined today is ::" + total);
	}

	public static void searchSpecificStockPrice(Company[] comArr) {
		double keyValue;
		boolean iskeyValuePresent = false;

		System.out.println("Enetr key value");
		keyValue = new Scanner(System.in).nextDouble();

		for (int i = 0; i < comArr.length; i++) {
			if (comArr[i].getStockPrice() == keyValue) {
				iskeyValuePresent = true;
				break;
			}

		}

		if (iskeyValuePresent) {
			System.out.println("Stock of value " + keyValue + " present");
		}else {
			System.out.println("Stock of value "+keyValue+" not present");
		}
	}
	
	

	public static void main(String args[]) {
		int noOfCompanies;

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the no of companies");
		noOfCompanies = s.nextInt();

		Company[] comArr = new Company[noOfCompanies];
		for (int i = 0; i < noOfCompanies; i++) {
			Company com = new Company();
			System.out.println("Enter current stock price of the company ::" + (i + 1));
			com.setStockPrice(s.nextDouble());

			System.out.println("Whether company's stock price rose today compare to yesterday?");
			com.setIsPriceRoseToday(s.nextBoolean());

			comArr[i] = com;
		}

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");

		System.out.println("--------------------------------------------------------------------------------");

		int userInput = s.nextInt();
		switch (userInput) {
		case 1: {
			printCompanyStockPriceAscendingOrder(comArr);
			break;
		}

		case 2: {
			printCompanyStockPriceDescendingOrder(comArr);
			break;
		}

		case 3: {
			getTotalNoOfCompaniesPriceRoseToday(comArr);
			break;
		}

		case 4: {
			getTotalNoOfCompaniesPriceDeclinedToday(comArr);
			break;
		}

		case 5: {
			searchSpecificStockPrice(comArr);
			break;
		}

		case 6: {
			System.exit(0);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + userInput);
		}

	}
}
