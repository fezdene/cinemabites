import java.io.*;
import java.util.*; 

public class DrinkFileReader {
    // Scanner Which Takes Information From Txt File And Places Into An Array
    private Scanner drinkScan;
    // Array Name Which Takes From The Drink Class
    ArrayList<Drinks> drinks = new ArrayList<Drinks>();
    String[]arrayDrink = new String[1];
    String dName;
    double dPrice;
    // Name Of The Txt File
    String drinkFile = "DrinkList.txt";
    String line;
    Drinks items;
    
    // Opens The Txt File
    public void openFile(){
        try{
            drinkScan = new Scanner(new File(drinkFile));
        } catch(Exception e){
            System.out.printf("Could Not Find The File %s", drinkFile);
        }
    }
    
    // Reads The Data Within The Txt File And Splits Data At every ';' into An Array
    public void readFile(){
        while (drinkScan.hasNextLine()){
            
            line = drinkScan.nextLine();
            arrayDrink = line.split(";");
            dName = arrayDrink[0];
            dPrice = Double.parseDouble(arrayDrink[1]);
            
            items = new Drinks(dName, dPrice);
            drinks.add(items);
            
        }
    }
    // Closes The File
    public void closeFile(){
        drinkScan.close();
    }
    // Returns All Drink Names Within The Array
    public String[] displayAllDrinks(){
        String[] toRet = new String[drinks.size()];
        for (int i=0; i < drinks.size(); i++){
            toRet[i] = drinks.get(i).getDrinkName();
        }
        return toRet;
    }
    // Returns A Drink From The Array List Depending On It's Index
    public String displayDrink(int index){
        return drinks.get(index).getDrinkName();
    }
    // Returns The Drink Price From A Specific Drink Depending On The Index Entered
    public double displayDrinkPrice(int index){
        return drinks.get(index).getDrinkPrice();
    }

}
