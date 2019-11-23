package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {

	// fields
	private Scanner kb = new Scanner(System.in);
	private FoodTruck[] listOfFoodTrucks = new FoodTruck[5];

	// main
	public static void main(String[] args) {
		FoodTruckApp newFoodTruckApp = new FoodTruckApp();
		newFoodTruckApp.run();
	}

	// methods

	public void displayMenuOptions() {
		System.out.println("********************************************");
		System.out.println("*          FOOD TRUCK APPLICATION          *");
		System.out.println("********************************************");
		System.out.println("* 1: list all existing food trucks         *");
		System.out.println("* 2: see the average rating of food trucks *");
		System.out.println("* 3: display the highest-rated food truck  *");
		System.out.println("* 4: Quit the program                      *");
		System.out.println("********************************************");
	}

	public void run() {
		createFoodTruck();
		boolean keepGoing = true;
		do {
			displayMenuOptions();
			int userChoice = kb.nextInt();
			kb.nextLine();

			switch (userChoice) {
			case 1:
				displayFoodTruck();
				break;
			case 2:
				calculateFoodTruckAverage();
				break;
			case 3:
				findHighestRatedFoodTruck();
				break;
			case 4: // only when typing in 4 do the user breaks the loop and exit the application.
				System.out.println("Quitting the Food Truck Application!");
				keepGoing = false; 
				break;
			default:
				System.out.println("Are you testing me? Go back and select the correct number.");
				break;
			}

		} while (keepGoing);

	}

	public void createFoodTruck() {

		for (int i = 0; i < listOfFoodTrucks.length; i++) {
			System.out.println("Enter the food truck's name: ");
			String foodTruckName = kb.nextLine();
			if (foodTruckName.equalsIgnoreCase("quit")) {
				System.out.println("Done with adding Food Trucks");
				break;
			}

			System.out.println("What type of food is it: ");
			String foodTruckType = kb.nextLine();
			System.out.println("Rate the food truck from 1 - 10");
			int numericRating = kb.nextInt();
			kb.nextLine();
			while (!(numericRating >= 1 && numericRating <= 10)) {
				System.out.println("Rate the food truck from 1 - 10");
				numericRating = kb.nextInt();
				kb.nextLine();
			}
			FoodTruck newFoodTruck = new FoodTruck(foodTruckName, foodTruckType, numericRating);
			listOfFoodTrucks[i] = newFoodTruck;
		}

	}

	public void displayFoodTruck() {
		for (FoodTruck foodTruck : listOfFoodTrucks) {
			// if the food truck in the array is not null then.
			if (foodTruck != null) {
				System.out.println(foodTruck);
			} else {
			// if the array is null at this point, then just skip over it and restart the loop.
				continue;
			}
		}
	}

	public void calculateFoodTruckAverage() {
		double total = 0.0;
		int numberOfFoodTrucksInArray = 0;
		double calculatedAverage = 0;
		
		for (FoodTruck foodTruck : listOfFoodTrucks) {
			// if the food truck in the array is not null then.
			if (foodTruck != null) {
				total += foodTruck.getNumericRating();
				numberOfFoodTrucksInArray++;
			} else {
				continue;
			}
		}
		calculatedAverage = total / numberOfFoodTrucksInArray;
		System.out.println("The average rating for the food trucks is " + calculatedAverage);
	}

	public void findHighestRatedFoodTruck() {
		Integer largestNum = Integer.MIN_VALUE;
		String foodTruckwithHighestRating = "";
		for (FoodTruck foodTruck : listOfFoodTrucks) {
			// if the food truck in the array is not null then.
			if (foodTruck != null) {
				if (foodTruck.getNumericRating() > largestNum) {
					largestNum = foodTruck.getNumericRating();
					foodTruckwithHighestRating = foodTruck.getFoodTruckName();
				}
			} else {
				continue;
			}
		}
		System.out.println("The Food Truck with the highest rating is: " + foodTruckwithHighestRating + " with " + largestNum + ".");
	}

}
