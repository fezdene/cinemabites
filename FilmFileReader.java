import java.io.*;
import java.util.*;
public class FilmFileReader {
	// Scanner To Take Data From Text File
	private Scanner movieScan;
	
	// Creates Array 
	ArrayList<Film> movie = new ArrayList<Film>();
	String[]keyword = new String[8];
	// Initilisation Of Variables
	String fName, fRating, fTheatreRoom, fTime, fLocation, fDate;
	int fCapacity;
	double fAdultTicket, fChildTicket;
	String movieFile = "MovieList.txt";
	String line;
	Film shogun;
	
	// Opens Txt File Which Contains The Movies
	public void openFile(){
		try{
			movieScan = new Scanner(new File(movieFile));
		}
		catch(Exception e){
			// Create Dialog Window To Print Error!
			System.out.printf("Could Not Find the File %s", movieFile);
		}
	}
	
	// Reads The Data Within The Text File And Splits Data After every ';'
	public void readFile(){
		while (movieScan.hasNextLine()){
			
			line = movieScan.nextLine();
			keyword = line.split("; ");
			fName = keyword[0];
			fRating = keyword[1];
			fAdultTicket = Double.parseDouble(keyword[2]);
			fChildTicket = Double.parseDouble(keyword[3]);
			fCapacity = Integer.parseInt(keyword[4]);
			fTheatreRoom = keyword[5];
			fTime = keyword[6];
			fLocation = keyword[7];
			fDate = keyword[8];
			
			
			shogun = new Film(fName, fRating, fAdultTicket, fChildTicket, fCapacity, fTheatreRoom, fTime, fLocation, fDate);
			movie.add(shogun);
		}
	}
	
	// Closes File 
	public void closeFile(){
		movieScan.close();
	}
	
	// Returns All The Films Stored In The Array
	public String[] displayAllFilms(){
		String[] toRet = new String[movie.size()];
		for (int i=0; i < movie.size(); i++){
			toRet[i] = movie.get(i).getFilm();
		}
		return toRet;
	}
	// Returns A Film Name Depending On Index Proivded For The Array
	public String displayFilmName(int index){
		return movie.get(index).getFilm();
	}
	// Returns A Film Rating Depending On Index Proivded For The Array
	public String displayFilmRating(int index){
		return movie.get(index).getAgeRating();
	}
	// Returns A Film's Adult Ticket Price Depending On Index Within The Array
	public double displayAdultTicket(int index){
		return movie.get(index).getAdultTicketPrice();
	}
	// Returns A Film's Child Ticket Price Depending On Index Within The Array
	public double displayChildTicket(int index){
		return movie.get(index).getChildTicketPrice();
	}
	// Returns A Film's Available Seats
	public int displayNumberOfSeats(int index){
		return movie.get(index).getRoomCapacity();
	}
	// Returns A Film's Theatre Room Depending On The Index
	public String displayTheatreRoom(int index){
		return movie.get(index).getTheatreNumber();
	}
	// Returns The Time Of Show For A Movie In The Array Depending On The Index
	public String displayTimeOfShow(int index){
		return movie.get(index).getTimeOfShow();
	}
	// Returns The Image Name For It To Be Used As A Path
	public String displayFilmImage(int index){
		return movie.get(index).getFilmAddress();
	}
	// Returns The Date In Which A Film Will Show Depending On The Index
	public String displayFilmDate(int index){
		return movie.get(index).getFilmDate();
	}
}

