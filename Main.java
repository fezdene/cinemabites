import javax.swing.JFrame; 
public class Main {

	public static void main(String[] args) {
		

		// Calling GUI Class & Setting Size Of The Screen	
		FirstPageGui mainFrame = new FirstPageGui();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(610,565);
		mainFrame.setVisible(true);
		
		
		
	}

}
