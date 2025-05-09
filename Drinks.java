
public class Drinks {
	// Initialisation For Drink Name & Price
	private String drinkName;
	private double drinkPrice;
	// Takes A Drink Name & Price As Parameters For This Constructor
	public Drinks(String drinkN, double drinkP){
		drinkName = drinkN;
		drinkPrice = drinkP;
	}
	// Gets The Drink Name
	public String getDrinkName(){
		return drinkName;
	}
	// Gets The Drink Price
	public double getDrinkPrice(){
		return drinkPrice;
	}
}
