
public class Film {
	
	// Variables For Film Attributes
	private String filmName;
	private int noSeats;
	private double childTicketPrice;
	private double adultTicketPrice;
	private String ageRating;
	private String theatreNumber;
	private String timeOfShow;
	private String filmAddress;
	private String filmDate;
	
	// Constructor Which Takes Films Attributes
	public Film(String film, String age, double adultTicket, double childTicket, int roomCap, String theatre, String showTime,
			String filmLocation, String dateOfFilm){
		
		filmName = film;
		noSeats = roomCap;
		childTicketPrice = childTicket;
		adultTicketPrice = adultTicket;
		ageRating = age;
		theatreNumber = theatre;
		timeOfShow = showTime;
		filmAddress = filmLocation;
		filmDate = dateOfFilm;
		
	}
	
	// Returns  Film Name
	public String getFilm(){
		return filmName;
	}
	// Returns Price For Child Ticket
	public double getChildTicketPrice(){
		return childTicketPrice;
	}
	// Returns Price For Adult Tickets
	public double getAdultTicketPrice(){
		return adultTicketPrice;
	}
	// Returns Seats Available That Film
	public int getRoomCapacity(){
		return noSeats;
	}
	// Returns Age Rating For Film
	public String getAgeRating(){
		return ageRating;
		}
	// Returns Theatre Number For Film
	public String getTheatreNumber(){
		return theatreNumber;
	}
	// Returns Time Of Film
	public String getTimeOfShow(){
		return timeOfShow;
	}
	// Returns The Image Location For The Film Selected
	public String getFilmAddress(){
		return filmAddress;
	}
	// Returns The Date Of The Film Selected
	public String getFilmDate(){
		return filmDate;
	}

}





