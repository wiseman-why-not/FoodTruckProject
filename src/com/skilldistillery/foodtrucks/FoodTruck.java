package com.skilldistillery.foodtrucks;

public class FoodTruck {

	// fields

	private int uniqueNumericID;
	private String foodTruckName;
	private String foodTruckType;
	private int numericRating;
	private static int nextUniqueNumericId = 1;

	// constructors

	public FoodTruck() {

	}

	public FoodTruck(String foodTruckName, String foodTruckType, int numericRating) {
		super();
		this.foodTruckName = foodTruckName;
		this.foodTruckType = foodTruckType;
		this.numericRating = numericRating;
		this.uniqueNumericID = nextUniqueNumericId;
		nextUniqueNumericId++;

	}

	// method

	@Override
	public String toString() {
		return "Food Truck's name is " + foodTruckName + ", type of food truck is " + foodTruckType
				+ ".\nThe rating is " + numericRating + " and " + "the Unique ID is " + uniqueNumericID + ".\n"
				+ "-------------------------------------------------------------";
	}

	public String getFoodTruckName() {
		return foodTruckName;
	}

	public void setFoodTruckName(String foodTruckName) {
		this.foodTruckName = foodTruckName;
	}

	public String getFoodTruckType() {
		return foodTruckType;
	}

	public void setFoodTruckType(String foodTruckType) {
		this.foodTruckType = foodTruckType;
	}

	public int getNumericRating() {
		return numericRating;
	}

	public void setNumericRating(int numericRating) {
		this.numericRating = numericRating;
	}

}
