import java.io.*;
import java.util.*;

public class SnackFileReader {
    // Scanner Which Takes Information From Txt File And Stores Them Into Arrays
    private Scanner snackScan;
    // Array List From The Snacks Class
    ArrayList<Snacks> snacks = new ArrayList<Snacks>();
    String[]arrySnack = new String[1];
    // Initilisation For The Varialbes That Will Be Stored Inside The Array Class
    String sName;
    double sPrice;
    String snackFile = "SnackList.txt";
    String line;
    Snacks items;
    
    // Opens The File So That It Can Be Ready For It To Be Read
    public void openFile(){
        try{
            snackScan = new Scanner(new File(snackFile));
        } catch(Exception e){
            System.out.printf("Could Not Find The File %s", snackFile);
        }
    }
    // Reads The Data From The Txt File And Stores The Data Into Arrays seperated by a ';'
    public void readFile(){
        while (snackScan.hasNextLine()){
            
            line = snackScan.nextLine();
            arrySnack = line.split(";");
            sName = arrySnack[0];
            sPrice = Double.parseDouble(arrySnack[1]);
            
            items = new Snacks(sName, sPrice);
            snacks.add(items);
            
        }
    }
    // Closes The File After Data Has Been Extracted From The Txt File
    public void closeFile(){
        snackScan.close();
    }
    // Returns All The Snacks Within The Snack Array
    public String[] displayAllSnacks(){
        String[] toRet = new String[snacks.size()];
        for (int i=0; i < snacks.size(); i++){
            toRet[i] = snacks.get(i).getSnackName();
        }
        return toRet;
    }
    // Returns A Snack Name From The Array Depending On It's Index
    public String displaySnack(int index){
        return snacks.get(index).getSnackName();
    }
    // Returns A Snack Price From The Array Depending On It's Index
    public double displaySnackPrice(int index){
        return snacks.get(index).getSnackPrice();
    }
    
}
