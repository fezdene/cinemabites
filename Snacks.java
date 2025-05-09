
public class Snacks {
	// Initialisation For Attributes For A Snack
	private String snackName;
	private double snackPrice;

	// Constructor Which Takes Snack Name And Price As Parameters
	public Snacks(String snackN, double snackP){
		snackName = snackN;
		snackPrice = snackP;
	}
	// Returns The Name Of The Snack
	public String getSnackName(){
		return snackName;
	}
	// Returns The Price Of The Snack
	public double getSnackPrice(){
		return snackPrice;
	}
	
}
